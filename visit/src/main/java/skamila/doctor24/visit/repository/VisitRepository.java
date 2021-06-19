package skamila.doctor24.visit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skamila.doctor24.visit.domain.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
}
