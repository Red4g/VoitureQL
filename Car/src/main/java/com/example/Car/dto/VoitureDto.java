package com.example.Car.dto;

import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VoitureDto {
    String model;
    String color;
    String matricul;
    double price;

}