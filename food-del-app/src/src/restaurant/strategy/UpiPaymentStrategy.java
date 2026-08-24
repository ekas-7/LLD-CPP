package restaurant.strategy;

import restaurant.enums.PaymentMethod;

public class UpiPaymentStrategy implements PaymentStrategy {
    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.UPI;
    }

    @Override
    public boolean processPayment(String paymentId, double amount) {
        System.out.println("Processing UPI payment " + paymentId + " for amount " + amount);
        return true;
    }
}
