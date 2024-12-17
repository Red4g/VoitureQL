package com.example.Car.web;

import lombok.AllArgsConstructor;
import com.example.Car.dto.VoitureDto;
import com.example.Car.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class VoitureGraphQLController {

    private VoitureService voitureService ;

    @MutationMapping
    public VoitureDto saveVoiture(@Argument VoitureDto voiture){
        return voitureService.saveVoiture(voiture);
    }

    @MutationMapping
    public Boolean deleteVoiture(@Argument Long id){
        return voitureService.deleteVoiture(id);
    }


    @QueryMapping
    public List<VoitureDto> getVoitureByModel(@Argument String model){
        return voitureService.getVoitureByModel(model);
    }

    @QueryMapping
    public List<VoitureDto> getVoitureByModelAndPrice(@Argument String model, @Argument double price){
        return voitureService.getVoitureByModelAndPrice(model, price);
    }
}