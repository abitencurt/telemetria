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
@Table(name = "CoordenadasGeograficas")
public class CoordenadasGeograficas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @NotNull(message = "*Campo Tipo coordenada obrigatório.")
    @Column(name = "TipoCoordenada")
    private String tipoCoordenada = " - ";

    @NotNull(message = "*Campo Latitude obrigatório.")
    @Column(name = "Latitude")
    private String latitude;

    @NotNull(message = "*Campo Longitude obrigatório.")
    @Column(name = "Longitude")
    private String longitude;

    
    @NotNull(message = "*Campo Erro obrigatório.")
    @Column(name = "Erro")
    private String erro;

    public CoordenadasGeograficas() {
    }

    public CoordenadasGeograficas(Integer id) {
        this.id = id;
    }

    public CoordenadasGeograficas(Integer id, String tipoCoordenada, String latitude, String longitude, String erro) {
        this.id = id;
        this.tipoCoordenada = tipoCoordenada;
        this.latitude = latitude;
        this.longitude = longitude;
        this.erro = erro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoCoordenada() {
        return tipoCoordenada;
    }

    public void setTipoCoordenada(String tipoCoordenada) {
        this.tipoCoordenada = tipoCoordenada;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
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
        final CoordenadasGeograficas other = (CoordenadasGeograficas) obj;
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
