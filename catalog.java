import java.awt.print.Book;
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
        try{
            // reading in data from book.csv
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

        try{
            // reading in data from audio.csv
            br = new BufferedReader(new FileReader("audio.csv"));
            String line = "";

            while((line = br.readLine()) != null){
                String[] logLine = line.split(",");

                // Reading in values to for item objects (audio)

            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // checking that an item with specific item ID exists in the catalog
    public boolean itemChecker(int itemID){
        boolean exists = true;
        return exists;
    }

    // Displays catalog helper function
    public void showCatalog(){
        // placeholder (implementation needed)
    }

    public boolean requestItem(int itemID){
        boolean x = true;
        return x;
    }
}
