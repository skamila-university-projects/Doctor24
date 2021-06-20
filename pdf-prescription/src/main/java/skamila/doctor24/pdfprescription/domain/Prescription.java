package skamila.doctor24.pdfprescription.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
public class Prescription {

    @Id
    private Long visitId;

    private String doctorEmail;

    private String patientEmail;

    private String title;

    private byte[] prescription;

}
