package com.Ajay.BikeReg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ajay.BikeReg.models.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {

}
