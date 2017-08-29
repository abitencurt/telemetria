
package br.com.telemetria.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ColetaAmostras")
public class ColetaAmostras implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    
  
    private String laudoToxicologico;
   
    private String laudoMicrobiologico;

    private String laudoParasitologico;
    
    private String laudoHistopatologico;
   
    private String observacoes;


    public ColetaAmostras() {
    }

    public ColetaAmostras(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLaudoToxicologico() {
        return laudoToxicologico;
    }

    public void setLaudoToxicologico(String laudoToxicologico) {
        this.laudoToxicologico = laudoToxicologico;
    }

    public String getLaudoMicrobiologico() {
        return laudoMicrobiologico;
    }

    public void setLaudoMicrobiologico(String laudoMicrobiologico) {
        this.laudoMicrobiologico = laudoMicrobiologico;
    }

    public String getLaudoParasitologico() {
        return laudoParasitologico;
    }

    public void setLaudoParasitologico(String laudoParasitologico) {
        this.laudoParasitologico = laudoParasitologico;
    }

    public String getLaudoHistopatologico() {
        return laudoHistopatologico;
    }

    public void setLaudoHistopatologico(String laudoHistopatologico) {
        this.laudoHistopatologico = laudoHistopatologico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColetaAmostras)) {
            return false;
        }
        ColetaAmostras other = (ColetaAmostras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telemetria.entidade.ColetaAmostras[ id=" + id + " ]";
    }
    
}
