package restaurant.strategy;

import restaurant.enums.OrderType;
import restaurant.models.Cart;

public interface PricingStrategy {
    double calculateTotal(Cart cart, OrderType orderType);
}
