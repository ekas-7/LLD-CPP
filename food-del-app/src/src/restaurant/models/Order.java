package restaurant.models;

import restaurant.enums.OrderStatus;
import restaurant.enums.OrderType;

import java.util.List;

public class Order {
    private String id;
    private String userId;
    private String restaurantId;
    private List<MenuItem> menuItems;
    private OrderType orderType;
    private OrderStatus status;
    private double totalAmount;

    public Order(String id, String userId, String restaurantId, List<MenuItem> menuItems, OrderType orderType, OrderStatus status, double totalAmount) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.menuItems = menuItems;
        this.orderType = orderType;
        this.status = status;
        this.totalAmount = totalAmount;
    }

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

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
