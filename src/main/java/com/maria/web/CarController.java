package com.maria.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.maria.model.Car;
import com.maria.service.CarService;

@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Car> listCars = carService.getAllCars(keyword);
		model.addAttribute("listCars", listCars);
		model.addAttribute("keyword", keyword);
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/showNewCarForm")
	public String showNewCarForm(Model model) {
		Car car = new Car();
		model.addAttribute("car", car);
		return "addCar";
	}
	
	@PostMapping("/saveCar")
	public String saveCar(@ModelAttribute("car") Car car) {
		carService.saveCar(car);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForEdit/{id}")
	public String showFormForEdit(@PathVariable(value = "id") long id, Model model) {
		Car car = carService.getCarById(id);
		model.addAttribute("car", car);
		return "editCar";
	}
	
	@GetMapping("/deleteCar/{id}")
	public String deleteCar(@PathVariable(value = "id") long id) {
		this.carService.deleteCarById(id);
		return "redirect:/";
	}
}

