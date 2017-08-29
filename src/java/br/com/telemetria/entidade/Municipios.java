package br.com.telemetria.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Municipios")
public class Municipios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;

    @Basic(optional = false)
    @NotNull(message = "*Campo Código IBGE obrigatório.")
    @Column(name = "CodIBGE")
    private String codIBGE;

    @Basic(optional = false)
    @NotNull(message = "*Campo Município obrigatório.")
    @Column(name = "NomeMunicipio")
    private String nomeMunicipio;

    public Municipios() {
    }

    public Municipios(Integer id) {
        this.id = id;
    }

    public Municipios(Integer id, String codIBGE, String nomeMunicipio) {
        this.id = id;
        this.codIBGE = codIBGE;
        this.nomeMunicipio = nomeMunicipio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodIBGE() {
        return codIBGE;
    }

    public void setCodIBGE(String codIBGE) {
        this.codIBGE = codIBGE;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
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
        final Municipios other = (Municipios) obj;
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
