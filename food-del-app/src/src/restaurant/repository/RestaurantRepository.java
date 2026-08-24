package restaurant.repository;

import restaurant.models.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RestaurantRepository {
    private final Map<String, Restaurant> restaurants = new HashMap<>();

    public void save(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }

    public Optional<Restaurant> findById(String id) {
        return Optional.ofNullable(restaurants.get(id));
    }

    public List<Restaurant> findAll() {
        return new ArrayList<>(restaurants.values());
    }
}
