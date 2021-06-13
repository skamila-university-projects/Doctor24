package skamila.doctor24.user.service;

import skamila.doctor24.user.domain.AppUser;
import skamila.doctor24.user.dto.AppUserDto;

import java.util.List;

public interface UserService {

    List<AppUser> getAll();

    void addUser(AppUserDto user);

}
