package skamila.doctor24.pdfprescription.external.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class Visit {

    private long id;

    private long doctorId;

    private long patientId;

    private LocalDateTime time;

    Map<String, Integer> prescription;

}
