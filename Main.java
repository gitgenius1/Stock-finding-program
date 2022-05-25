
import java.util.*; 

class Main {
    static ArrayList<Product> products = new ArrayList<Product>(); 
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) throws java.io.IOException {

        // stock inventory menu: 

        // ArrayList for Products class and Customer Class

        products.add(new Product("MS123","Xbox Series X", 440));
        products.add(new Product("MS124","Xbox Series X", 550));
        products.add(new Product("PSX125","Playstation 5", 500));
        products.add(new Product("PSX126","Playstation 5 Digital Ed", 660));
        products.add(new Product("VAL128","Steam Deck", 300));


        customers.add(new Customer(1, "Luis", "Sharp", new Address("101", "worsley", "Manchester", "Greater Manchester", "M29 5GD"), "555-1212"));
        customers.add(new Customer(2, "Darran", "Dancey", new Address("102", "Chester Street", "Manchester", "Greater Manchester", "M1 5FD"), "222-2324"));
        customers.add(new Customer(3, "Bill", "Smith", new Address("103", "Bond Street", "Manchester", "Greater Manchester", "M28 4DD"), "999-3333"));

        orders.add(new Order(customers.get(1), 1, false, List.of(
            products.get(0), products.get(1))));
        orders.add(new Order(customers.get(1), 2, true));
        orders.add(new Order(customers.get(2), 3, false, products));

        //public Order(Customer customer,int OrderID,boolean complete){ 
        // this.customer = customer;
        // this.OrderID = OrderID;
        // this.complete = complete; 
        // this.items = new ArrayList<Product>();
        //this(customer, OrderID, complete, new ArrayList<Product>());
    

       // public Order(Customer customer,int OrderID,boolean complete, List<Product> items){ 
       // this.customer = customer;
       // this.OrderID = OrderID;
       // this.complete = complete; 
       // this.items = items;


        // do while loop 

        Scanner input = new Scanner(System.in); 
        String selection; 

        do {
            System.out.println("------------"); 
            System.out.println("The Everything Store");
            System.out.println("Choose from these options");
            System.out.println("------------"); 
            System.out.println("[1] List all Products"); 
            System.out.println("[2] Search for Product by SKU"); 
            System.out.println("[3] Add a new Product"); 
            System.out.println("[4] Update a Product's Price"); 
            System.out.println("[5] Change a Products Description"); 
            System.out.println("[6] Delete a Product"); 
            System.out.println("[10] List all Customers");
            System.out.println("[11] Search for Customer by ID");
            System.out.println("[12] Add a new Customer");
            System.out.println("[13] Update a Customer's Details");
            System.out.println("[14] Delete a customer");
            System.out.println("[20] List All Orders");
            System.out.println("[21] Display an Order by ID");
            System.out.println("[22] Mark an Order Complete");
            System.out.println("[23] Create an Order");
            System.out.println("[24] Update an Order");
            System.out.println("[99] Exit"); 

            selection = input.nextLine(); 

            switch(selection){
                case "1":
                    for(int i = 0; i < products.size(); i++){
                        System.out.println(products.get(i));
                    }
                    System.out.println();
                    break; 

                case "2":
                    System.out.println("\nSearch for a product by SKU");
                    String sku = input.nextLine(); 
                    Product product = getProductWithSKU(sku, products);
                    System.out.println(product);
                    break;

                case "3":
                    Product newProduct = getProductFromUserInfo(input);
                    products.add(newProduct);
                    break;

                case "4":
                    System.out.println("\nEnter SKU of product to update");
                    String sku4 = input.nextLine();
                    System.out.println("Enter new price:");
                    int newPrice = input.nextInt();
                    Product product4 = getProductWithSKU(sku4, products);
                    if (product4 != null) product4.setPrice(newPrice);
                    else System.out.println("[Error] Product does not exist");
                    break;
                
                case "5":
                    System.out.println("\nEnter SKU of product to update");
                    String sku5 = input.nextLine();
                    System.out.println("Enter new description:");
                    String newDesc = input.nextLine();
                    Product product5 = getProductWithSKU(sku5, products);
                    if (product5 != null) product5.setDescription(newDesc);
                    else System.out.println("[Error] Product does not exist");
                    break;

                
                case "6": 
                    System.out.println("\n Delete a product");
                    System.out.println("\n Enter the product SKU");
                    String sku6 = input.nextLine();
                    deleteProduct(sku6);
                    break;
   
                case "10":
                    for (int i = 0; i < customers.size(); i++){
                        System.out.println(customers.get(i));
                    } 
                    System.out.println();  
                    break;
                    
                case "11":     
                    System.out.println("\nSearch for Customer by ID");
                    int id11 = Integer.parseInt(input.nextLine()); 
                    Customer searchid = getCustomerById(id11, customers);
                    System.out.println(searchid);
                    break;
      
                case "12":
                    System.out.println("\nAdd a new Customer");
                    Customer addcust = AddANewCustomer(input);
                    customers.add(addcust);
                    break;

                case "13":
                    System.out.println("\nCustomer ID to edit:");
                    int id13 = readInteger(input);
                    updateCustomer(id13, input);
                    System.out.println("Updated customer " + id13);
                    break;

                case "14":
                    System.out.println("\nCustomer ID to remove:");
                    int id14 = readInteger(input);
                    deleteCustomer(id14);
                    System.out.println("Deleted customer " + id14);
                    break;

                case "20":
                    for (Order order: orders){
                        System.out.println(order);  // for each loop arraylist
                    } 
                    System.out.println();
                    break;

                case "21":
                    System.out.print("\nSearch for Order by ID: ");
                    int orderID21 = readInteger(input);
                    Order order21 = getOrderById(orderID21);
                    System.out.println("Order:" + order21);                    
                    System.out.println("Customer: " + order21.getCustomer());
                    System.out.println("TOTAL: £" + order21.getTotalCost());
                    break;

                case "22":
                    System.out.print("\nSet Order Complete with ID: ");
                    int orderID22 = readInteger(input);
                    Order order22 = getOrderById(orderID22);
                    order22.setComplete(true);
                    System.out.println("Set order " + orderID22 + " complete!");
                    break;

                case "23":
                    Order newOrder = createOrder(input);
                    orders.add(newOrder);
                    System.out.println("Order " + newOrder.getOrderID() + " created!");
                    break;

                case "24":
                    updateOrder(input);
                    break;
            }  
        
        } while (!selection.equals ("99"));
    }
    private static Product getProductWithSKU(String sku, List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            Product current = products.get(i);
            if (current.getSKU().equals(sku)) {
                return current; 
            }    
        }
        return null;
    }

    private static Product getProductFromUserInfo(Scanner input) {
        System.out.println("\nEnter SKU");
        String newSKU = input.nextLine(); 
        

        System.out.println("\nEnter Description");
        String description = input.nextLine();

        System.out.println("\nEnter Price");
        int price = input.nextInt();

        Product newProduct = new Product(newSKU, description, price);
        return newProduct;
    }     
    // Delete a product method, accepts Scanner, sku and arraylist. 

    private static Product deleteProduct(String sku) {
        for(int i = 0; i < products.size(); i++){
            Product d = products.get(i);
            if (d.getSKU().equalsIgnoreCase(sku)) {
                products.remove(d);
            } 
        }
        return null; 
    }

    // Search for Customer by ID:

    private static Customer getCustomerById(int id, ArrayList<Customer> customers){
        for(int i = 0; i < customers.size(); i++){
            Customer getid = customers.get(i);
            if(getid.getCustomerID() == id){ // compare ints use ==
                return getid;
            }
        }    
        return null;
    }

    // add a new Customer:

    private static Customer AddANewCustomer(Scanner input){
        System.out.println("\nEnter a Customer ID");
        int newID = Integer.parseInt(input.nextLine());

        System.out.println("\nEnter First name");
        String newfirstname = input.nextLine();

        System.out.println("\nEnter Second name");
        String newsecondname = input.nextLine();

        System.out.println("Address input");

        System.out.println("\nEnter a House Number");
        String newhouseNo = input.nextLine(); 

        System.out.println("Enter a Street Name");
        String newstreetName = input.nextLine(); 

        System.out.println("Enter a City");
        String newcity = input.nextLine();

        System.out.println("Enter a County");
        String newcounty = input.nextLine();

        System.out.println("Enter a PostCode");
        String newpostcode = input.nextLine();       

        System.out.println("\nEnter a telephone");
        String newtelephone = input.nextLine(); 

        Customer addcust = new Customer(newID,newfirstname,newsecondname,new Address(newhouseNo,newstreetName,newcity,newcounty,newpostcode),newtelephone);
        return addcust; 
    }

    private static void updateCustomer(int customerID, Scanner scanner) {
        Customer customer = getCustomerById(customerID, customers);
        System.out.print("\nEnter new first name [" + customer.getFirstName() + "]: ");
        String value = scanner.nextLine();
        if (!value.equals("")) customer.setFirstName(value);

        System.out.print("\nEnter new second name [" + customer.getSecondName() + "]: ");
        value = scanner.nextLine();
        if (!value.equals("")) customer.setSecondName(value);
        
        // --------------------------------------------------------------------------------------
        Address address = customer.getAddress();
        System.out.print("\nEnter new house number [" + address.gethouse() + "]: ");
        value = scanner.nextLine();
        if (!value.equals("")){
           address.sethouseNo(value);
        }
        System.out.print("\nEnter new address line 1 [" + address.getaddressLine1() + "]: ");
        value = scanner.nextLine();
        if (!value.equals("")) address.setaddressLine1(value);

        System.out.print("\nEnter new address line 2 [" + address.getaddressLine2() + "]: ");
        value = scanner.nextLine();
        if (!value.equals("")) address.setaddressLine2(value);

        System.out.print("\nEnter new country [" + address.getcountry() + "]: ");
        value = scanner.nextLine();
        if (!value.equals("")) address.setcountry(value);

        System.out.print("\nEnter new post code [" + address.getpostcode() + "]: ");
        value = scanner.nextLine();
        if (!value.equals("")) address.setpostcode(value);

        System.out.print("\nEnter new phone number [" + customer.getTelephoneNumber() + "]: ");
        value = scanner.nextLine();
        if (!value.equals("")) customer.setTelephoneNumber(value);

        System.out.println("Customer " + customerID + " Updated!");
    }

    private static void deleteCustomer(int customerID) {
        for(int i = 0; i < customers.size(); i++){
            Customer c = customers.get(i);
            if (c.getCustomerID() == customerID) {
                customers.remove(c);
            } 
        }
    }

    private static int readInteger(Scanner scanner) {
        while (true) {
            String str = scanner.nextLine();
            try {
                return Integer.parseInt(str);
            }
            catch (NumberFormatException e) {
                System.out.println("Enter an integer:");
            }
        }
    }


    // ================= ORDERS ==================
    private static Order getOrderById(int orderID) {
        for (Order order: orders) {
            if (order.getOrderID() == orderID) {
                return order;
            }
        }
        return null;
    }

    private static Order createOrder(Scanner input) {
        // Get customer
        Customer customer = null;
        while (customer == null) {
            System.out.print("\nEnter Customer ID: ");
            int customerID = readInteger(input);
            customer = getCustomerById(customerID, customers);
        }

        // Generate unique order ID
        int largestID = 0;
        for (Order order: orders) {
            largestID = Math.max(largestID, order.getOrderID());
        }
        Order order = new Order(customer, largestID + 1, false);

        // Get products
        // String sku = null;
        
        while (true) {
            System.out.print("\nAdd Product with SKU [Enter to Continue]: ");
            String value = input.nextLine();
            if (value.equals("")) break;

            Product item = getProductWithSKU(value, products);
            if (item == null) {
                System.out.println("Product " + value + " does not exist");
            } else {
                order.addItem(item);
                System.out.println("Product " + value + " added!");
            }
        }
        
        return order;
    }

    private static void updateOrder(Scanner scanner) {
        if (orders.size() == 0) {
            System.out.println("No orders to edit.");
            return;
        }

        Order order = null;
        while (order == null) {
            System.out.print("\nOrder ID to edit: ");
            int orderID = readInteger(scanner);
            order = getOrderById(orderID);
        }
        
        System.out.println("Editing Order " + order);
        
        while (true) {
            System.out.print("\n[A]dd or [R]emove? [A]: ");
            String option = scanner.nextLine();
            boolean isRemoving = option.equals("R");
            String action = isRemoving ? "Remove" : "Add";
            
            System.out.print("Enter Product SKU to " + action + " [Enter to Leave]: ");
            String sku = scanner.nextLine();
            if (sku.equals("")) break;
            
            Product item = getProductWithSKU(sku, products);
            
            if (item == null) {
                System.out.println("Product " + sku + " does not exist");
            } else {
                if (isRemoving) {
                    order.removeItem(item);
                } else {
                    order.addItem(item);
                }
                System.out.println("\nEditing Order " + order);
            }
        }
    }
}
