import java.util.ArrayList;

class librarySystem extends libraryCard {

    public librarySystem(String firstName, String lastName, String address, int phoneNumber, int age) {
        super(firstName, lastName, address, phoneNumber, age);
        //TODO Auto-generated constructor stub
        
    }

    ArrayList<libraryCard> memberList = new ArrayList<>();



    public void signUp(String firstName, String lastName, String address, int phoneNumber){
     
    }

    public void checkOutItem(int itemID, int userID){

    }

    public void payFine(double amount){

    }

    public void deleteMember(int memberID){

    }

    public void requestItem(int itemID){

    }

    public boolean renewItem(int itemID, int userID){
        //placeholder
        return true;

    }

    public void returnItem(int itemID, int userID){

    }

    public double outStandingFine(int userID){
        //placeholder
        return userID;


    }



    
  
}
