package skamila.doctor24.visit.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
public class VisitDto {

    private long id;

    private String doctorEmail;

    private String patientEmail;

    private LocalDateTime time;

    private Map<String, Integer> prescription;

}
