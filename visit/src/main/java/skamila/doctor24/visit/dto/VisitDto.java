package skamila.doctor24.visit.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class VisitDto {

    private long doctorId;

    private long patientId;

    private LocalDateTime time;

    private Map<String, Integer> prescription;

}
