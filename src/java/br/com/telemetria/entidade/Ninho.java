
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


@Entity
@Table(name = "Ninho")
public class Ninho implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    
    @Column(name = "NumNinho")
    private Integer numNinho;
   
    @Column(name = "QtdOvosTransferidos")
    private Integer qtdOvosTransferidos;
   
    @Column(name = "QtdOvosFurados")
    private Integer qtdOvosFurados;
   
    @Column(name = "QtdOvosNaoViaveis")
    private Integer qtdOvosNaoViaveis;
    
    
    @JoinColumn(name = "IdHistorioco_fk", referencedColumnName = "Id")
    @ManyToOne
    private HistoricoNinho idHistorioco;
    
    @Column(name = "DataEclosao")
    @Temporal(TemporalType.DATE)
    private Date dataEclosao;
   
    @Column(name = "DataAbertura")
    @Temporal(TemporalType.DATE)
    private Date dataAbertura;
   
    @Column(name = "QtdVivos")
    private Integer qtdVivos;
   
    @Column(name = "QtdNatimortos")
    private Integer qtdNatimortos;
   
    @Column(name = "QtdOvosNaoEclodidos")
    private Integer qtdOvosNaoEclodidos;
    
    @Column(name = "TempoIncubacao")
    private Integer tempoIncubacao;
    
    @Column(name = "Observacoes")
    private String observacoes;
    

    public Ninho() {
    }

    public Ninho(Integer id) {
        this.id = id;
    }

    public Ninho(Integer id, Integer numNinho) {
        this.id = id;
        this.numNinho = numNinho;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumNinho() {
        return numNinho;
    }

    public void setNumNinho(Integer numNinho) {
        this.numNinho = numNinho;
    }

    public Integer getQtdOvosTransferidos() {
        return qtdOvosTransferidos;
    }

    public void setQtdOvosTransferidos(Integer qtdOvosTransferidos) {
        this.qtdOvosTransferidos = qtdOvosTransferidos;
    }

    public Integer getQtdOvosFurados() {
        return qtdOvosFurados;
    }

    public void setQtdOvosFurados(Integer qtdOvosFurados) {
        this.qtdOvosFurados = qtdOvosFurados;
    }

    public Integer getQtdOvosNaoViaveis() {
        return qtdOvosNaoViaveis;
    }

    public void setQtdOvosNaoViaveis(Integer qtdOvosNaoViaveis) {
        this.qtdOvosNaoViaveis = qtdOvosNaoViaveis;
    }

    public Date getDataEclosao() {
        return dataEclosao;
    }

    public void setDataEclosao(Date dataEclosao) {
        this.dataEclosao = dataEclosao;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Integer getQtdVivos() {
        return qtdVivos;
    }

    public void setQtdVivos(Integer qtdVivos) {
        this.qtdVivos = qtdVivos;
    }

    public Integer getQtdNatimortos() {
        return qtdNatimortos;
    }

    public void setQtdNatimortos(Integer qtdNatimortos) {
        this.qtdNatimortos = qtdNatimortos;
    }

    public Integer getQtdOvosNaoEclodidos() {
        return qtdOvosNaoEclodidos;
    }

    public void setQtdOvosNaoEclodidos(Integer qtdOvosNaoEclodidos) {
        this.qtdOvosNaoEclodidos = qtdOvosNaoEclodidos;
    }

    public Integer getTempoIncubacao() {
        return tempoIncubacao;
    }

    public void setTempoIncubacao(Integer tempoIncubacao) {
        this.tempoIncubacao = tempoIncubacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public HistoricoNinho getIdHistorioco() {
        return idHistorioco;
    }

    public void setIdHistorioco(HistoricoNinho idHistorioco) {
        this.idHistorioco = idHistorioco;
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
        final Ninho other = (Ninho) obj;
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
