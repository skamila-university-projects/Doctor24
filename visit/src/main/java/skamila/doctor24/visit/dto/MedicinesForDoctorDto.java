package skamila.doctor24.visit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MedicinesForDoctorDto {

    private String medicineName;

    private int quantity;

}
