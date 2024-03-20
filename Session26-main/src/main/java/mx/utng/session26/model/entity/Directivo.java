package mx.utng.session26.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Directivo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(length = 90)
    private String nameDirec;

    @Column(length = 30)
    private String lastNameDirec;
    
    @NotEmpty
    @Column(length = 30)
    private String cargoDirec;
    
    @Min(value = 0)
    @Max(value = 30000)
    private Float Salario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDirec() {
        return nameDirec;
    }

    public void setNameDirec(String nameDirec) {
        this.nameDirec = nameDirec;
    }

    public String getLastNameDirec() {
        return lastNameDirec;
    }

    public void setLastNameDirec(String lastNameDirec) {
        this.lastNameDirec = lastNameDirec;
    }

    public String getCargoDirec() {
        return cargoDirec;
    }

    public void setCargoDirec(String cargoDirec) {
        this.cargoDirec = cargoDirec;
    }

    public Float getSalario() {
        return Salario;
    }

    public void setSalario(Float salario) {
        Salario = salario;
    }
    
    
}