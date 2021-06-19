package skamila.doctor24.visit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skamila.doctor24.visit.domain.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
