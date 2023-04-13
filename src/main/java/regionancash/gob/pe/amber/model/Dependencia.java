package regionancash.gob.pe.amber.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "dependencias")
public class Dependencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length =1024, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

}
