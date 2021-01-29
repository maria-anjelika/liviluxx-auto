package com.maria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maria.model.Car;
import com.maria.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;
	
	@Override
	public List<Car> getAllCars(String keyword) {
		if (keyword != null) {
			return carRepository.search(keyword);
		}
		return carRepository.findAll();
		}

	@Override
	public void saveCar(Car car) {
		this.carRepository.save(car);
	}

	@Override
	public Car getCarById(long id) {
		Optional<Car> optional = carRepository.findById(id);
		Car car = null;
		if(optional.isPresent()) {
			car = optional.get();
		} else {
			throw new RuntimeException("Car not found for id: " + id);
		}
		return car;
	}

	@Override
	public void deleteCarById(long id) {
		this.carRepository.deleteById(id);
	}
}

