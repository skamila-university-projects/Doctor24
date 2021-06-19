package skamila.doctor24.visit.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import java.util.Map;

@Entity
@Setter
@Getter
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Visit visit;

    @ElementCollection
    @CollectionTable(name = "prescription_medicines",
            joinColumns = {@JoinColumn(name = "prescription_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "medicine_id")
    @Column(name = "quantity")
    private Map<Medicine, Integer> medicines;

}
