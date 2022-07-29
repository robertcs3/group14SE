import java.io.*;
import java.util.ArrayList;

class librarySystem  {

    ArrayList<libraryCard> memberList = new ArrayList<>();
    int currentUser = 0;
    public librarySystem()
    {
        //Read existing users into ArrayList memberList
        try
        {
            String line = "";
            BufferedReader fileReader = new BufferedReader(new FileReader("login.csv"));
            while((line = fileReader.readLine()) != null)
            {
                String[] user = line.split(",");
                int id = Integer.parseInt(user[0]);
                String firstName = user[1];
                String lastName = user[2];
                String password = user[3];
                String phoneNUmber = user[4];
                String address = user[5];
                Boolean isChild = Boolean.parseBoolean(user[6]);
                signUp(id, firstName, lastName, password, phoneNUmber, address, isChild);
            }
            fileReader.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    //For new user signing up
    public void signUp(int id, String firstName, String lastName, String password, String address, String phoneNumber, int age)
    {
        try
        {
            libraryCard newUser = new libraryCard(firstName, lastName, address, phoneNumber, age);
            memberList.add(newUser);
            //Write to user.csv
            BufferedWriter fileToWrite = new BufferedWriter(new FileWriter("user.csv", true));
            fileToWrite.write("\n" +id
                    + "," + firstName
                    + "," + lastName
                    + "," + password
                    + "," + phoneNumber
                    + ", \"" + address +"\""
                    + "," + newUser.isChild()
            );
            fileToWrite.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    //For existing user
    public void signUp(int id, String firstName, String lastName, String password, String address, String phoneNumber, Boolean isChild)
    {
        libraryCard newUser = new libraryCard(firstName, lastName, address, phoneNumber, isChild);
        memberList.add(newUser);
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
