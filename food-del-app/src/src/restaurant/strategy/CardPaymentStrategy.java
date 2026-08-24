package restaurant.strategy;

import restaurant.enums.PaymentMethod;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.CARD;
    }

    @Override
    public boolean processPayment(String paymentId, double amount) {
        System.out.println("Processing card payment " + paymentId + " for amount " + amount);
        return true;
    }
}
