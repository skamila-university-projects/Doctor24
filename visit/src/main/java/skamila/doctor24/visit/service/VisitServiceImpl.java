package skamila.doctor24.visit.service;

import org.springframework.stereotype.Service;
import skamila.doctor24.visit.domain.Visit;
import skamila.doctor24.visit.dto.VisitDto;
import skamila.doctor24.visit.repository.VisitRepository;
import skamila.doctor24.visit.util.VisitConverter;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("visitService")
@Transactional
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public VisitDto getVisitById(Long visitId) {
        Optional<Visit> visit = visitRepository.findById(visitId);
        return visit.map(VisitConverter::fromEntity).orElse(null);
    }

}
