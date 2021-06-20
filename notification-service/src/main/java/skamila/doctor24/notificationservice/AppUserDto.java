package skamila.doctor24.notificationservice;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class AppUserDto  implements Serializable {

    private String name;

    private String email;

}
