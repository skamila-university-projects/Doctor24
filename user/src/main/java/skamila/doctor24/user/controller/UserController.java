package skamila.doctor24.user.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import skamila.doctor24.user.domain.AppUser;
import skamila.doctor24.user.dto.AppUserDto;
import skamila.doctor24.user.service.UserServiceImpl;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @RolesAllowed({ "ROLE_ADMIN" })
    public List<AppUser> getAllUsers() {
        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public void addUser(@RequestBody @Validated AppUserDto user) {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @RolesAllowed({ "ROLE_ADMIN", "ROLE_DOCTOR", "ROLE_PATIENT" })
    public void update(long userId, @RequestBody @Validated AppUserDto user, Principal principal) {
        userService.updateUser(userId, user, principal);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @RolesAllowed({ "ROLE_ADMIN" })
    public void delete(int userId) {
        userService.removeUser(userId);
    }

}
