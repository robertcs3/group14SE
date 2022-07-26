class libaryCard{
<<<<<<< HEAD
  
=======


  private String firstName;
  private String lastName;
  private String address;
  private int phoneNumber;
  private boolean isChild;
  private double fine;
  private int cardNumber;


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
      return carNumber;
    }

  public int  getPhoneNumber(){
      return phoneNumber;
    }

  public int  getFine(){
      return fine;
    }

  public boolean isChild(){
      this.isChild = false;
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


>>>>>>> task1
}
