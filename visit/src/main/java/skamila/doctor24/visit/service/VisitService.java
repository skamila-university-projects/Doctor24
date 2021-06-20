package skamila.doctor24.visit.service;

import skamila.doctor24.visit.dto.MedicinesForDoctorDto;
import skamila.doctor24.visit.dto.PrescriptionDto;
import skamila.doctor24.visit.dto.VisitDto;

import java.security.Principal;
import java.util.List;

public interface VisitService {

    VisitDto getVisitById(Long visitId, Principal principal);

    List<MedicinesForDoctorDto> getMedicinesByDoctor(String doctorEmail);

    void addVisit(VisitDto visit, Principal principal);

    void updateVisit(VisitDto visit, Principal principal);

    void cancelVisit(long visitId, Principal principal);

    void confirmVisit(long visitId, Principal principal);

    void writeUpPrescription(PrescriptionDto prescription, Principal principal);

}
