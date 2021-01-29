package com.maria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maria.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
 
	@Query("SELECT c FROM Car c WHERE CONCAT(c.brand, ' ', c.description, ' ', c.price, ' ', c.phone) LIKE %?1%")
	public List<Car> search(String keyword);
}