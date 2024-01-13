import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Item 
{
    private int itemId;
    private String itemName;
    private double itemPrice;
    
    public Item(int itemId,String itemName,double itemPrice)
    {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    //Getter methods
    public int getItemId(){return itemId;}
    public String getItemName(){return itemName;}
    public double getItemPrice(){return itemPrice;}

    //Setter methods
    public void setItemId(int itemId){this.itemId = itemId;}
    public void setItemName(String itemName){this.itemName = itemName;}
    public void setItemPrice(double itemPrice){this.itemPrice = itemPrice;}
}

class Order
{
    private int orderId;
    private Map<Item,Integer> items = new HashMap<>();

    public Order(int orderId) {
        this.orderId = orderId;
    }

    // Getter methods
    public int getOrderId() {
        return orderId;
    }

    public synchronized Map<Item, Integer> getItems() {
        return new HashMap<>(items);
    }

    // Setters
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    // Other methods
    public synchronized void addItem(Item item, int quantity) {
        items.put(item, quantity);
    }

}

public class OrderFulfillmentSystem 
{
    private Map<Integer, Order> orders = new HashMap<>();
    private Map<Item, Integer> inventory = new HashMap<>();

    public synchronized void placeOrder(Order order)
    {
        orders.put(order.getOrderId(),order);
        updateInventory(order);
    }

    public void startProcessing()
    {
        for (Order order : orders.values())
        {
            processOrder(order);
        }
    }

    public 

    public void updateInventory(Order order)
    {

    }

    public void processOrder(Order order)
    {

    }

    public void waitForCompletion()
    {
        while(!orders.isEmpty())
        {
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public synchronized String trackOrderStatus(int orderId) {
        Order order = orders.get(orderId);
        if (order != null) {
            // Return real-time tracking information with time implementation
            return "Order " + orderId + " status: Shipped";
        } else {
            return "Order " + orderId + " not found.";
        }
    }

    private void InsufficientInventoryException(Order order, InsufficientInventoryException e) {
        // Handle insufficient inventory exception
        System.out.println("Error processing order " + order.getOrderId() + ": " + e.getMessage());
    }

    private void OrderCancellationException(Order order, OrderCancellationException e) {
        // Handle order cancellation exception
        System.out.println("Order " + order.getOrderId() + " cancelled: " + e.getMessage());
    }

    private void GeneralException(Order order, Exception e) {
        // Handle general exception
        System.out.println("Error processing order " + order.getOrderId() + ": " + e.getMessage());
    }
}