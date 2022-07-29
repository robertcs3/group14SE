import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class catalog {

    BufferedReader br = null;
    // Initializing Both array lists to store the Items. Both types check-out-able
    // and un-check-out-able will be included in the catalog

    private ArrayList<CheckOutAble> checkOutAbleList = new ArrayList<CheckOutAble>();
    private ArrayList<UnCheckoutAble> unCheckoutAbleList = new ArrayList<UnCheckoutAble>();


    public catalog(){

        // reading in data from book.csv
        try{
            br = new BufferedReader(new FileReader("book.csv"));
            String line = "";

            while((line = br.readLine()) != null){
                String[] logLine = line.split(",");

                // Reading in values to form item objects (books)
                int id = Integer.parseInt(logLine[0]);
                String name = logLine[1];
                int value = Integer.parseInt(logLine[2]);
                int copies = Integer.parseInt(logLine[3]);
                boolean bestSeller = Boolean.parseBoolean(logLine[4]);

                // now create a new book and add it
                book newBook = new book(id, name, value, copies, bestSeller);
                checkOutAbleList.add(newBook);

                // new line should kick off next book entry until EOF
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // reading in data from audio.csv
        try{
            br = new BufferedReader(new FileReader("audio.csv"));
            String line = "";

            while((line = br.readLine()) != null){
                String[] logLine = line.split(",");

                // Reading in values to for item objects (audio)
                int id = Integer.parseInt(logLine[0]);
                String name = logLine[1];
                int value = Integer.parseInt(logLine[2]);
                int copies = Integer.parseInt(logLine[3]);

                // now create a new audio item and add it
                audio newAudio = new audio(id, name, value, copies);
                checkOutAbleList.add(newAudio);

                // new line should kick off next audio entry until EOF
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // reading in data from video.csv
        try{
            br = new BufferedReader(new FileReader("video.csv"));
            String line = "";

            while((line = br.readLine()) != null){
                String[] logLine = line.split(",");

                // Reading in values to for item objects (video)
                int id = Integer.parseInt(logLine[0]);
                String name = logLine[1];
                int value = Integer.parseInt(logLine[2]);
                int copies = Integer.parseInt(logLine[3]);

                // now create a new video item and add it
                video newVideo = new video(id, name, value, copies);
                checkOutAbleList.add(newVideo);

                // new line should kick off next video entry until EOF
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // reading in data from magazine.csv
        try{
            br = new BufferedReader(new FileReader("magazine.csv"));
            String line = "";

            while((line = br.readLine()) != null){
                String[] logLine = line.split(",");

                // Reading in values to for item objects (magazine)
                int id = Integer.parseInt(logLine[0]);
                String name = logLine[1];
                int value = Integer.parseInt(logLine[2]);

                // now create a new magazine item and add it (can not be checked out)
                magazine newMagazine = new magazine(id,name,value);
                unCheckoutAbleList.add(newMagazine);

                // new line should kick off next magazine entry until EOF
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // reading in data from reference.csv
        try{
            br = new BufferedReader(new FileReader("reference.csv"));
            String line = "";

            while((line = br.readLine()) != null){
                String[] logLine = line.split(",");

                // Reading in values to for item objects (reference)
                int id = Integer.parseInt(logLine[0]);
                String name = logLine[1];
                int value = Integer.parseInt(logLine[2]);

                // now create a new reference item and add it (can not be checked out)
                referenceBook newReference = new referenceBook(id, name, value);
                unCheckoutAbleList.add(newReference);

                // new line should kick off next reference entry until EOF
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // checking that an item with specific item ID exists in the catalog
    public boolean itemChecker(int itemID) {
        // checking list of check-out-able items first (lists may not be same size)

        for (int index = 0; index < checkOutAbleList.size(); ++index) {
            if (checkOutAbleList.get(index).getID() == itemID) {
                return true;
            }
        }

        //checking list of un-check-out-able items second (lists may not be same size)
        for (int index = 0; index < unCheckoutAbleList.size(); ++index){
            if (unCheckoutAbleList.get(index).getId() == itemID){
                return true;
            }
        }

        // base case id was not found in catalog across both lists
        return false;
    }


    // Displays catalog helper function
    public ArrayList<CheckOutAble> showCatalog(){
        // placeholder (implementation needed)
        return checkOutAbleList;
    }

    public CheckOutAble getItem(int itemID)
    {
        if(itemChecker(itemID))
        {
            return checkOutAbleList.get(checkOutAbleList.indexOf(itemID));
        }
        return null;
    }

    public boolean copiesDecrement(int itemID){
        for(int index = 0; index < checkOutAbleList.size(); ++index){
            if(checkOutAbleList.get(index).getID() == itemID){
                if(checkOutAbleList.get(index).getCopies() >= 1){
                    checkOutAbleList.get(index).decreaseCopy(1);
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
}
