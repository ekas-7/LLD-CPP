package restaurant.strategy;

import restaurant.enums.PaymentMethod;

public interface PaymentStrategy {
    PaymentMethod getMethod();

    boolean processPayment(String paymentId, double amount);
}
