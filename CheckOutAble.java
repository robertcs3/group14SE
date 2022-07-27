public interface CheckOutAble
{

    public void setRenewStatus(boolean status);
    public String getName();
    public void setName(String name);
    public int getDateCheckout();
    public int getDurationLimit();
    public int getID();
    public void setID(int itemID);
    public int getCopies();
    public void addCopies(int amount);
    public void decreaseCopy(int amount);
}
