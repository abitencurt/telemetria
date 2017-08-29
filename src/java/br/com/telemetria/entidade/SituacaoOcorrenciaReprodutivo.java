
package br.com.telemetria.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name =  "SituacaoOcorrenciaReprodutivo")
public class SituacaoOcorrenciaReprodutivo implements Serializable {

    private static final long serialVersionUID = 1L;
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull(message = "*Campo Código obrigatório.")
    @Column(name = "Codigo")
    private String codigo;
    
    @Basic(optional = false)
    @NotNull(message = "*Campo Descrição obrigatório.")
    @Column(name = "Descricao")
    private String descricao;
    
    @NotNull(message = "*Campo transferência obirgatório")
    @Column(name ="IsTransfer")
    private boolean isTransfer;

    public SituacaoOcorrenciaReprodutivo() {
    }

    public SituacaoOcorrenciaReprodutivo(Integer id) {
        this.id = id;
    }

    public SituacaoOcorrenciaReprodutivo(Integer id, String codigo, String descricao) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isIsTransfer() {
        return isTransfer;
    }

    public void setIsTransfer(boolean isTransfer) {
        this.isTransfer = isTransfer;
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
        final SituacaoOcorrenciaReprodutivo other = (SituacaoOcorrenciaReprodutivo) obj;
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
