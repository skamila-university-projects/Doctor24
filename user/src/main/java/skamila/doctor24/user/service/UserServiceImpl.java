package skamila.doctor24.user.service;

import org.springframework.stereotype.Service;
import skamila.doctor24.user.domain.AppUser;
import skamila.doctor24.user.dto.AppUserDto;
import skamila.doctor24.user.repository.UserRepository;
import skamila.doctor24.user.util.AppUserConverter;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<AppUser> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(AppUserDto user) {
        userRepository.save(AppUserConverter.toEntity(user));
    }

    @Override
    public void removeUser(long userId) {
        Optional<AppUser> userOptional = userRepository.findById(userId);
        userOptional.ifPresent(userRepository::delete);
    }
}
