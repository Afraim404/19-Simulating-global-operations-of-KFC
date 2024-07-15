package com.example.fdpuser3;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



import java.io.Serializable;

public class FDPInfo implements Serializable {
    String name;
    String age;
    String deliveryType;
    String deliveryShift;
    String deliveryArea;
    String startDate;
    String endDate;

    public FDPInfo(String name, String age, String deliveryType, String deliveryShift, String deliveryArea, String startDate, String endDate) {
        this.name = name;
        this.age = age;
        this.deliveryType = deliveryType;
        this.deliveryShift = deliveryShift;
        this.deliveryArea = deliveryArea;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return this.name;
    }

    public String getAge() {
        return this.age;
    }

    public String getDeliveryType() {
        return this.deliveryType;
    }

    public String getDeliveryShift() {
        return this.deliveryShift;
    }

    public String getDeliveryArea() {
        return this.deliveryArea;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }
}
