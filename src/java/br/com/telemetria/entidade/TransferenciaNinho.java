
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
@Table(name = "TransferenciaNinho")
public class TransferenciaNinho implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
   
    @Column(name = "LocalEspecifico")
    private String localEspecifico;
   
    @JoinColumn(name = "IdTempoTransf_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private TempoTransferencia idTempoTransferenciafk;
    
    @JoinColumn(name = "IdCoordenadasGeograficas_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private CoordenadasGeograficas idCoordenadasGeograficasfk;
   
    @JoinColumn(name = "IdPraia_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Praias idPraiafk;


    public TransferenciaNinho() {
    }

    public TransferenciaNinho(Integer id) {
        this.id = id;
    }

    public TransferenciaNinho(Integer id,  TempoTransferencia idTempoTransferenciafk) {
        this.id = id;
        this.idTempoTransferenciafk = idTempoTransferenciafk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalEspecifico() {
        return localEspecifico;
    }

    public void setLocalEspecifico(String localEspecifico) {
        this.localEspecifico = localEspecifico;
    }

    public TempoTransferencia getIdTempoTransferenciafk() {
        return idTempoTransferenciafk;
    }

    public void setIdTempoTransferenciafk(TempoTransferencia idTempoTransferenciafk) {
        this.idTempoTransferenciafk = idTempoTransferenciafk;
    }

    public CoordenadasGeograficas getIdCoordenadasGeograficasfk() {
        return idCoordenadasGeograficasfk;
    }

    public void setIdCoordenadasGeograficasfk(CoordenadasGeograficas idCoordenadasGeograficasfk) {
        this.idCoordenadasGeograficasfk = idCoordenadasGeograficasfk;
    }

    public Praias getIdPraiafk() {
        return idPraiafk;
    }

    public void setIdPraiafk(Praias idPraiafk) {
        this.idPraiafk = idPraiafk;
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
        final TransferenciaNinho other = (TransferenciaNinho) obj;
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
