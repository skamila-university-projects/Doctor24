package skamila.doctor24.pdfprescription.external.service;

import org.springframework.stereotype.Service;
import skamila.doctor24.pdfprescription.external.client.VisitServiceClient;
import skamila.doctor24.pdfprescription.external.dto.Visit;

@Service("visitService")
public class VisitService {

    private final VisitServiceClient visitServiceClient;

    public VisitService(VisitServiceClient visitServiceClient) {
        this.visitServiceClient = visitServiceClient;
    }

    public Visit getVisit(long visitId) {
        return visitServiceClient.getById(visitId);
    }

}
