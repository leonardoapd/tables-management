package controller;

import java.io.File;

import model.OrderModel;

public class OrderController {

    private final OrderModel orderModel;

    public OrderController() {
        this.orderModel = new OrderModel();
    }

    public boolean createOrder(String order, String path) {
        try {
            File myfile = orderModel.createFile(path);
            return orderModel.writeFile(order, myfile);
        } catch (Exception e) {
            return false;
        }
    }

    public String [] loadOrder(String path) {
        try {
            return orderModel.readFile(path);
        } catch (Exception e) {
            return null;
        }
    }

}
