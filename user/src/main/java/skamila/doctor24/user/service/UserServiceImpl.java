package skamila.doctor24.user.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import skamila.doctor24.user.domain.AppUser;
import skamila.doctor24.user.dto.AppUserDto;
import skamila.doctor24.user.repository.UserRepository;
import skamila.doctor24.user.util.AppUserConverter;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.Collection;
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
    public void updateUser(long userId, AppUserDto userDto, Principal principal) {
        String role = getRole();
        AppUser user = userRepository.findById(userId).orElse(null);
        if (user != null && (role.equals("ROLE_ADMIN") || principal.getName().equals(user.getEmail()))) {
            userRepository.save(AppUserConverter.toEntity(userDto, user.getId()));
        }
    }

    @Override
    public void removeUser(long userId, Principal principal) {
        String role = getRole();
        AppUser user = userRepository.findById(userId).orElse(null);
        if (user != null && (role.equals("ROLE_ADMIN") || principal.getName().equals(user.getEmail()))) {
            userRepository.delete(user);
        }
    }

    private String getRole() {
        Collection<? extends GrantedAuthority> authorities =
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return authorities.stream().findFirst().get().getAuthority();
    }

}
