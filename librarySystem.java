import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

class librarySystem  {

    ArrayList<libraryCard> memberList = new ArrayList<>();
    libraryCard currentUser;
    //Initialize sub systems
    catalog libraryCatalog = new catalog();
    paymentTracker paymentSystem = new paymentTracker();
    checkoutTracker checkoutTracker = new checkoutTracker();

    public librarySystem() //DONE
    {
        //Read existing users into ArrayList memberList
        try
        {
            String line = "";
            BufferedReader fileReader = new BufferedReader(new FileReader("user.csv"));
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
                signIn(id, firstName, lastName, password, phoneNUmber, address, isChild);
            }
            fileReader.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    //For new user signing up DONE
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

    //For existing user DONE
    public void signIn(int id, String firstName, String lastName, String password, String address, String phoneNumber, Boolean isChild)
    {
        libraryCard newUser = new libraryCard(firstName, lastName, address, phoneNumber, isChild);
        memberList.add(newUser);
    }

    public void checkOutItem(int itemID, int userID)//MODIFY AN
    {
        checkoutTracker.checkOutItem(userID, libraryCatalog.getItem(itemID));
        libraryCatalog.copiesDecrement(itemID);
    }

    public void payFine(double amount){//BRANDON DOING IT

    }

    public void deleteMember(int memberID){

    }

    public boolean requestItem(int itemID)//BRANDON
    {
        return false;
    }

    public boolean renewItem(int itemID)//DO IT TODAY
    {
        //placeholder
        return true;
    }

    public void returnItem(int itemID, int userID)
    {
        checkoutTracker.returnItem(itemID, userID);
    }

    //DONE
    public double outStandingFine(int userID)
    {
        HashMap<Integer,Integer> itemValueList = new HashMap<>();
        for(CheckOutAble item: libraryCatalog.showCatalog())
        {
            itemValueList.put(item.getID(), item.getValue());
        }
        ArrayList<CheckOutAble> outstandingItemList = checkoutTracker.outStandingFine(userID, itemValueList);
        double returnValue = paymentSystem.billTotal(outstandingItemList);
        return returnValue;
    }

    public ArrayList<CheckOutAble> getItemList()
    {
        return libraryCatalog.showCatalog();
    }

    public ArrayList<CheckOutAble> getCheckoutItems(int userID)
    {
        return checkoutTracker.getCheckoutItems(userID);
    }

    public void setCurrentUser(int id)
    {
        currentUser = memberList.get(memberList.indexOf(id));
    }

    
  
}
