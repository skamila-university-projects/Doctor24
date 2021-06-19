package skamila.doctor24.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skamila.doctor24.user.domain.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
}
