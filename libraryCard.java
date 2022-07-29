class libraryCard{


    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private boolean isChild;
    private double fine;
    private int cardNumber;
  
    public libraryCard(String firstName, String lastName, String address,String phoneNumber, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        if(age <= 12)
            isChild = true;
        else
            isChild = false;
    }

    public libraryCard(String firstName, String lastName, String address,String phoneNumber, Boolean isChild)
    {
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
  
    public String  getPhoneNumber(){
        return phoneNumber;
      }
  
    public double  getFine(){
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
  
    public void setPhoneNumber(String newPhoneNumber){
        this.phoneNumber = newPhoneNumber;
      }
  
    public void setFine(int newFine){
        this.fine = newFine;
    }
  
    public void addFine(int updateFine){
        this.fine += updateFine;
    }
  
  
  }