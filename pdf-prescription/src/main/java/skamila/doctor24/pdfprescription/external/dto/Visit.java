package skamila.doctor24.pdfprescription.external.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class Visit {

    private long id;

    private String doctorEmail;

    private String patientEmail;

    private LocalDateTime time;

    Map<String, Integer> prescription;

}
