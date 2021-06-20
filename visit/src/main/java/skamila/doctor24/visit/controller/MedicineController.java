package skamila.doctor24.visit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import skamila.doctor24.visit.domain.Medicine;
import skamila.doctor24.visit.service.MedicineService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    private final MedicineService medicineService;


    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
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

}
