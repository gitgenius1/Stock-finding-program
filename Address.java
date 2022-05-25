class Address {

  String houseNo;
  String addressLine1;
  String addressLine2;
  String country;
  String postCode;

public Address(String house,String addressLine1,String addressLine2,String country,String postCode){

this.houseNo = house; 
this.addressLine1 = addressLine1; 
this.addressLine2 = addressLine2; 
this.country = country; 
this.postCode = postCode;
}

// overide default toString method.

public String toString(){
  return "[HouseNo:" + houseNo + "]" + "[AddressLine1" + addressLine1 + "]" + "[AddressLine2" + addressLine2 + "]" + "[Country" + country + "]" + "[PostCode" + postCode + "]"; 
}

// Getters and Setters:

public void sethouseNo(String house){
  this.houseNo = house; 
}
public String gethouse(){
  return this.houseNo; 
}
public void setaddressLine1(String addressLine1){
  this.addressLine1 = addressLine1; 
}
public String getaddressLine1(){
  return this.addressLine1; 
}
public void setaddressLine2(String addressLine2){
  this.addressLine2 = addressLine2; 
}
public String getaddressLine2(){ 
  return this.addressLine2; 
}
public void setcountry(String country){
  this.country = country;
}
public String getcountry(){
  return this.country;
}
public void setpostcode(String postCode){
  this.postCode = postCode; 
}
public String getpostcode(){
  return this.postCode;
}

}



