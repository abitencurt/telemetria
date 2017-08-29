
package br.com.telemetria.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "InteracaoAntropica")
class InteracaoAntropica implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    

    @NotNull(message = "*Campo código obrigatorio.")
    @Column(name = "Codigo")
    private String codigo;
    
    @NotNull(message = "*Campo descrição obrigatorio.")
    @Column(name = "Descricao")
    private String descricao;
    
}
