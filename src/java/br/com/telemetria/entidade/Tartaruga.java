
package br.com.telemetria.entidade;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Tartaruga")
public class Tartaruga implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "NumMarcaEncontrada")
    private String numMarcaEncontrada;
    
    @Column(name = "NumMarcaAplicada")
    private String numMarcaAplicada;
    
    @Column(name = "NumMarcaRemovida")
    private String numMarcaRemovida;
    
   
    @NotNull(message = "*Campo comprimento do casco obrigatório.")
    @Column(name = "ComprimentoCasco")
    private float comprimentoCasco;
    

    @NotNull(message = "*Campo largura do casco obrigatório.")
    @Column(name = "LarguraCasco")
    private float larguraCasco;
   
    @Column(name = "IdTransmissor")
    private Integer idTransmissor;
    
    @Column(name = "Peso")
    private Float peso;
   
    @Column(name = "Sexo")
    private String sexo;
   
    @JoinColumn(name = "IdEspecie_fk", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private EspecieTartaruga idEspeciefk;
   
    @JoinColumn(name = "IdIdade_fk", referencedColumnName = "Id")
    @ManyToOne
    private Idade idIdadefk;
    
    @JoinColumn(name = "IdTumores_fk", referencedColumnName = "Id")
    @ManyToOne
    private Tumores idTumoresfk;
    
   
    

    public Tartaruga() {
    }

    public Tartaruga(Integer id) {
        this.id = id;
    }

    public Tartaruga(Integer id, float comprimentoCasco, float larguraCasco) {
        this.id = id;
        this.comprimentoCasco = comprimentoCasco;
        this.larguraCasco = larguraCasco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumMarcaEncontrada() {
        return numMarcaEncontrada;
    }

    public void setNumMarcaEncontrada(String numMarcaEncontrada) {
        this.numMarcaEncontrada = numMarcaEncontrada;
    }

    public String getNumMarcaAplicada() {
        return numMarcaAplicada;
    }

    public void setNumMarcaAplicada(String numMarcaAplicada) {
        this.numMarcaAplicada = numMarcaAplicada;
    }

    public String getNumMarcaRemovida() {
        return numMarcaRemovida;
    }

    public void setNumMarcaRemovida(String numMarcaRemovida) {
        this.numMarcaRemovida = numMarcaRemovida;
    }

    public float getComprimentoCasco() {
        return comprimentoCasco;
    }

    public void setComprimentoCasco(float comprimentoCasco) {
        this.comprimentoCasco = comprimentoCasco;
    }

    public float getLarguraCasco() {
        return larguraCasco;
    }

    public void setLarguraCasco(float larguraCasco) {
        this.larguraCasco = larguraCasco;
    }

    public Integer getIdTransmissor() {
        return idTransmissor;
    }

    public void setIdTransmissor(Integer idTransmissor) {
        this.idTransmissor = idTransmissor;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public EspecieTartaruga getIdEspeciefk() {
        return idEspeciefk;
    }

    public void setIdEspeciefk(EspecieTartaruga idEspeciefk) {
        this.idEspeciefk = idEspeciefk;
    }

    public Idade getIdIdadefk() {
        return idIdadefk;
    }

    public void setIdIdadefk(Idade idIdadefk) {
        this.idIdadefk = idIdadefk;
    }

    public Tumores getIdTumoresfk() {
        return idTumoresfk;
    }

    public void setIdTumoresfk(Tumores idTumoresfk) {
        this.idTumoresfk = idTumoresfk;
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
        final Tartaruga other = (Tartaruga) obj;
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
