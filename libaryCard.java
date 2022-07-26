class libaryCard
{
    private String firstName, lastName, address;
    private int idNumber;
  public libaryCard(String fName, String lName, String address)
  {
      firstName = fName;
      lastName = lName;
      idNumber = (int)( Math.random() * 10000000);
      this.address = address;
  }

  public String toString()
  {
      System.out.println(firstName);
      System.out.println(lastName);
      System.out.println(address);
      System.out.println(idNumber);
      return "";
  }
}
