package mx.utng.session26.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Paraescolar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Date getInicio() {
        return Inicio;
    }

    public void setInicio(Date inicio) {
        Inicio = inicio;
    }

    @NotEmpty
    @Column(length = 30)
    private String namePara;

    @Column(length = 30)
    private String NombreInstructor;

    @NotEmpty
    @Column(length = 30)
    private String lastNameInstructor;

    @Min(value = 0)
    @Max(value = 60)
    private Float HorasPracticadas;

    @Temporal(TemporalType.DATE)
    private Date Inicio;
    @PrePersist
    public void prePersist(){
        Inicio = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePara() {
        return namePara;
    }

    public void setNamePara(String namePara) {
        this.namePara = namePara;
    }

    public String getNombreInstructor() {
        return NombreInstructor;
    }

    public void setNombreInstructor(String nombreInstructor) {
        NombreInstructor = nombreInstructor;
    }

    public String getLastNameInstructor() {
        return lastNameInstructor;
    }

    public void setLastNameInstructor(String lastNameInstructor) {
        this.lastNameInstructor = lastNameInstructor;
    }

    public Float getHorasPracticadas() {
        return HorasPracticadas;
    }

    public void setHorasPracticadas(Float horasPracticadas) {
        HorasPracticadas = horasPracticadas;
    }

}
