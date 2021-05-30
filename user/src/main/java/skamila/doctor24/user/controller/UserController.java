package skamila.doctor24.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import skamila.doctor24.user.domain.AppUser;
import skamila.doctor24.user.service.UserServiceImpl;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<AppUser> getAllUsers() {
        return userService.getAll();
    }

}
