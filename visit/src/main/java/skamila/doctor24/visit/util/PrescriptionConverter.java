package skamila.doctor24.visit.util;

import skamila.doctor24.visit.domain.Medicine;
import skamila.doctor24.visit.domain.Prescription;
import skamila.doctor24.visit.repository.MedicineRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PrescriptionConverter {

    public static Map<String, Integer> fromEntity(Prescription prescription) {
        Map<Medicine, Integer> medicinesEntity = prescription.getMedicines();
        Map<String, Integer> medicinesDto = new HashMap<>();
        for(Map.Entry<Medicine, Integer> entry : medicinesEntity.entrySet()) {
            medicinesDto.put(entry.getKey().getName(), entry.getValue());
        }
        return medicinesDto;
    }

    public static Prescription toEntity(Map<String, Integer> medicinesDto, MedicineRepository medicineRepository) {
        if (medicinesDto == null) {
            return null;
        }
        Prescription prescription = new Prescription();
        Map<Medicine, Integer> medicinesEntity = prescription.getMedicines();
        for(Map.Entry<String, Integer> entry : medicinesDto.entrySet()) {

            Optional<Medicine> medicineOptional = medicineRepository.findByName(entry.getKey());
            if (medicineOptional.isPresent()) {
                medicinesEntity.put(medicineOptional.get(), entry.getValue());
            } else {
                Medicine medicine = new Medicine();
                medicine.setName(entry.getKey());
                medicinesEntity.put(medicine, entry.getValue());
            }

        }
        prescription.setMedicines(medicinesEntity);
        return prescription;
    }

}
