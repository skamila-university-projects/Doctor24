package skamila.doctor24.user.service;

import org.springframework.stereotype.Service;
import skamila.doctor24.user.domain.AppUser;
import skamila.doctor24.user.repository.UserRepository;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<AppUser> getAll() {
        return userRepository.findAll();
    }

}
