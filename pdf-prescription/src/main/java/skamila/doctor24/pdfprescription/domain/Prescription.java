package skamila.doctor24.pdfprescription.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {

    @Id
    private Long visitId;

    private String doctorEmail;

    private String patientEmail;

    private String title;

    private byte[] prescription;

}
