package controller;

import java.util.ArrayList;

import entities.Dish;
import model.DishModel;

public class DishController {

    private final DishModel dishModel;

    public DishController() {
        this.dishModel = new DishModel();
    }

    public Dish searchDish(String name) {
        try {
            return dishModel.searchDish(name);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<String> getAllDishNames() {
        try {
            return dishModel.getAllDishNames();
        } catch (Exception e) {
            return null;
        }
    }
}
