package entity;

import java.util.List;

public class Menu {
    private String id;
    private String restaurantId;
    private List<FoodItem> foodItems;

    public Menu(String id, String restaurantId, List<FoodItem> foodItems) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.foodItems = foodItems;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public void addFoodItem(FoodItem foodItem) {
        this.foodItems.add(foodItem);
    }

    public void removeFoodItem(FoodItem foodItem) {
        this.foodItems.remove(foodItem);
    }
}
