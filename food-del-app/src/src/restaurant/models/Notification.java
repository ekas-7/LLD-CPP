package restaurant.models;

import restaurant.enums.EventType;
import restaurant.enums.OrderType;

public class Notification {
    private String notificationId;
    private String message;
    private OrderType orderType;
    private EventType eventType;

    public Notification(String notificationId, String message, OrderType orderType, EventType eventType) {
        this.notificationId = notificationId;
        this.message = message;
        this.orderType = orderType;
        this.eventType = eventType;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
