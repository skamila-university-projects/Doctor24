package skamila.doctor24.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class AppUserRabbitDto implements Serializable {

    private final String name;

    private final String email;

}
