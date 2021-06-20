package skamila.doctor24.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    TODO uncoment @Column(unique = true)
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
