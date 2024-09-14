package DesignPatterns.structural;

// https://medium.com/hprog99/mastering-the-facade-design-pattern-in-java-a-comprehensive-guide-with-practical-examples-f3a19f58440e
public class DpFacade {
    public static void main (String[] args) {
        ECommerceFacade eCommerceFacade = new ECommerceFacade();
        eCommerceFacade.purchaseProduct("sushant",
                "sushant",
                "online",
                "1001",10);

    }
}

class UserAuthentication {
    public void login(String username, String password) {
        System.out.println("User logged in");
    }
    public void logout() {
        System.out.println("User logged out");
    }
}

class PaymentProcessing {
    public void processPayment(String paymentMethod) {
        System.out.println("Payment processed");
    }
}

class InventoryManagement {
    public void updateInventory(String productId, int quantity) {
        System.out.println("Inventory updated");
    }
}

class OrderFulfillment {
    public void fulfillOrder(String orderId) {
        System.out.println("Order fulfilled");
    }
}

class ECommerceFacade {
    private UserAuthentication userAuthentication;
    private PaymentProcessing paymentProcessing;
    private InventoryManagement inventoryManagement;
    private OrderFulfillment orderFulfillment;

    public ECommerceFacade() {
        this.userAuthentication = new UserAuthentication();
        this.paymentProcessing = new PaymentProcessing();
        this.inventoryManagement = new InventoryManagement();
        this.orderFulfillment = new OrderFulfillment();
    }

//    For Dependency injection use below constructor
    /*public ECommerceFacade(UserAuthentication userAuthentication, PaymentProcessing paymentProcessing,
                           InventoryManagement inventoryManagement, OrderFulfillment orderFulfillment) {
        this.userAuthentication = userAuthentication;
        this.paymentProcessing = paymentProcessing;
        this.inventoryManagement = inventoryManagement;
        this.orderFulfillment = orderFulfillment;
    }*/

    public void purchaseProduct(String username, String password, String paymentMethod, String productId, int quantity) {
        userAuthentication.login(username, password);
        paymentProcessing.processPayment(paymentMethod);
        inventoryManagement.updateInventory(productId, quantity);
        orderFulfillment.fulfillOrder(productId);
        userAuthentication.logout();
    }
}