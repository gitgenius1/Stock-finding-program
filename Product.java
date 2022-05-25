class Product{

  private String SKU; // "stock keeping code" (a unique code for each product)
  private String description; 
  private int price; 

  // set instance variables to private 

  // overide constructor 
  public Product(String SKU, String description, int price) {
    this.SKU = SKU; 
    this.description = description; 
    this.price = price;
  }



  // overide toString method, doesnt return code stored in its memory. 
public String toString(){
   return "SKU " + SKU + "," + "Description:" + description + "," + "Price " + price;
 }

  // getter and setters 
  
  public void setSKU(String SKU){
    this.SKU = SKU;
  }   
  
  public String getSKU(){
    return this.SKU; 
  }  
  
  public void setDescription(String description){
    this.description = description;
  }

  public String getDescription(){
    return this.description; 
  }
  
  public void setPrice(int price){
    this.price = price;
  }

  public int getPrice(){
    return this.price; 
  
 
    
  }
  }
   