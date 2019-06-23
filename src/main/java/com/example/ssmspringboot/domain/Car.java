package com.example.ssmspringboot.domain;

import lombok.Data;

@Data
public class Car {
    /**车名*/
    private String carname;
    /**城市*/
    private String city;
    /**车源号*/
    private String source_num;
    /**车主报价*/
    private String car_owner_price;
    /**新车指导价*/
    private String new_car_price;
    /**上牌时间*/
    private String car_plate_time;
    /**里程*/
    private String mileage;
    /**排量*/
    private String displacement;
    /**变速箱*/
    private String gearbox;
    /**车主*/
    private String car_owner;
    /**当前采纳时间*/
    private String now_time;

    private String sum;

}
