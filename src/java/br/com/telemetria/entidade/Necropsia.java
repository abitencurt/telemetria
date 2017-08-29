
package br.com.telemetria.entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Necropsia")
public class Necropsia implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    @NotNull
    private String veterinario;

    @NotNull
    @Column(name = "NumeroFicha")
    private int numeroFicha;
    
    private Integer numeroFichaReabilitacao;
  
    @NotNull
    private int numeroRegistro;

    private String anilhas;
        
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataNecropsia;
        
    @NotNull
    private String achadosNecroscopicos;
   
    private String parasito;
   
    private String lixoLocalizacao;
   
    private String lixoConteudo;
  
    @NotNull
    private boolean registroFotografico;
   
    private String coletaAmostras;
    
    @NotNull
    private String laudoToxicologico;
  
    @NotNull
    private String laudoMicrobiologico;
  
    @NotNull
    private String laudoParasitologico;
   
    @NotNull
    private String laudoHistopatologico;
   
    @NotNull
    private String diagnosticoFinal;
   
    @NotNull
    private String observacoes;
    
    @NotNull(message = "*Campo registrosFotografico da praia obrigatório.")
    private boolean registrosFotografico;
    
    @JoinColumn(name = "IdCausaPrimaria_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private CausaPrimaria idCausaPrimariafk;
  
    @JoinColumn(name = "IdCausaSecundaria_fk", referencedColumnName = "Id")
    @ManyToOne
    private CausaSecundaria idCausaSecundariafk;
    
    @JoinColumn(name = "IdCondicaoNecropsia_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private CondicaoNecropsia idCondicaoNecropsiafk;
    

    public Necropsia() {
    }

    public Necropsia(Integer id) {
        this.id = id;
    }

    public Necropsia(Integer id, String veterinario, int numeroFicha, int numeroRegistro, Date dataNecropsia, String achadosNecroscopicos, int idInteracaoAntropicaXNecropsiafk, boolean registroFotografico, String laudoToxicologico, String laudoMicrobiologico, String laudoParasitologico, String laudoHistopatologico, String diagnosticoFinal, String observacoes) {
        this.id = id;
        this.veterinario = veterinario;
        this.numeroFicha = numeroFicha;
        this.numeroRegistro = numeroRegistro;
        this.dataNecropsia = dataNecropsia;
        this.achadosNecroscopicos = achadosNecroscopicos;
        this.registroFotografico = registroFotografico;
        this.laudoToxicologico = laudoToxicologico;
        this.laudoMicrobiologico = laudoMicrobiologico;
        this.laudoParasitologico = laudoParasitologico;
        this.laudoHistopatologico = laudoHistopatologico;
        this.diagnosticoFinal = diagnosticoFinal;
        this.observacoes = observacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public int getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(int numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public Integer getNumeroFichaReabilitacao() {
        return numeroFichaReabilitacao;
    }

    public void setNumeroFichaReabilitacao(Integer numeroFichaReabilitacao) {
        this.numeroFichaReabilitacao = numeroFichaReabilitacao;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getAnilhas() {
        return anilhas;
    }

    public void setAnilhas(String anilhas) {
        this.anilhas = anilhas;
    }

    public Date getDataNecropsia() {
        return dataNecropsia;
    }

    public void setDataNecropsia(Date dataNecropsia) {
        this.dataNecropsia = dataNecropsia;
    }

    public String getAchadosNecroscopicos() {
        return achadosNecroscopicos;
    }

    public void setAchadosNecroscopicos(String achadosNecroscopicos) {
        this.achadosNecroscopicos = achadosNecroscopicos;
    }

    public String getParasito() {
        return parasito;
    }

    public void setParasito(String parasito) {
        this.parasito = parasito;
    }

    public String getLixoLocalizacao() {
        return lixoLocalizacao;
    }

    public void setLixoLocalizacao(String lixoLocalizacao) {
        this.lixoLocalizacao = lixoLocalizacao;
    }

    public String getLixoConteudo() {
        return lixoConteudo;
    }

    public void setLixoConteudo(String lixoConteudo) {
        this.lixoConteudo = lixoConteudo;
    }


    public boolean getRegistroFotografico() {
        return registroFotografico;
    }

    public void setRegistroFotografico(boolean registroFotografico) {
        this.registroFotografico = registroFotografico;
    }

    public String getColetaAmostras() {
        return coletaAmostras;
    }

    public void setColetaAmostras(String coletaAmostras) {
        this.coletaAmostras = coletaAmostras;
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

    public String getDiagnosticoFinal() {
        return diagnosticoFinal;
    }

    public void setDiagnosticoFinal(String diagnosticoFinal) {
        this.diagnosticoFinal = diagnosticoFinal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public CausaPrimaria getIdCausaPrimariafk() {
        return idCausaPrimariafk;
    }

    public void setIdCausaPrimariafk(CausaPrimaria idCausaPrimariafk) {
        this.idCausaPrimariafk = idCausaPrimariafk;
    }

    public CausaSecundaria getIdCausaSecundariafk() {
        return idCausaSecundariafk;
    }

    public void setIdCausaSecundariafk(CausaSecundaria idCausaSecundariafk) {
        this.idCausaSecundariafk = idCausaSecundariafk;
    }

    public CondicaoNecropsia getIdCondicaoNecropsiafk() {
        return idCondicaoNecropsiafk;
    }

    public void setIdCondicaoNecropsiafk(CondicaoNecropsia idCondicaoNecropsiafk) {
        this.idCondicaoNecropsiafk = idCondicaoNecropsiafk;
    }

    public boolean isRegistrosFotografico() {
        return registrosFotografico;
    }

    public void setRegistrosFotografico(boolean registrosFotografico) {
        this.registrosFotografico = registrosFotografico;
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
        if (!(object instanceof Necropsia)) {
            return false;
        }
        Necropsia other = (Necropsia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.telemetria.entidade.Necropsia[ id=" + id + " ]";
    }
    
}
