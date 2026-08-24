package restaurant.repository;

import restaurant.models.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MenuItemRepository {
    private final Map<String, MenuItem> menuItems = new HashMap<>();

    public void save(MenuItem menuItem) {
        menuItems.put(menuItem.getId(), menuItem);
    }

    public Optional<MenuItem> findById(String id) {
        return Optional.ofNullable(menuItems.get(id));
    }

    public List<MenuItem> findByRestaurantId(String restaurantId) {
        List<MenuItem> items = new ArrayList<>();
        for (MenuItem menuItem : menuItems.values()) {
            if (menuItem.getRestaurantId().equals(restaurantId)) {
                items.add(menuItem);
            }
        }
        return items;
    }
}
