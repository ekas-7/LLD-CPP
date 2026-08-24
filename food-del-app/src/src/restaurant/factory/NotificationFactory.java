package restaurant.factory;

import restaurant.enums.EventType;
import restaurant.enums.OrderType;
import restaurant.models.Notification;
import restaurant.models.Order;

public class NotificationFactory {
    private int notificationCounter = 1;

    public Notification createOrderPlacedNotification(Order order) {
        String message = "Order " + order.getId() + " placed successfully. Total: " + order.getTotalAmount();
        return new Notification(
                "NOTIF-" + notificationCounter++,
                message,
                order.getOrderType(),
                EventType.ORDER_PLACED
        );
    }

    public void send(Notification notification) {
        System.out.println("[EMAIL] " + notification.getMessage());
        System.out.println("[SMS] " + notification.getMessage());
    }
}
