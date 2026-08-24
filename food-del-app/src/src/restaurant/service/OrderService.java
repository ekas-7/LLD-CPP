package restaurant.service;

import restaurant.factory.NotificationFactory;
import restaurant.factory.PaymentFactory;
import restaurant.models.Cart;
import restaurant.models.CartItem;
import restaurant.models.MenuItem;
import restaurant.models.Order;
import restaurant.models.Payment;
import restaurant.enums.OrderStatus;
import restaurant.enums.OrderType;
import restaurant.enums.PaymentMethod;
import restaurant.repository.OrderRepository;
import restaurant.repository.PaymentRepository;
import restaurant.strategy.PaymentStrategy;
import restaurant.strategy.PricingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService {
    private final RestaurantService restaurantService;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentFactory paymentFactory;
    private final NotificationFactory notificationFactory;
    private final PricingStrategy pricingStrategy;

    public OrderService(RestaurantService restaurantService, OrderRepository orderRepository,
                        PaymentRepository paymentRepository, PaymentFactory paymentFactory,
                        NotificationFactory notificationFactory, PricingStrategy pricingStrategy) {
        this.restaurantService = restaurantService;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.paymentFactory = paymentFactory;
        this.notificationFactory = notificationFactory;
        this.pricingStrategy = pricingStrategy;
    }

    public Order checkout(String userId, OrderType orderType, PaymentMethod paymentMethod) {
        Cart cart = restaurantService.getCart(userId);
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        String orderId = UUID.randomUUID().toString();
        String paymentId = UUID.randomUUID().toString();
        double total = pricingStrategy.calculateTotal(cart, orderType);
        List<MenuItem> orderItems = buildOrderItems(cart);

        PaymentStrategy paymentStrategy = paymentFactory.getStrategy(paymentMethod);
        boolean success = paymentStrategy.processPayment(paymentId, total);
        if (!success) {
            throw new IllegalStateException("Payment failed");
        }

        Payment payment = new Payment(paymentId, total, orderId, paymentMethod);
        paymentRepository.save(payment);

        Order order = new Order(
                orderId,
                userId,
                cart.getRestaurantId(),
                orderItems,
                orderType,
                OrderStatus.SUCCESS,
                total
        );
        orderRepository.save(order);
        notificationFactory.send(notificationFactory.createOrderPlacedNotification(order));
        restaurantService.clearCart(userId);
        return order;
    }

    private List<MenuItem> buildOrderItems(Cart cart) {
        List<MenuItem> items = new ArrayList<>();
        for (CartItem cartItem : cart.getItems()) {
            for (int i = 0; i < cartItem.getQuantity(); i++) {
                items.add(cartItem.getMenuItem());
            }
        }
        return items;
    }
}
