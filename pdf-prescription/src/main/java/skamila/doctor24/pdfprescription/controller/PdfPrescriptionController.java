package skamila.doctor24.pdfprescription.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import skamila.doctor24.pdfprescription.service.PrescriptionService;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;
import java.security.Principal;

@RestController
@RequestMapping("/pdf")
public class PdfPrescriptionController {

    private final PrescriptionService prescriptionService;

    public PdfPrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @RolesAllowed({ "ROLE_ADMIN", "ROLE_DOCTOR", "ROLE_PATIENT" })
    public void check() {
        System.out.printf("check");
    }

    @RequestMapping(method = RequestMethod.GET)
    @RolesAllowed({ "ROLE_ADMIN", "ROLE_DOCTOR", "ROLE_PATIENT" })
    public void getPdfPrescription(HttpServletResponse response, @QueryParam("visitId") long visitId, Principal principal) {
        prescriptionService.createPdfPrescription(response, visitId, principal);
    }

}
