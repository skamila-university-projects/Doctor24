package skamila.doctor24.visit.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import skamila.doctor24.visit.domain.Prescription;
import skamila.doctor24.visit.domain.Visit;
import skamila.doctor24.visit.dto.MedicinesForDoctorDto;
import skamila.doctor24.visit.dto.PrescriptionDto;
import skamila.doctor24.visit.dto.VisitDto;
import skamila.doctor24.visit.repository.MedicineRepository;
import skamila.doctor24.visit.repository.VisitRepository;
import skamila.doctor24.visit.util.PrescriptionConverter;
import skamila.doctor24.visit.util.VisitConverter;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("visitService")
@Transactional
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final MedicineRepository medicineRepository;

    public VisitServiceImpl(VisitRepository visitRepository, MedicineRepository medicineRepository) {
        this.visitRepository = visitRepository;
        this.medicineRepository = medicineRepository;
    }

    @Override
    public VisitDto getVisitById(Long visitId, Principal principal) {
        Visit visit = visitRepository.findById(visitId).orElse(null);
        if (visit != null && hasPatientOrDoctorPermissions(visit, principal)) {
            return VisitConverter.fromEntity(visit);
        }
        return null;
    }

    @Override
    public List<MedicinesForDoctorDto> getMedicinesByDoctor(String doctorEmail) {
        List<Visit> visits = visitRepository.getVisitByDoctorEmail(doctorEmail);
        List<Prescription> prescriptions = visits.stream().map(Visit::getPrescription).collect(Collectors.toList());
        Map<String, Integer> medicines = new HashMap<>();
        prescriptions.forEach(prescription -> {
            prescription.getMedicines().forEach((medicine, quantity) -> {
                if (medicines.containsKey(medicine.getName())) {
                    medicines.put(medicine.getName(), medicines.get(medicine.getName()) + quantity);
                } else {
                    medicines.put(medicine.getName(), quantity);
                }
            });
        });
        List<MedicinesForDoctorDto> medicinesForDoctor = new ArrayList<>();
        medicines.forEach((key, value) -> medicinesForDoctor.add(new MedicinesForDoctorDto(key, value)));
        return medicinesForDoctor;
    }

    @Override
    public void addVisit(VisitDto visit, Principal principal) {
        if (hasPatientOrDoctorPermissions(visit, principal)) {
            visitRepository.save(VisitConverter.toEntity(visit, medicineRepository));
        }
    }

    @Override
    public void updateVisit(VisitDto visit, Principal principal) {
        if (hasPatientOrDoctorPermissions(visit, principal)) {
            visitRepository.save(VisitConverter.toEntity(visit, medicineRepository));
        }
    }

    @Override
    public void cancelVisit(long visitId, Principal principal) {
        Visit visit = visitRepository.findById(visitId).orElse(null);
        if (visit != null && hasDoctorPermissions(visit, principal))  {
            visit.setCanceled(true);
            visitRepository.save(visit);
        }
    }

    @Override
    public void confirmVisit(long visitId, Principal principal) {
        Visit visit = visitRepository.findById(visitId).orElse(null);
        if (visit != null && hasDoctorPermissions(visit, principal))  {
            visit.setConfirmed(true);
            visitRepository.save(visit);
        }
    }

    @Override
    public void writeUpPrescription(PrescriptionDto prescriptionDto, Principal principal) {
        Visit visit = visitRepository.findById(prescriptionDto.getVisitId()).orElse(null);
        if (visit != null && hasDoctorPermissions(visit, principal))  {
            Prescription prescription = PrescriptionConverter.toEntity(prescriptionDto.getMedicines(), medicineRepository);
            visit.setPrescription(prescription);
            visitRepository.save(visit);
        }
    }

    private boolean hasPatientOrDoctorPermissions(VisitDto visit, Principal principal) {
        return getRole().equals("ROLE_ADMIN") || visit.getPatientEmail().equals(principal.getName())
                || visit.getDoctorEmail().equals(principal.getName());
    }

    private boolean hasPatientOrDoctorPermissions(Visit visit, Principal principal) {
        return getRole().equals("ROLE_ADMIN") || visit.getPatientEmail().equals(principal.getName())
                || visit.getDoctorEmail().equals(principal.getName());
    }

    private boolean hasDoctorPermissions(Visit visit, Principal principal) {
        return getRole().equals("ROLE_ADMIN") || visit.getDoctorEmail().equals(principal.getName());
    }

    private String getRole() {
        Collection<? extends GrantedAuthority> authorities =
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return authorities.stream().findFirst().get().getAuthority();
    }

}
