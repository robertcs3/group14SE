import java.io.*;
import java.net.IDN;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class checkoutTracker {



    BufferedReader br = null;
   
    int count = 0;
    HashMap<Integer, ArrayList<CheckOutAble>> checkoutLog = new HashMap<Integer, ArrayList<CheckOutAble>>();

    //Constructor
    public checkoutTracker() {
        try {
            //read checkoutLog.csv
            br = new BufferedReader(new FileReader("checkoutLog.csv"));
            String line = "";
            int counter = 0;
            while((line = br.readLine()) != null)
            {
                String[] logLine = line.split(",");
                //Date will always be even index number
                //Item ID will always be odd index number
                int id = Integer.parseInt(logLine[0]);
                ArrayList<CheckOutAble> items = new ArrayList<CheckOutAble>();
                for(int i = 1; i < logLine.length; i++ )
                {
                    Date checkoutDate = new SimpleDateFormat("mm/dd/yyyy").parse(logLine[i]);
                    i += 1;
                    CheckOutAble itemToAdd = this.item(Integer.parseInt(logLine[i]));
                    itemToAdd.setDateCheckout(checkoutDate);
                    items.add(itemToAdd);
                }
                checkoutLog.put(id,items);
            }

        } catch (Exception e){
    
            e.printStackTrace();
        }

        
    }

    
    public void checkOutItem(int userID, ArrayList<CheckOutAble> itemID){
        checkoutLog.put(userID, itemID);
    }

    public boolean renewItem(int itemID, int userID){
        //placeholder
        return true;

    }

    public boolean checkOutStandingRequest(int itemID, int userID){
        //placeholder
        return true;

    }
    
            
    
    //Return an item
    public void returnItem(int itemID, int userID){
        //Contains userID
        if (checkoutLog.containsKey(userID)) {
            //Initialize temp arraylist
            ArrayList<CheckOutAble> newItems = new ArrayList<>();
            //Iterate through checked out items
            for (CheckOutAble item : checkoutLog.get(userID)) {
               
                if (item.getID() == itemID) {
                    System.out.println("Item ID is returned.");
                    continue;
                }
                 //Add unmatched itemID to newItems
                newItems.add(item);
            }
            //Update checked out items if needed
            if (newItems.size() != checkoutLog.get(userID).size()){
                checkoutLog.put(userID, newItems);
            }else{
                System.out.println("Invalid item ID");
            } 
        } else {
            System.out.println("Invalid user ID.");
        }
        }
        
           
        

    

    public double outStandingFine (int userID){
        //placeholder


        return userID;

    }


    private CheckOutAble item(int itemID)
    {
        //Store in 2 arraylist: userIDList and passwordList
        try
        {
            String line = "";
            //Check item is in book
            BufferedReader fileReader = new BufferedReader(new FileReader("book.csv"));
            while((line = fileReader.readLine()) != null)
            {
                String[] itemLine = line.split(",");
                int id = Integer.parseInt(itemLine[0]);
                if(id == itemID)
                    return new book(id, itemLine[1], Integer.parseInt(itemLine[2]), Integer.parseInt(itemLine[3]),Boolean.parseBoolean(itemLine[4]));
            }
            fileReader.close();

            //Check item is in video
            fileReader = new BufferedReader(new FileReader("video.csv"));
            while((line = fileReader.readLine()) != null)
            {
                String[] itemLine = line.split(",");
                int id = Integer.parseInt(itemLine[0]);
                if(id == itemID)
                    return new video(id, itemLine[1], Integer.parseInt(itemLine[2]), Integer.parseInt(itemLine[3]) );
            }
            fileReader.close();

            //Check item is in audio
            fileReader = new BufferedReader(new FileReader("audio.csv"));
            while((line = fileReader.readLine()) != null)
            {
                String[] itemLine = line.split(",");
                int id = Integer.parseInt(itemLine[0]);
                if(id == itemID)
                    return new audio(id, itemLine[1], Integer.parseInt(itemLine[2]),Integer.parseInt(itemLine[3]) );
            }
            fileReader.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args)//Temporary for testing
    {

    
        
        
    }

    
    
   

  
}
