
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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Reabilitacao")
public class Reabilitacao implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    @NotNull(message = "*Campo veterinario da praia obrigatório.")
    private String veterinario;
   
    @NotNull(message = "*Campo numeroFicha da praia obrigatório.")
    private Integer numeroFicha;
  
    private String anilhas;
  
    @NotNull(message = "*Campo dataSaida da praia obrigatório.")
    @Temporal(TemporalType.TIME)
    private Date dataSaida;
    
    private Integer tempoDeReabilitacao;
    
    private String status;
    
    @NotNull(message = "*Campo comprimentoCascoSaida da praia obrigatório.")
    private float comprimentoCascoSaida;
   
    @NotNull(message = "*Campo larguraCascoSaida da praia obrigatório.")
    private float larguraCascoSaida;
    
    private float pesoSaida;
    
    private String quadroClinico;
    
    private String suspeitaClinica;
    
    private String anilhaSoltura;
    
    private String amostrasColetadas;
    
    @NotNull(message = "*Campo registrosFotografico da praia obrigatório.")
    private boolean registrosFotografico;
    
    @NotNull(message = "*Campo laudoMicrobiologico da praia obrigatório.")
    private String  laudoMicrobiologico;
    
    @NotNull(message = "*Campo laudoHematBioq da praia obrigatório.")
    private String laudoHematBioq;
    
    @NotNull(message = "*Campo laudoCoproparas da praia obrigatório.")
    private String laudoCoproparas;
    
    @NotNull(message = "*Campo resRaiox da praia obrigatório.")
    private String resRaiox;
    
    @NotNull(message = "*Campo observacoes da praia obrigatório.")
    private String observacoes;
    
    @NotNull(message = "* idOcorrenciaNAOReprodutivafk")
    @JoinColumn(name = "idOcorrenciaNAOReprodutiva_fk", referencedColumnName = "Id")
    @ManyToOne
    private OcorrenciaNaoReprodutiva idOcorrenciaNAOReprodutivafk;
    
    @NotNull(message = "* idColetaTecidosfk")
    @JoinColumn(name = "idColetaTecidos_fk", referencedColumnName = "Id")
    @ManyToOne
    private ColetaTecidos idColetaTecidosfk;
    
    @NotNull(message = "* idColetaAmostrasfk")
    @JoinColumn(name = "idColetaAmostras_fk", referencedColumnName = "Id")
    @ManyToOne
    private ColetaAmostras idColetaAmostrasfk;

    public Reabilitacao() {
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

    public Integer getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(Integer numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public String getAnilhas() {
        return anilhas;
    }

    public void setAnilhas(String anilhas) {
        this.anilhas = anilhas;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Integer getTempoDeReabilitacao() {
        return tempoDeReabilitacao;
    }

    public void setTempoDeReabilitacao(Integer tempoDeReabilitacao) {
        this.tempoDeReabilitacao = tempoDeReabilitacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getComprimentoCascoSaida() {
        return comprimentoCascoSaida;
    }

    public void setComprimentoCascoSaida(float comprimentoCascoSaida) {
        this.comprimentoCascoSaida = comprimentoCascoSaida;
    }

    public float getLarguraCascoSaida() {
        return larguraCascoSaida;
    }

    public void setLarguraCascoSaida(float larguraCascoSaida) {
        this.larguraCascoSaida = larguraCascoSaida;
    }

    public float getPesoSaida() {
        return pesoSaida;
    }

    public void setPesoSaida(float pesoSaida) {
        this.pesoSaida = pesoSaida;
    }

    public String getQuadroClinico() {
        return quadroClinico;
    }

    public void setQuadroClinico(String quadroClinico) {
        this.quadroClinico = quadroClinico;
    }

    public String getSuspeitaClinica() {
        return suspeitaClinica;
    }

    public void setSuspeitaClinica(String suspeitaClinica) {
        this.suspeitaClinica = suspeitaClinica;
    }

    public String getAnilhaSoltura() {
        return anilhaSoltura;
    }

    public void setAnilhaSoltura(String anilhaSoltura) {
        this.anilhaSoltura = anilhaSoltura;
    }

    public String getAmostrasColetadas() {
        return amostrasColetadas;
    }

    public void setAmostrasColetadas(String amostrasColetadas) {
        this.amostrasColetadas = amostrasColetadas;
    }

    public boolean isRegistrosFotografico() {
        return registrosFotografico;
    }

    public void setRegistrosFotografico(boolean registrosFotografico) {
        this.registrosFotografico = registrosFotografico;
    }

    public String getLaudoMicrobiologico() {
        return laudoMicrobiologico;
    }

    public void setLaudoMicrobiologico(String laudoMicrobiologico) {
        this.laudoMicrobiologico = laudoMicrobiologico;
    }

    public String getLaudoHematBioq() {
        return laudoHematBioq;
    }

    public void setLaudoHematBioq(String laudoHematBioq) {
        this.laudoHematBioq = laudoHematBioq;
    }

    public String getLaudoCoproparas() {
        return laudoCoproparas;
    }

    public void setLaudoCoproparas(String laudoCoproparas) {
        this.laudoCoproparas = laudoCoproparas;
    }

    public String getResRaiox() {
        return resRaiox;
    }

    public void setResRaiox(String resRaiox) {
        this.resRaiox = resRaiox;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public OcorrenciaNaoReprodutiva getIdOcorrenciaNAOReprodutivafk() {
        return idOcorrenciaNAOReprodutivafk;
    }

    public void setIdOcorrenciaNAOReprodutivafk(OcorrenciaNaoReprodutiva idOcorrenciaNAOReprodutivafk) {
        this.idOcorrenciaNAOReprodutivafk = idOcorrenciaNAOReprodutivafk;
    }

    public ColetaTecidos getIdColetaTecidosfk() {
        return idColetaTecidosfk;
    }

    public void setIdColetaTecidosfk(ColetaTecidos idColetaTecidosfk) {
        this.idColetaTecidosfk = idColetaTecidosfk;
    }

    public ColetaAmostras getIdColetaAmostrasfk() {
        return idColetaAmostrasfk;
    }

    public void setIdColetaAmostrasfk(ColetaAmostras idColetaAmostrasfk) {
        this.idColetaAmostrasfk = idColetaAmostrasfk;
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
        final Reabilitacao other = (Reabilitacao) obj;
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
