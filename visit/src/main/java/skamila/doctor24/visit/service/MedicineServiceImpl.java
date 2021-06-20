package skamila.doctor24.visit.service;

import org.springframework.stereotype.Service;
import skamila.doctor24.visit.domain.Medicine;
import skamila.doctor24.visit.repository.MedicineRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("visitService")
@Transactional
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public List<Medicine> getAll() {
        return medicineRepository.findAll();
    }

    @Override
    public void addMedicine(String medicineName) {
        Medicine medicine = new Medicine();
        medicine.setName(medicineName);
        medicineRepository.save(medicine);
    }

    @Override
    public void updateMedicine(long medicineId, String medicineName) {
        Optional<Medicine> medicineOptional = medicineRepository.findById(medicineId);
        if (medicineOptional.isPresent()) {
            Medicine medicine = medicineOptional.get();
            medicine.setName(medicineName);
            medicineRepository.save(medicine);
        }
    }

    @Override
    public void removeMedicine(long medicineId) {
        Optional<Medicine> medicineOptional = medicineRepository.findById(medicineId);
        if (medicineOptional.isPresent()) {
            Medicine medicine = medicineOptional.get();
            medicineRepository.delete(medicine);
        }
    }
}
