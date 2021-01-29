package com.maria.service;

import java.util.List;

import com.maria.model.Car;

public interface CarService {
	List<Car> getAllCars(String keyword);
	void saveCar(Car car);
	Car getCarById(long id);
	void deleteCarById(long id);
}
