package restaurant.strategy;

import restaurant.enums.PaymentMethod;

public class CryptoPaymentStrategy implements PaymentStrategy {
    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.CRYPTO;
    }

    @Override
    public boolean processPayment(String paymentId, double amount) {
        System.out.println("Processing crypto payment " + paymentId + " for amount " + amount);
        return true;
    }
}
