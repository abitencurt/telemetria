
package br.com.telemetria.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "ColetaTecidos")
public class ColetaTecidos implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
   
    @NotNull
    private String responsavel;
   
    @NotNull
    private int numeroFicha;
   
    @NotNull
    @Column(name = "Anilhas")
    private String anilhas;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataColeta;
   
    @NotNull
    private String laudoToxicologico;
 
    @NotNull
    @Column(name = "LaudoMicrobiologico")
    private String laudoMicrobiologico;
  
    @NotNull
    private String laudoParasitologico;

    @NotNull
    private String laudoHistopatologico;
 
    @NotNull
    private String observacoes;

    public ColetaTecidos() {
    }

    public ColetaTecidos(Integer id) {
        this.id = id;
    }

    public ColetaTecidos(Integer id, String responsavel, int numeroFicha, String anilhas, Date dataColeta, String laudoToxicologico, String laudoMicrobiologico, String laudoParasitologico, String laudoHistopatologico, String observacoes) {
        this.id = id;
        this.responsavel = responsavel;
        this.numeroFicha = numeroFicha;
        this.anilhas = anilhas;
        this.dataColeta = dataColeta;
        this.laudoToxicologico = laudoToxicologico;
        this.laudoMicrobiologico = laudoMicrobiologico;
        this.laudoParasitologico = laudoParasitologico;
        this.laudoHistopatologico = laudoHistopatologico;
        this.observacoes = observacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public int getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(int numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public String getAnilhas() {
        return anilhas;
    }

    public void setAnilhas(String anilhas) {
        this.anilhas = anilhas;
    }

    public Date getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(Date dataColeta) {
        this.dataColeta = dataColeta;
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
        if (!(object instanceof ColetaTecidos)) {
            return false;
        }
        ColetaTecidos other = (ColetaTecidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telemetria.entidade.ColetaTecidos[ id=" + id + " ]";
    }
    
}
