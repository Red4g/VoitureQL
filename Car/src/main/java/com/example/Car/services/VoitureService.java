package com.example.Car.services;

import com.example.Car.dto.VoitureDto;

import java.util.List;

public interface VoitureService {
    public VoitureDto saveVoiture(VoitureDto voitureDto);

    public boolean deleteVoiture(Long id);

    public List<VoitureDto> getVoitureByModel(String model);

    public List<VoitureDto> getVoitureByModelAndPrice(String model, double price);

    public List<VoitureDto> saveVoitures(List<VoitureDto> voitureDtos);

}