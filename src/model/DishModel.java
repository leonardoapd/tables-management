package model;

import java.util.ArrayList;

import entities.Dish;

public class DishModel {

    private ArrayList<Dish> dishList;

    /* Constructor */
    public DishModel() {
        dishList = new ArrayList<Dish>() {
            {
                add(new Dish("Pizza", 15.99));
                add(new Dish("Pasta", 23.99));
                add(new Dish("Salad", 7.99));
                add(new Dish("Steak", 37.99));
                add(new Dish("Chicken", 16.99));
                add(new Dish("Soup", 4.99));
                add(new Dish("Sandwich", 8.99));
                add(new Dish("Burger", 15.99));
                add(new Dish("Fries", 3.99));
                add(new Dish("Cake", 4.99));
                add(new Dish("Coffee", 2.99));
                add(new Dish("Tea", 2.99));
                add(new Dish("Coke", 3.99));
                add(new Dish("Water", 1.99));
                add(new Dish("Juice", 1.99));
                add(new Dish("Milk", 2.99));
                add(new Dish("Soda", 3.99));
                add(new Dish("Chips", 4.99));
                add(new Dish("Candy", 5.99));
                add(new Dish("Hot Dog", 7.99));
                add(new Dish("Pancakes", 5.99));
                add(new Dish("Fried Shimmer", 23.99));
                add(new Dish("Grill Steak", 43.99));
                add(new Dish("Salmon", 43.99));
                add(new Dish("Onion Rings", 5.99));
                add(new Dish("Bacon", 3.99));
                add(new Dish("Sausage", 3.99));
                add(new Dish("Eggs", 6.99));
                add(new Dish("Biscuit", 4.99));
                add(new Dish("Tunna Salad", 6.99));
                add(new Dish("Nuggets", 8.99));
                add(new Dish("Ribs", 13.99));
            }
        };
    }

    /**
     * Method to create a new dish in the dishList
     * 
     * @param name
     * @param price
     */
    public boolean createDish(String name, double price) {
        dishList.add(new Dish(name, price));
        return true;
    }

    /**
     * Method to delete a dish in the dishList
     * 
     * @param name
     */
    public boolean deleteDish(String name) {
        for (Dish dish : dishList) {
            if (dish.getName().equals(name)) {
                dishList.remove(dish);
                return true;
            }
        }
        return false;
    }

    /**
     * Method to update a dish in the dishList
     * 
     * @param name
     * @param price
     */
    public boolean updateDish(String name, double price) {
        for (Dish dish : dishList) {
            if (dish.getName().equals(name)) {
                dish.setPrice(price);
                return true;
            }
        }
        return false;
    }

    /**
     * Method to search a dish in the dishList
     * 
     * @return Dish
     */
    public Dish searchDish(String name) {
        for (Dish dish : dishList) {
            if (dish.getName().equals(name)) {
                return dish;
            }
        }
        return null;
    }
    

    /**
     * Method to get all dishes names in the dishList
     * 
     * @return ArrayList<String>
     *
     */
    public ArrayList<String> getAllDishNames() {
        ArrayList<String> dishNames = new ArrayList<String>();
        for (Dish dish : dishList) {
            dishNames.add(dish.getName());
        }
        return dishNames;
    }

    /**
     * Method to get all dishes in the dishList
     * 
     * @return
     */
    public ArrayList<Dish> getAllDishes() {
        return dishList;
    }

}
