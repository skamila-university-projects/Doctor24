package skamila.doctor24.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skamila.doctor24.user.domain.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
}
