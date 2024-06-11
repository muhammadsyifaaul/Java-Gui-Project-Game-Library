package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private int id;
    private String name;
    private int stock;
    private int price;
    private List<String> category;
    private String platform;
    private String gambar; // Atribut untuk gambar
    private String description;

    public Game(int id, String name, int stock, int price, String[] category, String platform, String gambar, String description) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.category = new ArrayList<>(Arrays.asList(category));
        this.platform = platform;
        this.gambar = gambar;
        this.description = description;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public int getPrice() {
        return price;
    }

    public List<String> getCategory() {
        return category;
    }

    public String getPlatform() {
        return platform;
    }

    public String getGambar() {
        return gambar;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Stock: " + stock + "\n" +
                "Price: " + price + "\n" +
                "Category: " + category.toString() + "\n" +
                "Platform: " + platform + "\n" +
                "About This Game: " + "\n" + description;
    }
}
