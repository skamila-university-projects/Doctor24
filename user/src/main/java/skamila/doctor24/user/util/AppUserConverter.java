package skamila.doctor24.user.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import skamila.doctor24.user.domain.AppUser;
import skamila.doctor24.user.dto.AppUserDto;

public class AppUserConverter {

    public static AppUser toEntity(AppUserDto appUserDto) {
        return AppUser.builder()
                .email(appUserDto.getEmail())
                .password(hashPassword(appUserDto.getPassword()))
                .role(appUserDto.getRole())
                .active(appUserDto.isActive())
                .name(appUserDto.getName())
                .surname(appUserDto.getSurname())
                .build();
    }

    public static AppUser toEntity(AppUserDto appUserDto, long userId) {
        return AppUser.builder()
                .id(userId)
                .email(appUserDto.getEmail())
                .password(hashPassword(appUserDto.getPassword()))
                .role(appUserDto.getRole())
                .active(appUserDto.isActive())
                .name(appUserDto.getName())
                .surname(appUserDto.getSurname())
                .build();
    }

    private static String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

}
