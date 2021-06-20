package skamila.doctor24.visit.service;

import skamila.doctor24.visit.dto.VisitDto;

public interface VisitService {

    VisitDto getVisitById(Long visitId);

}
