package skamila.doctor24.user.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Doctor extends AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
