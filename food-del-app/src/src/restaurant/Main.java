package restaurant;

import restaurant.factory.NotificationFactory;
import restaurant.factory.PaymentFactory;
import restaurant.enums.FoodCategory;
import restaurant.enums.OrderType;
import restaurant.enums.PaymentMethod;
import restaurant.models.MenuItem;
import restaurant.models.Order;
import restaurant.models.Restaurant;
import restaurant.models.User;
import restaurant.repository.MenuItemRepository;
import restaurant.repository.OrderRepository;
import restaurant.repository.PaymentRepository;
import restaurant.repository.RestaurantRepository;
import restaurant.service.OrderService;
import restaurant.service.RestaurantService;
import restaurant.strategy.StandardPricingStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        MenuItemRepository menuItemRepository = new MenuItemRepository();
        OrderRepository orderRepository = new OrderRepository();
        PaymentRepository paymentRepository = new PaymentRepository();

        RestaurantService restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
        OrderService orderService = new OrderService(
                restaurantService,
                orderRepository,
                paymentRepository,
                new PaymentFactory(),
                new NotificationFactory(),
                new StandardPricingStrategy()
        );

        seedData(restaurantRepository, menuItemRepository);

        User user = new User("U1", "John Doe", "john@example.com", "password", "12 MG Road", "560001");

        System.out.println("=== Search restaurants by location and cuisine ===");
        List<Restaurant> restaurants = restaurantService.searchRestaurants(560001, "Indian", 4.0);
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.getName() + " | " + restaurant.getCuisine() + " | Rating: " + restaurant.getRating());
        }

        System.out.println("\n=== Add items to cart ===");
        restaurantService.addToCart(user.getId(), "R1", "F1", 2);
        restaurantService.addToCart(user.getId(), "R1", "F2", 1);
        System.out.println("Added Paneer Butter Masala x2 and Chicken Biryani x1");

        System.out.println("\n=== Checkout and payment ===");
        Order order = orderService.checkout(user.getId(), OrderType.DELIVERY, PaymentMethod.UPI);
        System.out.println("Order placed: " + order.getId() + " | Status: " + order.getStatus() + " | Total: " + order.getTotalAmount());
    }

    private static void seedData(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        restaurantRepository.save(new Restaurant("R1", "Spice Garden", "12 MG Road", "9999900001", 560001, "Indian", 4.5));
        restaurantRepository.save(new Restaurant("R2", "Pizza Hub", "45 Brigade Road", "9999900002", 560001, "Italian", 4.2));
        restaurantRepository.save(new Restaurant("R3", "Sushi Place", "78 Indiranagar", "9999900003", 560038, "Japanese", 4.8));

        menuItemRepository.save(new MenuItem("F1", "R1", "Paneer Butter Masala", 250, FoodCategory.VEG));
        menuItemRepository.save(new MenuItem("F2", "R1", "Chicken Biryani", 320, FoodCategory.NON_VEG));
        menuItemRepository.save(new MenuItem("F3", "R2", "Margherita Pizza", 299, FoodCategory.VEG));
        menuItemRepository.save(new MenuItem("F4", "R2", "Pepperoni Pizza", 399, FoodCategory.NON_VEG));
        menuItemRepository.save(new MenuItem("F5", "R3", "California Roll", 450, FoodCategory.NON_VEG));
        menuItemRepository.save(new MenuItem("F6", "R3", "Miso Soup", 150, FoodCategory.VEG));
    }
}
