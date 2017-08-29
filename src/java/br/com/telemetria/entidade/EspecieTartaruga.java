package br.com.telemetria.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "EspecieTartaruga")
public class EspecieTartaruga implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;

    @Basic(optional = false)
    @NotNull(message = "*Campo Sigla obrigatório.")
    @Column(name = "Sigla")
    private String sigla;

    @Basic(optional = false)
    @NotNull(message = "*Campo Espécie obrigatório.")
    @Column(name = "Especie")
    private String especie;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="idEspeciefk")
    private List<Tartaruga> tartarugas = new ArrayList<>(); 

    public EspecieTartaruga() {
    }

    public EspecieTartaruga(Integer id) {
        this.id = id;
    }

    public EspecieTartaruga(Integer id, String sigla, String especie) {
        this.id = id;
        this.sigla = sigla;
        this.especie = especie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public List<Tartaruga> getTartarugas() {
        return tartarugas;
    }

    public void setTartarugas(List<Tartaruga> tartarugas) {
        this.tartarugas = tartarugas;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EspecieTartaruga other = (EspecieTartaruga) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

}
