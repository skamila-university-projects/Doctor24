package skamila.doctor24.visit.service;

import skamila.doctor24.visit.domain.Medicine;

import java.util.List;

public interface MedicineService {

    List<Medicine> getAll();

    void addMedicine(String medicineName);

    void updateMedicine(long medicineId, String medicineName);

    void removeMedicine(long medicineId);

}
