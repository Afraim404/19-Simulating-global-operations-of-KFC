package com.example.fdpuser3;

import java.io.Serializable;

public class Equipment implements Serializable {
    static String  FDPID;
    int pairOfGloves;
    boolean helmet,bag,shirt,phoneCarrier;
    int num_helmet = 0,num_bag = 0,num_shirt = 0,num_phoneCarrier = 0;
    float price ;

    public Equipment(int pairOfGloves, boolean helmet, boolean bag, boolean shirt, boolean phoneCarrier) {
        this.pairOfGloves = pairOfGloves;
        this.helmet = helmet;
        this.bag = bag;
        this.shirt = shirt;
        this.phoneCarrier = phoneCarrier;
        if (helmet) num_helmet = 1 ;
        if (bag) num_bag = 1 ;
        if (shirt) num_shirt = 1 ;
        if (phoneCarrier) num_phoneCarrier = 1 ;
        price = pairOfGloves * 200  + num_helmet * 300 + num_bag * 500 + num_shirt * 200 + num_phoneCarrier * 50;
    }

    public static void setFDPID(String fdpid) {
        FDPID = fdpid;
    }


    @Override
    public String toString() {
        return "Equipment : " +"\n"+
                "pairOfGloves=" + pairOfGloves +"\n"+
                ", helmet=" + num_helmet +"\n"+
                ", bag=" + num_bag +"\n"+
                ", shirt=" + num_shirt +"\n"+
                ", phoneCarrier=" + num_phoneCarrier +"\n" +
                "Total Price :" + price + "taka"
                ;
    }
}
