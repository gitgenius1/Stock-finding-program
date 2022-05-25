import java.util.*;

class Order {
    private Customer customer;
    private int OrderID;
    private boolean complete;
    private List<Product> items;

        // new Order(customer1, 1, false)
        // new Order(customer1, 1, false, new ArrayList<>())

    public Order(Customer customer,int OrderID,boolean complete){ 
        // this.customer = customer;
        // this.OrderID = OrderID;
        // this.complete = complete; 
        // this.items = new ArrayList<Product>();
        this(customer, OrderID, complete, new ArrayList<Product>());
    }

    public Order(Customer customer,int OrderID,boolean complete, List<Product> items){ 
        this.customer = customer;
        this.OrderID = OrderID;
        this.complete = complete; 
        this.items = items;
        // this(customer,OrderID,complete,items);
    }

    // getters and setters 

    public void setCustomer(Customer customer){
        this.customer = customer; 
    } 
    public Customer getCustomer(){
        return this.customer;
    }
    public void setOrderID(int OrderID){
        this.OrderID = OrderID; 
    }
    public int getOrderID(){
        return this.OrderID;
    }
    public void setComplete(boolean complete){
        this.complete = complete; 
    }
    public boolean getComplete(){
        return this.complete;
    }
    
    public void addItem(Product item) {
        items.add(item);
    }
    public void removeItem(Product item) {
        items.remove(item);
    }

    public int getTotalCost() {
        int cost = 0;

        for (Product item: items) {
            cost += item.getPrice();
        }

        // for (int i = 0; i < items.size(); i++) {
        //     Product item = items.get(i);
        //     cost += item.getPrice();
        // }

        return cost;
    }

    @Override
    public String toString() {
       return "[Order ID: " + OrderID + "]" + "[Customer: " + customer.getCustomerID() + "]" + "[Complete: " + complete + "]" + "[Items - " + items + "]";
    }
}

  
