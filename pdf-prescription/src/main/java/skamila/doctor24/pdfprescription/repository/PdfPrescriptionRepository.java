package skamila.doctor24.pdfprescription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skamila.doctor24.pdfprescription.domain.Prescription;

@Repository
public interface PdfPrescriptionRepository extends JpaRepository<Prescription, Long> {
}
