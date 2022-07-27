class libaryCard{


  private String firstName;
  private String lastName;
  private String address;
  private int phoneNumber;
  private boolean isChild;
  private double fine;
  private int cardNumber;

  public libaryCard(int id, String firstName, String lastName, String address, int phoneNumber, boolean isChild)
  {
      cardNumber = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.address = address;
      this.phoneNumber = phoneNumber;
      this.isChild = isChild;
  }
  public String getName(){
      return firstName;
    }

  public String getLastName(){
      return lastName;
  }

  public String  getAddress(){
      return address;
    }

  public int  getID(){
      return cardNumber;
    }

  public int  getPhoneNumber(){
      return phoneNumber;
    }

  public double getFine(){
      return fine;
    }

  public boolean isChild(){
      return isChild;
    }


  public void setName(String newName){
      this.firstName = newName;
  }
  public void setLastName(String newLastName){
      this.lastName = newLastName;
  }
  public void setAddress(String newAddress){
    this.address = newAddress;
  }

  public void setPhoneNumber(int newPhoneNumber){
      this.phoneNumber = newPhoneNumber;
    }

  public void setFine(int newFine){
      this.fine = newFine;
  }

  public void addFine(int updateFine){
      this.fine += updateFine;
  }
}
