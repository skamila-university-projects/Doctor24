package skamila.doctor24.pdfprescription.external.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class Visit {

    private long id;

    @NotBlank
    private long doctorId;

    @NotBlank
    private long patientId;

    @NotNull
    private LocalDateTime time;

}
