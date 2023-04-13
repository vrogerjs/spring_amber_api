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
@Table(name = "distritos")
public class Distrito {
    @Id
    private String id;

    @Column(length =128, nullable = false)
    private String distrito;

    @Column(length =64, nullable = false)
    private String temp;

    @JsonIgnore
    @OneToMany(mappedBy="distrito")
    private Set<Desaparecido> desaparecidos;

    @ManyToOne
    @JoinColumn(name="provincia_id", nullable=false)
    private Provincia provincia;
}
