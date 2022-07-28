import java.util.ArrayList;

public class catalog {

    // Initializing Both array lists to store the Items. Both types check-out-able
    // and un-check-out-able will be included in the catalog

    private ArrayList<CheckOutAble> checkOutAbleList = new ArrayList<CheckOutAble>();
    private ArrayList<UnCheckoutAble> unCheckoutAbleList = new ArrayList<UnCheckoutAble>();


    public catalog(){
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
