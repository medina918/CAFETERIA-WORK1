public class Order {
    private String orderId;
    private String customerName;
    private String itemDetails;
    public Order(String orderId, String customerName, String itemDetails) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.itemDetails = itemDetails;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getItemDetails() { return itemDetails; }

    @Override
    public String toString() {
        return "Order{orderId='" + orderId + "', customer='" + customerName +
                "', details='" + itemDetails + "'}";
    }
}