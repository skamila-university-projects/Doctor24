package skamila.doctor24.user.dto;

import lombok.Getter;
import skamila.doctor24.user.domain.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class AppUserDto {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 5)
    private String password;

    @NotNull
    private Role role;

    private boolean active;

    @NotBlank
    @Size(min = 2)
    private String name;

    @NotBlank
    @Size(min = 2)
    private String surname;

}
