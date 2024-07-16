package com.example.fdpuser3.fdpuser3;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


public class OrderFood {
    private String packages;
    private String address;
    private String deliveryTimeHr;
    private String deliveryTimeMin;
    private float deliveryCharge;

    public OrderFood(String packages, String address, String deliveryTimeHr, String deliveryTimeMin, float deliveryCharge) {
        this.packages = packages;
        this.address = address;
        this.deliveryTimeHr = deliveryTimeHr;
        this.deliveryTimeMin = deliveryTimeMin;
        this.deliveryCharge = deliveryCharge;
    }

    public String getPackages() {
        return this.packages;
    }

    public String getAddress() {
        return this.address;
    }

    public String getDeliveryTimeHr() {
        return this.deliveryTimeHr;
    }

    public String getDeliveryTimeMin() {
        return this.deliveryTimeMin;
    }

    public float getDeliveryCharge() {
        return this.deliveryCharge;
    }
}

