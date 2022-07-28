import java.io.*;
import java.util.HashMap;

public class checkoutTracker {



    BufferedReader br = null;
   Integer[] header = null;
   CheckOutAble[] colVal = null;
   
    int count = 0;
    HashMap<Integer, CheckOutAble> checkoutLog = new HashMap<Integer, CheckOutAble>();
   
    

    //Constructor
    public checkoutTracker(HashMap<Integer, CheckOutAble> checkoutLog) {
        this.checkoutLog = checkoutLog;

        try {
            //read checkoutLog.csv
            br = new BufferedReader(new FileReader("checkoutLog.csv"));
            
            
            //Add to hashmap
            while (count < header.length){
                checkoutLog.put(header[count], colVal[count]);
        
                count++;
            }

        } catch (Exception e){
    
            e.printStackTrace();
        }
        

        
    }

    public void checkOutItem(int itemID, int userID){

    }

    public boolean renewItem(int itemID, int userID){
        //placeholder
        return true;

    }

    public boolean checkOutStandingRequest(int itemID, int userID){
        //placeholder
        return true;

    }

    public void returnItem(int itemID, int userID){

    }

    public double outStandingFine (int userID){
        //placeholder
        return userID;

    }



    

    
    
   

  
}
