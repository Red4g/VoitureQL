package com.example.Car.dao.Repositories;

import com.example.Car.dao.Entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

    public List<Voiture> findByModel(String model);

    public List<Voiture> findByModelAndPrice(String model, double price);
}
