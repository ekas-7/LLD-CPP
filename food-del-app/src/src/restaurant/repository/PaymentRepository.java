package restaurant.repository;

import restaurant.models.Payment;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PaymentRepository {
    private final Map<String, Payment> payments = new HashMap<>();

    public void save(Payment payment) {
        payments.put(payment.getId(), payment);
    }

    public Optional<Payment> findByOrderId(String orderId) {
        for (Payment payment : payments.values()) {
            if (payment.getOrderId().equals(orderId)) {
                return Optional.of(payment);
            }
        }
        return Optional.empty();
    }
}
