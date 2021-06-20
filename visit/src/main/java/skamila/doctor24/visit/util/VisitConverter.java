package skamila.doctor24.visit.util;

import skamila.doctor24.visit.domain.Visit;
import skamila.doctor24.visit.dto.VisitDto;
import skamila.doctor24.visit.repository.MedicineRepository;

public class VisitConverter {

    public static VisitDto fromEntity(Visit visit) {
        return VisitDto.builder()
                .id(visit.getId())
                .doctorEmail(visit.getDoctorEmail())
                .patientEmail(visit.getPatientEmail())
                .time(visit.getTime())
                .prescription(PrescriptionConverter.fromEntity(visit.getPrescription()))
                .build();
    }

    public static Visit toEntity(VisitDto visit, MedicineRepository medicineRepository) {
        return Visit.builder()
                .doctorEmail(visit.getDoctorEmail())
                .patientEmail(visit.getPatientEmail())
                .prescription(PrescriptionConverter.toEntity(visit.getPrescription(), medicineRepository))
                .build();
    }

}
