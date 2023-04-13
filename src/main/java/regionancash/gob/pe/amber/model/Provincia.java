package regionancash.gob.pe.amber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "provincias")
public class Provincia {
    @Id
    private String id;

    @Column(length =128, nullable = false)
    private String provincia;

    @JsonIgnore
    @OneToMany(mappedBy="provincia")
    private Set<Distrito> distritos;

    @ManyToOne
    @JoinColumn(name="departamento_id", nullable=false)
    private Departamento departamento;
}
