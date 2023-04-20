package regionancash.gob.pe.amber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "desaparecidos")
public class Desaparecido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length =32, nullable = false)
    private String nroDenuncia;

    private Date fechaHoraDenuncia;

    private Date fechaHoraHecho;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String lugarHecho;

    @Column(length =512, nullable = false)
    private String tez;

    @Column(length =512, nullable = false)
    private String fenotipo;

    @Column(length =512, nullable = false)
    private String ojos;

    @Column(length =512, nullable = false)
    private String sangre;

    @Column(length =512, nullable = false)
    private String boca;

    @Column(length =512, nullable = false)
    private String nariz;

    @Column(length =512, nullable = false)
    private String cabello;

    @Column(length =512, nullable = false)
    private String estatura;

    @Column(length =512, nullable = false)
    private String contextura;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String vestimenta;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String circunstancia;

    @Column(columnDefinition = "TEXT")
    private String observacion;

    @Column(length =16)
    private String nroContacto;

    @Column(length =512, nullable = false)
    private String estado;

    @Column(length =512, nullable = false)
    private String latitud;

    @Column(length =512, nullable = false)
    private String longitud;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="persona_id", nullable=false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="distrito_id", nullable=false)
    private Distrito distrito;

    @ManyToOne
    @JoinColumn(name="dependencia_id", nullable=false)
    private Dependencia dependencia;

    @JsonIgnore
    @OneToMany(mappedBy="desaparecido")
    private Set<Informacion> informacions;
}
