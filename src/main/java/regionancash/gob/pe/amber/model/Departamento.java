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
@Table(name = "departamentos")
public class Departamento {
    @Id
    private String id;

    @Column(length =128, nullable = false)
    private String departamento;

    @JsonIgnore
    @OneToMany(mappedBy="departamento")
    private Set<Provincia> provincias;

}
