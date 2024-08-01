package com.example.fdpuser3;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {

    public ArrayList<CustomerOrders> customerOrderListOrderClass;
    public ArrayList<PickUpOrders> pickUpOrdersListOrderClass;
     String customerName;
     int customerPhone;
     String customerEmail;
     String pick_delivery;

    private String packages = "Food/Beverages :",address =  null;
    private int deliveryHour, deliveryMinute;
    private float totalCost;

    // PickUpPane Write Object file
    public Order(String address, String customerEmail, String customerName, ArrayList<PickUpOrders> pickUpOrdersListOrderclass,float totalCost,String pick_delivery) {
        this.address = address;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.pickUpOrdersListOrderClass = pickUpOrdersListOrderclass;
        this.totalCost = totalCost;
        this.pick_delivery = pick_delivery;
        addToPackages();

    }

// CancelOrderPane TableView
    public Order(String packages, String address, int deliveryHour, int deliveryMinute, float totalCost, ArrayList<PickUpOrders> pickUpOrdersListOrderClass,String pick_delivery) {
        this.packages = packages;
        this.address = address;
        this.deliveryHour = deliveryHour;
        this.deliveryMinute = deliveryMinute;
        this.totalCost = totalCost;
        this.pickUpOrdersListOrderClass = pickUpOrdersListOrderClass;
        this.pick_delivery = pick_delivery;
    }
    void addToPackages(){
        for(PickUpOrders pickUpOrder : pickUpOrdersListOrderClass){
            this.packages = packages + ',' + pickUpOrder.getFood_BeverageName();
            this.deliveryHour = pickUpOrder.getPickUpHour();
            this.deliveryMinute = pickUpOrder.getPickupMin();
        }

    }
    String printFoodBeverage(){
        String a,food_items = "FoodItems shown below (Food/Beverage name,Quantity,cost per Unit,sub_Total):\n\n";
        int b;
        float c,d;
        for (PickUpOrders orders :pickUpOrdersListOrderClass){
            a =  orders.getFood_BeverageName();
            b =  orders.getFood_BeverageQuantity();
            c = orders.getFood_BeveragePrice();
            d = orders.getSubTotal();

            food_items = food_items + "Food/Beverage Name = " + a +" , "+"Quantity = "+ b +" , "+"cost Per unit = "+ c +" , " +"Sub_Total Cost = "+ d  +"tk"+"\n";
        }
        return food_items;
    }
    public String getAddress() {
        return address;
    }

    public int getDeliveryHour() {
        return deliveryHour;
    }

    public int getDeliveryMinute() {
        return deliveryMinute;
    }

    public String getPackages() {
        return packages;
    }

    public float getTotalCost() {
        return totalCost;
    }


    public ArrayList<PickUpOrders> getPickUpOrdersListOrderClass() {
        return pickUpOrdersListOrderClass;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public ArrayList<CustomerOrders> getCustomerOrderListOrderClass() {
        return customerOrderListOrderClass;
    }

    public String getPick_delivery() {
        return pick_delivery;
    }
}
