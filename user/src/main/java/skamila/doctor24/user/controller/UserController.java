package skamila.doctor24.user.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import skamila.doctor24.user.domain.AppUser;
import skamila.doctor24.user.dto.AppUserDto;
import skamila.doctor24.user.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<AppUser> getAllUsers() {
        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void register(@RequestBody @Validated AppUserDto user) {
        userService.addUser(user);
    }


}
