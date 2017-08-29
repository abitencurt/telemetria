
package br.com.telemetria.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Praias")
public class Praias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
   
    @Basic(optional = false)
    @NotNull(message = "*Campo Código da praia obrigatório.")
    @Column(name = "CodigoPraia")
    private String codigoPraia;
    
    @Basic(optional = false)
    @NotNull(message = "*Campo Nome da praia obrigatório.")
    @Column(name = "NomePraia")
    private String nomePraia;
      
    @JoinColumn(name = "IdMunicipio_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Municipios idMunicipiofk;

    public Praias() {
    }

    public Praias(Integer id) {
        this.id = id;
    }

    public Praias(Integer id, String codigoPraia, String nomePraia) {
        this.id = id;
        this.codigoPraia = codigoPraia;
        this.nomePraia = nomePraia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoPraia() {
        return codigoPraia;
    }

    public void setCodigoPraia(String codigoPraia) {
        this.codigoPraia = codigoPraia;
    }

    public String getNomePraia() {
        return nomePraia;
    }

    public void setNomePraia(String nomePraia) {
        this.nomePraia = nomePraia;
    }

    public Municipios getIdMunicipiofk() {
        return idMunicipiofk;
    }

    public void setIdMunicipiofk(Municipios idMunicipiofk) {
        this.idMunicipiofk = idMunicipiofk;
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
        final Praias other = (Praias) obj;
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
