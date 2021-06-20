package skamila.doctor24.pdfprescription.external.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class User {

    private String email;

    private String name;

    private String surname;

}
