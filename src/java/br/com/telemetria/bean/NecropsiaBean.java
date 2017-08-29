package br.com.telemetria.bean;

import br.com.telemetria.entidade.ColetaAmostras;
import br.com.telemetria.entidade.ColetaTecidos;
import br.com.telemetria.entidade.Necropsia;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class NecropsiaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Necropsia necropsia;

    @Inject
    private ColetaTecidos coletaTecidos;

    @Inject
    private ColetaAmostras coletaAmostras;

    public Necropsia getNecropsia() {
        return necropsia;
    }

    public void setNecrosia(Necropsia necropsia) {
        this.necropsia = necropsia;
    }

    public ColetaTecidos getColetaTecidos() {
        return coletaTecidos;
    }

    public void setColetaTecidos(ColetaTecidos coletaTecidos) {
        this.coletaTecidos = coletaTecidos;
    }

    public ColetaAmostras getColetaAmostras() {
        return coletaAmostras;
    }

    public void setColetaAmostras(ColetaAmostras coletaAmostras) {
        this.coletaAmostras = coletaAmostras;
    }

}
