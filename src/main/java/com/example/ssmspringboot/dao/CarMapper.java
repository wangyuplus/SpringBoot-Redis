package com.example.ssmspringboot.dao;

import com.example.ssmspringboot.domain.Car;
import com.example.ssmspringboot.domain.CarSum;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CarMapper {
    @Select("select * from twohand")
    List<Car> findAll();

    @Select("select city,count(*) as sum from twohand group by city order by count(*) desc")
    List<CarSum> findByCity();

    @Select("select * from twohand where city=#{city}")
    List<Car> findByCityName(String city);

    @Insert("insert into twohand values(#{carname},#{city},#{source_num},#{car_owner_price},#{new_car_price},#{car_plate_time},#{mileage},#{displacement},#{gearbox},#{car_owner},#{now_time})")
    void addCar(Car car);
}
