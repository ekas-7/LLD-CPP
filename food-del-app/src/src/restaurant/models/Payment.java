package restaurant.models;

import restaurant.enums.PaymentMethod;

public class Payment {
    private String id;
    private double amount;
    private String orderId;
    private PaymentMethod paymentMethod;

    public Payment(String id, double amount, String orderId, PaymentMethod paymentMethod) {
        this.id = id;
        this.amount = amount;
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
