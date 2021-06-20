package skamila.doctor24.user.dto;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class AppUserRabbitDto implements Serializable {

    private final String name;

    private final String email;

}
