package skamila.doctor24.pdfprescription.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/pdf")
public class PdfPrescriptionController {

    @RequestMapping(value = "/pdf", method = RequestMethod.GET)
    @RolesAllowed({ "ROLE_ADMIN", "ROLE_DOCTOR", "ROLE_PATIENT" })
    public void getPdfPrescription() {

    }

}
