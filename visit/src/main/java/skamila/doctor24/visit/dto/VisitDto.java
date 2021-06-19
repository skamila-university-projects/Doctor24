package skamila.doctor24.visit.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class VisitDto {

    private long doctorId;

    private long patientId;

    private LocalDateTime time;

}
