
package br.com.telemetria.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "InteracaoAntropicaXNecropsia")
public class InteracaoAntropicaXNecropsia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    @JoinColumn(name = "IdInteracaoAntropica_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private InteracaoAntropica idInteracaoAntropicafk;
    
    @JoinColumn(name = "IdNecropsia_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Necropsia idNecropsiafk;

    public InteracaoAntropicaXNecropsia() {
    }

    public InteracaoAntropicaXNecropsia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InteracaoAntropica getIdInteracaoAntropicafk() {
        return idInteracaoAntropicafk;
    }

    public void setIdInteracaoAntropicafk(InteracaoAntropica idInteracaoAntropicafk) {
        this.idInteracaoAntropicafk = idInteracaoAntropicafk;
    }

    public Necropsia getIdNecropsiafk() {
        return idNecropsiafk;
    }

    public void setIdNecropsiafk(Necropsia idNecropsiafk) {
        this.idNecropsiafk = idNecropsiafk;
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
        if (!(object instanceof InteracaoAntropicaXNecropsia)) {
            return false;
        }
        InteracaoAntropicaXNecropsia other = (InteracaoAntropicaXNecropsia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telemetria.entidade.InteracaoAntropicaXNecropsia[ id=" + id + " ]";
    }
    
}
