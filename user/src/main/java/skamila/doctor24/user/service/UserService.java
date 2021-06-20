package skamila.doctor24.user.service;

import skamila.doctor24.user.domain.AppUser;
import skamila.doctor24.user.dto.AppUserDto;

import java.security.Principal;
import java.util.List;

public interface UserService {

    List<AppUser> getAll();

    void addUser(AppUserDto user);

    void updateUser(long userId, AppUserDto user, Principal principal);

    void removeUser(long userId);

}
