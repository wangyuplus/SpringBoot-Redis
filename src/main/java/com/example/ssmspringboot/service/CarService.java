package com.example.ssmspringboot.service;

import com.example.ssmspringboot.domain.Car;
import com.example.ssmspringboot.domain.CarSum;

import java.util.List;
import java.util.Map;

public interface CarService {
    List<Car> findAll();

    List<CarSum> findByCity();

    List<Car> findByCityName(String city);

    void addCar(Car car);
}
