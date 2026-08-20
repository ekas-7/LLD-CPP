package entity;

import entity.enums.OrderType;

import java.util.List;

public class Order {
    private String id;
    private String userId;
    private String restaurantId;
    private List<FoodItem> foodItems;
    private OrderType orderType;

    public Order(String id, String userId, String restaurantId, List<FoodItem> foodItems, OrderType orderType) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.foodItems = foodItems;
        this.orderType = orderType;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }
}