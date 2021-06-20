package skamila.doctor24.pdfprescription.service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import skamila.doctor24.pdfprescription.domain.Prescription;
import skamila.doctor24.pdfprescription.external.dto.User;
import skamila.doctor24.pdfprescription.external.dto.Visit;
import skamila.doctor24.pdfprescription.external.service.UserService;
import skamila.doctor24.pdfprescription.external.service.VisitService;
import skamila.doctor24.pdfprescription.repository.PdfPrescriptionRepository;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

@Service("prescriptionServiceImpl")
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PdfPrescriptionRepository prescriptionRepository;
    private final VisitService visitService;
    private final UserService userService;

    public PrescriptionServiceImpl(PdfPrescriptionRepository prescriptionRepository, VisitService visitService, UserService userService) {
        this.prescriptionRepository = prescriptionRepository;
        this.visitService = visitService;
        this.userService = userService;
    }

    @Override
    public void createPdfPrescription(HttpServletResponse response, long visitId, Principal principal) {
        Optional<Prescription> prescriptionOptional = prescriptionRepository.findById(visitId);
        Prescription prescription = prescriptionOptional.orElse(null);
        if (prescription == null) {
            Visit visit = visitService.getVisit(visitId);
//            User patient = userService.getUser(visit.getPatientId());
//            User doctor = userService.getUser(visit.getDoctorId());
//            prescription = savePrescription(visit, patient, doctor);
        }
        createResponse(response, prescription);
    }

    private Prescription savePrescription(Visit visit, User patient, User doctor) {
        Prescription prescription = Prescription.builder()
                .visitId(visit.getId())
                .patientEmail(patient.getEmail())
                .doctorEmail(doctor.getEmail())
                .prescription(generatePdf(visit, patient, doctor))
                .build();
        return prescriptionRepository.save(prescription);
    }

    private byte[] generatePdf(Visit visit, User patient, User doctor) {
        try {
            ByteArrayOutputStream  output = new ByteArrayOutputStream();

            Document pdf = new Document();
            PdfWriter.getInstance(pdf, output);

            pdf.open();
            pdf.add(new Paragraph("Recepta"));
            pdf.add(new Paragraph(Chunk.NEWLINE));
            pdf.add(new Paragraph(Chunk.NEWLINE));

            pdf.add(new Paragraph("Dane pacjenta"));
            pdf.add(new Paragraph(Chunk.NEWLINE));
            pdf.add(tableWithUserData(patient));

            pdf.add(new Paragraph("Szczegóły wizyty"));
            pdf.add(new Paragraph(Chunk.NEWLINE));
            pdf.add(tableWithVisitData(visit, doctor));

            pdf.add(new Paragraph("Przepisane lekarstwa"));
            pdf.add(new Paragraph(Chunk.NEWLINE));
            pdf.add(tableWithMedicines(visit.getPrescription()));

            pdf.close();
            output.close();
            return output.toByteArray();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private PdfPTable tableWithUserData(User patient) {
        PdfPTable table = new PdfPTable(2);
        table.addCell("Imie");
        table.addCell(patient.getName());
        table.addCell("Nazwisko");
        table.addCell(patient.getSurname());
        return table;
    }

    private PdfPTable tableWithVisitData(Visit visit, User doctor) {
        PdfPTable table = new PdfPTable(2);
        table.addCell("Lekarz");
        table.addCell(doctor.getName() + " " + doctor.getSurname());

        table.addCell("Data");
        table.addCell(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(visit.getTime()));
        table.addCell("Godzina");
        table.addCell(DateTimeFormatter.ofPattern("HH:mm").format(visit.getTime()));
        return table;
    }

    private PdfPTable tableWithMedicines(Map<String, Integer> medicines) {
        PdfPTable table = new PdfPTable(2);
        table.addCell("Nazwa leku");
        table.addCell("Ilosc");
        medicines.entrySet().forEach(entry -> {
            table.addCell(entry.getKey());
            table.addCell(entry.getValue().toString());
        });
        return table;
    }

    private void createResponse(HttpServletResponse response, Prescription prescription) {
        try {
            OutputStream o = response.getOutputStream();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=" + prescription.getTitle() + ".pdf");
            o.write(prescription.getPrescription());
            o.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
