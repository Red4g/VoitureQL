package com.example.Car.services;

import lombok.AllArgsConstructor;
import com.example.Car.dao.Entities.Voiture;
import com.example.Car.dao.Repositories.VoitureRepository;
import com.example.Car.dto.VoitureDto;
import com.example.Car.mapper.VoitureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class VoitureManager implements VoitureService {

    private VoitureRepository voitureRepository;
    private VoitureMapper voitureMapper;

    @Override
    public VoitureDto saveVoiture(VoitureDto voitureDto) {
        Voiture voiture = voitureMapper.fromVoitureDtoToVoiture(voitureDto);
        voiture = voitureRepository.save(voiture);
        voitureDto = voitureMapper.fromVoitureToVoitureDto(voiture);
        return voitureDto;
    }

    @Override
    public boolean deleteVoiture(Long id) {
        try {
            voitureRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<VoitureDto> getVoitureByModel(String model) {
        List<Voiture> voitures = voitureRepository.findByModel(model);
        List<VoitureDto> voitureDtos = new ArrayList<VoitureDto>();
        for (Voiture voiture : voitures) {
            voitureDtos.add(voitureMapper.fromVoitureToVoitureDto(voiture));
        }
        return voitureDtos;
    }

    @Override
    public List<VoitureDto> getVoitureByModelAndPrice(String model, double price) {
        List<Voiture> voitures = voitureRepository.findByModelAndPrice(model, price);
        List<VoitureDto> voitureDtos = new ArrayList<VoitureDto>();
        for (Voiture voiture : voitures) {
            voitureDtos.add(voitureMapper.fromVoitureToVoitureDto(voiture));
        }
        return voitureDtos;
    }

    @Override
    public List<VoitureDto> saveVoitures(List<VoitureDto> voitureDtos) {

        List<Voiture> voitures = new ArrayList<Voiture>();
        for (VoitureDto voitureDto : voitureDtos) {
            voitures.add(voitureMapper.fromVoitureDtoToVoiture(voitureDto));
        }

        voitures = voitureRepository.saveAll(voitures);

        voitureDtos = new ArrayList<VoitureDto>();
        for (Voiture voiture : voitures) {
            voitureDtos.add(voitureMapper.fromVoitureToVoitureDto(voiture));
        }
        return voitureDtos;
    }
}
