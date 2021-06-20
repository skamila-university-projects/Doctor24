package skamila.doctor24.visit.service;

import skamila.doctor24.visit.dto.MedicinesForDoctorDto;
import skamila.doctor24.visit.dto.VisitDto;

import java.security.Principal;
import java.util.List;

public interface VisitService {

    VisitDto getVisitById(Long visitId);

    List<MedicinesForDoctorDto> getMedicinesByDoctor(long doctorId);

    void addVisit(VisitDto visit, Principal principal);
}
