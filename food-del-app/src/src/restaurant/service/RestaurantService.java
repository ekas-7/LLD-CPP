package restaurant.service;

import restaurant.models.Cart;
import restaurant.models.MenuItem;
import restaurant.models.Restaurant;
import restaurant.repository.MenuItemRepository;
import restaurant.repository.RestaurantRepository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;
    private final Map<String, Cart> carts = new HashMap<>();

    public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<Restaurant> searchRestaurants(Integer pinCode, String cuisine, Double minRating) {
        return restaurantRepository.findAll().stream()
                .filter(r -> pinCode == null || pinCode.equals(r.getPinCode()))
                .filter(r -> cuisine == null || cuisine.equalsIgnoreCase(r.getCuisine()))
                .filter(r -> minRating == null || r.getRating() >= minRating)
                .sorted(Comparator.comparingDouble(Restaurant::getRating).reversed())
                .collect(Collectors.toList());
    }

    public List<MenuItem> getMenu(String restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }

    public Cart getCart(String userId) {
        return carts.computeIfAbsent(userId, Cart::new);
    }

    public void addToCart(String userId, String restaurantId, String menuItemId, int quantity) {
        Cart cart = getCart(userId);
        if (cart.getRestaurantId() != null && !cart.getRestaurantId().equals(restaurantId)) {
            throw new IllegalStateException("Cart contains items from another restaurant");
        }
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new IllegalArgumentException("Menu item not found"));
        if (!menuItem.getRestaurantId().equals(restaurantId)) {
            throw new IllegalArgumentException("Menu item does not belong to restaurant");
        }
        cart.setRestaurantId(restaurantId);
        cart.addItem(menuItem, quantity);
    }

    public void removeFromCart(String userId, String menuItemId) {
        Cart cart = getCart(userId);
        cart.removeItem(menuItemId);
        if (cart.isEmpty()) {
            cart.clear();
        }
    }

    public void clearCart(String userId) {
        getCart(userId).clear();
    }
}
