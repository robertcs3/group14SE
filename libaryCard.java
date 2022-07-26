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
      String output = "First Name: " + firstName;
      output += "\nLast Name: " + lastName;
      output += "\nAddress: " + address;
      output += "\nID Number: " +idNumber;
      return output;
  }
}
