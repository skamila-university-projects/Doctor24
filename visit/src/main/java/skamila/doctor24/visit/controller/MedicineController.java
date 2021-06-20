package skamila.doctor24.visit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import skamila.doctor24.visit.domain.Medicine;
import skamila.doctor24.visit.service.MedicineService;

import java.util.List;

public class MedicineController {

    private final MedicineService medicineService;


    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    // wszystko dla administratora

    @RequestMapping(method = RequestMethod.GET)
    public List<Medicine> getAllMedicines() {
        return medicineService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addMedicine(String medicineName) {
        medicineService.addMedicine(medicineName);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateMedicine(long medicineId, String medicineName) {
        medicineService.updateMedicine(medicineId, medicineName);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteMedicine(long medicineId) {
        medicineService.removeMedicine(medicineId);
    }

}
