package com.Ajay.BikeReg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Ajay.BikeReg.Repository.BikeRepository;
import com.Ajay.BikeReg.models.Bike;

@RestController
@CrossOrigin
@RequestMapping("/api/bikes")
public class BikeController {

	@Autowired
	private BikeRepository bikeRepo;
	
	@GetMapping
	public List<Bike> getAllBikes(){
		return bikeRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Bike postBike(@RequestBody Bike bike) {
		Bike bikebyId= bikeRepo.save(bike);
		return bikebyId;
	}
	
	@GetMapping("/{id}")
	public Bike getBikeById(@PathVariable("id") long id) {
		return bikeRepo.findById(id).get();
	}
}
