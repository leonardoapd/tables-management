package entities;
public class Dish {
    /* Member Fields */
    private String name;
    private double price;
    private int quantity;

    /* Member Constructor */
    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    /* Getters and Setters */
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
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
