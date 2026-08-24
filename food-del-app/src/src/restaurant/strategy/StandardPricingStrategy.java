package restaurant.strategy;

import restaurant.models.Cart;
import restaurant.enums.OrderType;

public class StandardPricingStrategy implements PricingStrategy {
    private static final double DELIVERY_FEE = 40.0;

    @Override
    public double calculateTotal(Cart cart, OrderType orderType) {
        double total = cart.getSubtotal();
        if (orderType == OrderType.DELIVERY) {
            total += DELIVERY_FEE;
        }
        return total;
    }
}
