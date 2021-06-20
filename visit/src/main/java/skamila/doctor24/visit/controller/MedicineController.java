package skamila.doctor24.visit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import skamila.doctor24.visit.domain.Medicine;
import skamila.doctor24.visit.dto.MedicinesForDoctorDto;
import skamila.doctor24.visit.service.MedicineService;
import skamila.doctor24.visit.service.VisitService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    private final MedicineService medicineService;
    private final VisitService visitService;

    public MedicineController(MedicineService medicineService, VisitService visitService) {
        this.medicineService = medicineService;
        this.visitService = visitService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @RolesAllowed({ "ROLE_ADMIN" })
    public List<Medicine> getAllMedicines() {
        return medicineService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @RolesAllowed({ "ROLE_ADMIN" })
    public void addMedicine(String medicineName) {
        medicineService.addMedicine(medicineName);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @RolesAllowed({ "ROLE_ADMIN" })
    public void updateMedicine(long medicineId, String medicineName) {
        medicineService.updateMedicine(medicineId, medicineName);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @RolesAllowed({ "ROLE_ADMIN" })
    public void deleteMedicine(long medicineId) {
        medicineService.removeMedicine(medicineId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/doctor")
    @RolesAllowed({ "ROLE_ADMIN" })
    public List<MedicinesForDoctorDto> getMedicinesByDoctor(@QueryParam("doctorId") long doctorId) {
        return visitService.getMedicinesByDoctor(doctorId);
    }

}
