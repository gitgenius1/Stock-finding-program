class Customer {
    int customerID;
    String firstName;
    String secondName;
    Address address;
    String telephoneNumber; 

    public Customer(int customerID,String firstName,String secondName,Address address,String telephoneNumber){

        this.customerID = customerID;
        this.firstName = firstName; 
        this.secondName = secondName; 
        this.address = address; 
        this.telephoneNumber = telephoneNumber; 
    }

    // overide default toString
    public String toString() {
        return "[Customer ID: " + customerID + "]" + "[First Name: " + firstName + "]" + "[secondName: " + secondName + "]" + "[Address - " + address + " [telephoneNumber: " + telephoneNumber +"]";
    }

    // Setters and Getters

    public void setcustomerID(int customerID){ 
        this.customerID = customerID; 
    }

    public int getCustomerID(){
        return this.customerID;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName; 
    }

    public String getSecondName(){
        return this.secondName; 
    }

    public void setAddress(Address address){
        this.address = address; 
    }

    public Address getAddress(){
        return this.address;
    }

    public void setTelephoneNumber(String telephoneNumber){
        this.telephoneNumber = telephoneNumber; 
    }

    public String getTelephoneNumber(){
        return this.telephoneNumber;
    }
}