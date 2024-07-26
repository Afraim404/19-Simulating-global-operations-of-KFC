package com.example.fdpuser3;

import java.io.Serializable;

public class PickUpOrders implements Serializable {
    private String foodId,food_BeverageName;
    private float food_BeveragePrice;
    private int food_BeverageQuantity;
    private float subTotal;
    private int pickUpHour;
    private String AmPm;
    private int pickupMin;

    public PickUpOrders(String amPm, String food_BeverageName, float food_BeveragePrice, int food_BeverageQuantity, int pickUpHour, int pickupMin) {
        AmPm = amPm;
        this.food_BeverageName = food_BeverageName;
        this.food_BeveragePrice = food_BeveragePrice;
        this.food_BeverageQuantity = food_BeverageQuantity;
        this.foodId = null;
        this.pickUpHour = pickUpHour;
        this.pickupMin = pickupMin;
        subTotal = food_BeveragePrice * food_BeverageQuantity;
    }

    public String getAmPm() {
        return AmPm;
    }

    public String getFood_BeverageName() {
        return food_BeverageName;
    }

    public float getFood_BeveragePrice() {
        return food_BeveragePrice;
    }

    public int getFood_BeverageQuantity() {
        return food_BeverageQuantity;
    }

    public String getFoodId() {
        return foodId;
    }

    public int getPickUpHour() {
        return pickUpHour;
    }

    public int getPickupMin() {
        return pickupMin;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setFood_BeverageQuantity(int food_BeverageQuantity) {
        this.food_BeverageQuantity = food_BeverageQuantity;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public void setAmPm(String amPm) {
        AmPm = amPm;
    }

    public void setPickUpHour(int pickUpHour) {
        this.pickUpHour = pickUpHour;
    }

    public void setPickupMin(int pickupMin) {
        this.pickupMin = pickupMin;
    }


}
