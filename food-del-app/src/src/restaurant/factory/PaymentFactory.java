package restaurant.factory;

import restaurant.enums.PaymentMethod;
import restaurant.strategy.CardPaymentStrategy;
import restaurant.strategy.CodPaymentStrategy;
import restaurant.strategy.CryptoPaymentStrategy;
import restaurant.strategy.PaymentStrategy;
import restaurant.strategy.UpiPaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class PaymentFactory {
    private final Map<PaymentMethod, PaymentStrategy> strategies = new HashMap<>();

    public PaymentFactory() {
        register(new CardPaymentStrategy());
        register(new UpiPaymentStrategy());
        register(new CodPaymentStrategy());
        register(new CryptoPaymentStrategy());
    }

    private void register(PaymentStrategy strategy) {
        strategies.put(strategy.getMethod(), strategy);
    }

    public PaymentStrategy getStrategy(PaymentMethod method) {
        PaymentStrategy strategy = strategies.get(method);
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported payment method: " + method);
        }
        return strategy;
    }
}
