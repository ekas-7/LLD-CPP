package restaurant.strategy;

import restaurant.enums.PaymentMethod;

public class CodPaymentStrategy implements PaymentStrategy {
    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.COD;
    }

    @Override
    public boolean processPayment(String paymentId, double amount) {
        System.out.println("Processing COD payment " + paymentId + " for amount " + amount);
        return true;
    }
}
