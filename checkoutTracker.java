import java.util.HashMap;

class checkoutTracker extends librarySystem{

    public checkoutTracker(String firstName, String lastName, String address, int phoneNumber, int age) {
        super(firstName, lastName, address, phoneNumber, age);
        //TODO Auto-generated constructor stub
    }

    HashMap<Integer, String> checkoutLog = new HashMap<>();

    public void checkOutItem(int itemID, int userID){

    }

    public boolean renewItem(int itemID, int userID){
        //placeholder
        return true;
    }

    public boolean checkOutstandingRequest(int itemID, int userID){
        //placeholder
        return true;
    }

    public void returnItem(int itemID, int userID){

    }

    public double outstandingFine(int userID){
        //placeholder
        return userID;

    }
  
}
