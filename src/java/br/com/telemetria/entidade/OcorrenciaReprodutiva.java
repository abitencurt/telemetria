
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


@Entity
@Table(name = "OcorrenciaReprodutiva")
public class OcorrenciaReprodutiva implements Serializable {

    private static final long serialVersionUID = 1L;
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "MonitorPraia")
    private String monitorPraia;
    
    @JoinColumn(name = "IdNinho_fk", referencedColumnName = "Id")
    @ManyToOne
    private Ninho idNinhofk;
    
    @JoinColumn(name = "IdOcorrencia_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Ocorrencia idOcorrenciafk;
    
    @JoinColumn(name = "IdSituacaoOcorrenciaReprodutivo_fk", referencedColumnName = "Id")
    @ManyToOne
    private SituacaoOcorrenciaReprodutivo idSituacaoOcorrenciaReprodutivofk;
    
    @JoinColumn(name = "IdTipoOcorrenciaReprodutivo_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private TipoOcorrenciaReprodutivo idTipoOcorrenciaReprodutivofk;
   
    @JoinColumn(name = "IdTransferenciaNinho_fk", referencedColumnName = "Id")
    @ManyToOne
    private TransferenciaNinho idTransferenciaNinhofk;

    public OcorrenciaReprodutiva() {
    }

    public OcorrenciaReprodutiva(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonitorPraia() {
        return monitorPraia;
    }

    public void setMonitorPraia(String monitorPraia) {
        this.monitorPraia = monitorPraia;
    }

    public Ninho getIdNinhofk() {
        return idNinhofk;
    }

    public void setIdNinhofk(Ninho idNinhofk) {
        this.idNinhofk = idNinhofk;
    }

    public Ocorrencia getIdOcorrenciafk() {
        return idOcorrenciafk;
    }

    public void setIdOcorrenciafk(Ocorrencia idOcorrenciafk) {
        this.idOcorrenciafk = idOcorrenciafk;
    }

    public SituacaoOcorrenciaReprodutivo getIdSituacaoOcorrenciaReprodutivofk() {
        return idSituacaoOcorrenciaReprodutivofk;
    }

    public void setIdSituacaoOcorrenciaReprodutivofk(SituacaoOcorrenciaReprodutivo idSituacaoOcorrenciaReprodutivofk) {
        this.idSituacaoOcorrenciaReprodutivofk = idSituacaoOcorrenciaReprodutivofk;
    }

    public TipoOcorrenciaReprodutivo getIdTipoOcorrenciaReprodutivofk() {
        return idTipoOcorrenciaReprodutivofk;
    }

    public void setIdTipoOcorrenciaReprodutivofk(TipoOcorrenciaReprodutivo idTipoOcorrenciaReprodutivofk) {
        this.idTipoOcorrenciaReprodutivofk = idTipoOcorrenciaReprodutivofk;
    }

    public TransferenciaNinho getIdTransferenciaNinhofk() {
        return idTransferenciaNinhofk;
    }

    public void setIdTransferenciaNinhofk(TransferenciaNinho idTransferenciaNinhofk) {
        this.idTransferenciaNinhofk = idTransferenciaNinhofk;
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
        final OcorrenciaReprodutiva other = (OcorrenciaReprodutiva) obj;
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
