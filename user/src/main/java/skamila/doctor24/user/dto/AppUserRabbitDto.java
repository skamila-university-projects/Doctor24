package skamila.doctor24.user.dto;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class AppUserRabbitDto implements Serializable {

    private String name;

    private String email;

}
