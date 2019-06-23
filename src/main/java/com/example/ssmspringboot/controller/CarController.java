package com.example.ssmspringboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.ssmspringboot.domain.Car;
import com.example.ssmspringboot.domain.CarSum;
import com.example.ssmspringboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/findAll")
    public List<Car> findAll(){
        return carService.findAll();
    }

    @RequestMapping("/findByCity")
    public List<CarSum> findByCity(){
        return carService.findByCity();
    }

    @RequestMapping("/findByCityName")
    public JSONObject findByCityName(@RequestParam("city") String city){
        System.out.println("city");
        System.out.println(city);
        JSONObject rootObject = new JSONObject();
        rootObject.put("code",0);
        rootObject.put("msg","");
        rootObject.put("count",1000);
        rootObject.put("data",carService.findByCityName(city));

        return rootObject;

    }

    @RequestMapping("/addCar")
    public void addCar(Car car){
        System.out.println(car);
        carService.addCar(car);
    }
}
