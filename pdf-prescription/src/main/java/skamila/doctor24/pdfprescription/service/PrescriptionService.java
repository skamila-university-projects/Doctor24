package skamila.doctor24.pdfprescription.service;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

public interface PrescriptionService {

    void createPdfPrescription(HttpServletResponse response, long visitId, Principal principal);

}
