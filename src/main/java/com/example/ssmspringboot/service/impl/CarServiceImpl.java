package com.example.ssmspringboot.service.impl;

import com.example.ssmspringboot.dao.CarMapper;
import com.example.ssmspringboot.domain.Car;
import com.example.ssmspringboot.domain.CarSum;
import com.example.ssmspringboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;


    @Override
    public List<Car> findAll() {
        return carMapper.findAll();
    }

    @Override
    public List<CarSum> findByCity() {
        return carMapper.findByCity();
    }

    @Override
    public List<Car> findByCityName(String city) {
        return carMapper.findByCityName(city);
    }

    @Override
    @Transactional
    public void addCar(Car car) {
        carMapper.addCar(car);
    }


}
