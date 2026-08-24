package restaurant.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String userId;
    private String restaurantId;
    private List<CartItem> items;

    public Cart(String userId) {
        this.userId = userId;
        this.items = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(MenuItem menuItem, int quantity) {
        for (CartItem cartItem : items) {
            if (cartItem.getMenuItem().getId().equals(menuItem.getId())) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(menuItem, quantity));
    }

    public void removeItem(String menuItemId) {
        items.removeIf(item -> item.getMenuItem().getId().equals(menuItemId));
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getSubtotal).sum();
    }

    public void clear() {
        items.clear();
        restaurantId = null;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
