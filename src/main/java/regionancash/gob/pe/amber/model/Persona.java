package regionancash.gob.pe.amber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length =8, nullable = false, unique = true)
    private String dni;

    @Column(length =64, nullable = false)
    private String nombres;

    @Column(length =64, nullable = false)
    private String apePaterno;

    @Column(length =64, nullable = false)
    private String apeMaterno;

    @Column(columnDefinition = "TEXT")
    private String direccion;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private Integer edad;

    @Column(nullable = false, length = 16)
    private String sexo;

    @Column(nullable = false, length = 16)
    private String estadoCivil;

    @Column(columnDefinition = "TEXT")
    private String foto;

    @JsonIgnore
    @OneToMany(mappedBy="persona")
    private Set<Desaparecido> desaparecidos;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;
}
