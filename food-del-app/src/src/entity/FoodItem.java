package entity;

import entity.enums.FoodCategory;

public class FoodItem {
    private String id;
    private String name;
    private double price;
    private FoodCategory category;

    public FoodItem(String id, String name, double price, FoodCategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters and setters
    public String getId() {
        return id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }

    public void setId(String id) {
        this.id = id;
    }
}
