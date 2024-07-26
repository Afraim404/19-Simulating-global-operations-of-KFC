package com.example.fdpuser3;

import java.io.Serializable;

public class CustomerOrders implements Serializable {
    String   food_drinkName;
    float pricePerQuantity;
    int quantity;
    float subTotal;

    public CustomerOrders( String food_drinkName, float pricePerQuantity, int quantity) {

        this.food_drinkName = food_drinkName;
        this.pricePerQuantity = pricePerQuantity;
        this.quantity = quantity;
        subTotal = pricePerQuantity * quantity;
    }

    public CustomerOrders(String food_drinkName, float pricePerQuantity) {
        this.food_drinkName = food_drinkName;
        this.pricePerQuantity = pricePerQuantity;
    }

    public String getFood_drinkName() {
        return food_drinkName;
    }

    public float getPricePerQuantity() {
        return pricePerQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }
}
