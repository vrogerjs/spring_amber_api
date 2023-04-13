package regionancash.gob.pe.amber.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "informacions")
public class Informacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length =8, nullable = false)
    private String dni;

    @Column(length =1024, nullable = false)
    private String apeNombres;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    @Column(columnDefinition = "TEXT")
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name="desaparecido_id", nullable=false)
    private Desaparecido desaparecido;
}
