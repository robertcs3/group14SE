import java.util.Date;

public class video implements  CheckOutAble{
    String name;
    double itemValue = 0;
    int durationLimit = 14;//days
    int itemID = 0;
    Date dateCheckout;
    int copies = 1;
    boolean isRenew = false;

    //Default constructor
    public video(int itemID, int value, int copies, String name)
    {
        //Set video's values
        this.itemID = itemID;
        itemValue = value;
        this.name = name;
        this.copies = copies;
    }

    @Override
    public void setRenewStatus(boolean status) {
        isRenew = status;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getDateCheckout() {
        return dateCheckout;
    }

    @Override
    public int getDurationLimit() {
        return durationLimit;
    }

    @Override
    public int getID() {
        return itemID;
    }

    @Override
    public void setID(int itemID) {
        this.itemID = itemID;
    }

    @Override
    public int getCopies() {
        return copies;
    }

    @Override
    public void addCopies(int amount) {
        copies += amount;
    }

    @Override
    public void decreaseCopy(int amount) {
        if(amount >= copies)
        {
            copies = 0;
        }
        else
        {
            copies-=amount;
        }
    }

    @Override
    public double getValue() {
        return itemValue;
    }

    public void setDateCheckout(Date checkoutDate)
    {
        dateCheckout = checkoutDate;
    }
}
