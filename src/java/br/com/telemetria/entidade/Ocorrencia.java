
package br.com.telemetria.entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Ocorrencia")
public class Ocorrencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "NumDiarioCampo")
    private String numDiarioCampo;
   
    @Column(name = "NumTrechoRegistro")
    private String numTrechoRegistro;
    
    @Column(name = "NumRegTamar")
    private String numRegTamar;
    
    @Basic(optional = false)
    @NotNull(message = "*Campo data da ocorrência obrigatório")
    @Column(name = "DataOcorrencia")
    @Temporal(TemporalType.DATE)
    private Date dataOcorrencia;
    
    @Transient
    private Date termino;
   
    @Column(name = "HoraOcorrencia")
    @Temporal(TemporalType.TIME)
    private Date horaOcorrencia;
   
    @Column(name = "LocalKM")
    private String localKM;
    
    @Column(name = "Observacoes")
    private String observacoes;
   
    @JoinColumn(name = "IdCoordenadasGeograficas_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private CoordenadasGeograficas idCoordenadasGeograficasfk;
   
    @JoinColumn(name = "IdPraia_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Praias idPraiafk;
   
    @JoinColumn(name = "IdSubBase_fk", referencedColumnName = "Id")
    @ManyToOne
    private SubBase idSubBasefk;
   
    @JoinColumn(name = "IdTartaruga_fk", referencedColumnName = "Id")
    @ManyToOne
    private Tartaruga idTartarugafk;
    

    public Ocorrencia() {
    }

    public Ocorrencia(Integer id) {
        this.id = id;
    }

    public Ocorrencia(Integer id, Date dataOcorrencia) {
        this.id = id;
        this.dataOcorrencia = dataOcorrencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumDiarioCampo() {
        return numDiarioCampo;
    }

    public void setNumDiarioCampo(String numDiarioCampo) {
        this.numDiarioCampo = numDiarioCampo;
    }

    public String getNumTrechoRegistro() {
        return numTrechoRegistro;
    }

    public void setNumTrechoRegistro(String numTrechoRegistro) {
        this.numTrechoRegistro = numTrechoRegistro;
    }

    public String getNumRegTamar() {
        return numRegTamar;
    }

    public void setNumRegTamar(String numRegTamar) {
        this.numRegTamar = numRegTamar;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }
    
    

    public Date getHoraOcorrencia() {
        return horaOcorrencia;
    }

    public void setHoraOcorrencia(Date horaOcorrencia) {
        this.horaOcorrencia = horaOcorrencia;
    }

    public String getLocalKM() {
        return localKM;
    }

    public void setLocalKM(String localKM) {
        this.localKM = localKM;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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

    public SubBase getIdSubBasefk() {
        return idSubBasefk;
    }

    public void setIdSubBasefk(SubBase idSubBasefk) {
        this.idSubBasefk = idSubBasefk;
    }

    public Tartaruga getIdTartarugafk() {
        return idTartarugafk;
    }

    public void setIdTartarugafk(Tartaruga idTartarugafk) {
        this.idTartarugafk = idTartarugafk;
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
        final Ocorrencia other = (Ocorrencia) obj;
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
