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
@Table(name = "OcorrenciaNaoReprodutiva")
public class OcorrenciaNaoReprodutiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;

    @NotNull(message = "* colecaoCientifica")
    private boolean colecaoCientifica;

    private String numFichaColetaMB;

    @NotNull(message = "* responsavel")
    @Column(name = "Responsavel")
    private String responsavel;

    @NotNull(message = "* idCondicaoCorporalfk")
    @JoinColumn(name = "IdCondicaoCorporal_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private CondicaoCorporal idCondicaoCorporalfk;

    @NotNull(message = "* idDestinofk")
    @JoinColumn(name = "IdDestino_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Destino idDestinofk;

    @NotNull(message = "* idEstagioDecomposicaofk")
    @JoinColumn(name = "IdEstagioDecomposicao_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private EstagioDecomposicao idEstagioDecomposicaofk;

    @NotNull(message = "* idEvidenciaPescafk")
    @JoinColumn(name = "IdEvidenciaPesca_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private EvidenciaPesca idEvidenciaPescafk;

    @NotNull(message = "* idTipoRegistroNaoReprodutivofk")
    @JoinColumn(name = "IdTipoRegistroNaoReprodutivo_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private TipoRegistroNaoReprodutivo idTipoRegistroNaoReprodutivofk;

    @NotNull(message = "* idFormafk")
    @JoinColumn(name = "IdForma_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Forma idFormafk;

    @NotNull(message = "* idInteracaofk")
    @JoinColumn(name = "IdInteracao_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Interacao idInteracaofk;

    @JoinColumn(name = "IdOrigem_fk", referencedColumnName = "Id")
    @ManyToOne
    private Origem idOrigemfk;

    @NotNull(message = "* idOcorrenciafk")
    @JoinColumn(name = "IdOcorrencia_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Ocorrencia idOcorrenciafk;
    
    @NotNull(message = "* IdLocal_fk")
    @JoinColumn(name = "IdLocal_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Local IdLocal_fk;

    public OcorrenciaNaoReprodutiva() {
    }

    public OcorrenciaNaoReprodutiva(Integer id) {
        this.id = id;
    }

    public OcorrenciaNaoReprodutiva(Integer id, boolean colecaoCientifica, String responsavel) {
        this.id = id;
        this.colecaoCientifica = colecaoCientifica;
        this.responsavel = responsavel;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getColecaoCientifica() {
        return colecaoCientifica;
    }

    public void setColecaoCientifica(boolean colecaoCientifica) {
        this.colecaoCientifica = colecaoCientifica;
    }

    public String getNumFichaColetaMB() {
        return numFichaColetaMB;
    }

    public void setNumFichaColetaMB(String numFichaColetaMB) {
        this.numFichaColetaMB = numFichaColetaMB;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public CondicaoCorporal getIdCondicaoCorporalfk() {
        return idCondicaoCorporalfk;
    }

    public void setIdCondicaoCorporalfk(CondicaoCorporal idCondicaoCorporalfk) {
        this.idCondicaoCorporalfk = idCondicaoCorporalfk;
    }


    public Destino getIdDestinofk() {
        return idDestinofk;
    }

    public void setIdDestinofk(Destino idDestinofk) {
        this.idDestinofk = idDestinofk;
    }

    public EstagioDecomposicao getIdEstagioDecomposicaofk() {
        return idEstagioDecomposicaofk;
    }

    public void setIdEstagioDecomposicaofk(EstagioDecomposicao idEstagioDecomposicaofk) {
        this.idEstagioDecomposicaofk = idEstagioDecomposicaofk;
    }

    public EvidenciaPesca getIdEvidenciaPescafk() {
        return idEvidenciaPescafk;
    }

    public void setIdEvidenciaPescafk(EvidenciaPesca idEvidenciaPescafk) {
        this.idEvidenciaPescafk = idEvidenciaPescafk;
    }

    public TipoRegistroNaoReprodutivo getIdTipoRegistroNaoReprodutivofk() {
        return idTipoRegistroNaoReprodutivofk;
    }

    public void setIdTipoRegistroNaoReprodutivofk(TipoRegistroNaoReprodutivo idTipoRegistroNaoReprodutivofk) {
        this.idTipoRegistroNaoReprodutivofk = idTipoRegistroNaoReprodutivofk;
    }

    public Forma getIdFormafk() {
        return idFormafk;
    }

    public void setIdFormafk(Forma idFormafk) {
        this.idFormafk = idFormafk;
    }

    public Interacao getIdInteracaofk() {
        return idInteracaofk;
    }

    public void setIdInteracaofk(Interacao idInteracaofk) {
        this.idInteracaofk = idInteracaofk;
    }


    public Origem getIdOrigemfk() {
        return idOrigemfk;
    }

    public void setIdOrigemfk(Origem idOrigemfk) {
        this.idOrigemfk = idOrigemfk;
    }

    public Ocorrencia getIdOcorrenciafk() {
        return idOcorrenciafk;
    }

    public void setIdOcorrenciafk(Ocorrencia idOcorrenciafk) {
        this.idOcorrenciafk = idOcorrenciafk;
    }

    public Local getIdLocal_fk() {
        return IdLocal_fk;
    }

    public void setIdLocal_fk(Local IdLocal_fk) {
        this.IdLocal_fk = IdLocal_fk;
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
        final OcorrenciaNaoReprodutiva other = (OcorrenciaNaoReprodutiva) obj;
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
