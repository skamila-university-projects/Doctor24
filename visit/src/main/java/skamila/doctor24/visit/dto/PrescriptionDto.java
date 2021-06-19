package skamila.doctor24.visit.dto;

import lombok.Getter;

import java.util.Map;

@Getter
public class PrescriptionDto {

    /**
     * MedicineId to quantity of this medicine on the prescription.
     */
    private Map<Integer, Integer> medicines;

}
