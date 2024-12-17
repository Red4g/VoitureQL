package com.example.Car.mapper;

import com.example.Car.dao.Entities.Voiture;
import com.example.Car.dto.VoitureDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VoitureMapper {

    private final ModelMapper mapper = new ModelMapper();
    public Voiture fromVoitureDtoToVoiture(VoitureDto VoitureDto){
        return mapper.map(VoitureDto, Avion.class);
    }

    public VoitureDto fromVoitureToVoitureDto(Voiture voiture){
        return mapper.map(voiture, VoitureDto.class);
    }

}
