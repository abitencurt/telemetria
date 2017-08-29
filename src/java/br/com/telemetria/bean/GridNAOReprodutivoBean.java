package br.com.telemetria.bean;

import br.com.telemetria.dao.OcorrenciaNAOReprodutivaDAO;
import br.com.telemetria.entidade.ColetaAmostras;
import br.com.telemetria.entidade.ColetaTecidos;
import br.com.telemetria.entidade.CoordenadasGeograficas;
import br.com.telemetria.entidade.Ocorrencia;
import br.com.telemetria.entidade.OcorrenciaNaoReprodutiva;
import br.com.telemetria.entidade.Tartaruga;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class GridNAOReprodutivoBean implements Serializable {

    @Inject
    private OcorrenciaNaoReprodutiva naoReprodutiva;

    @Inject
    private Ocorrencia ocorrencia;

    @Inject
    private CoordenadasGeograficas geograficas;

    @Inject
    private Tartaruga tartaruga;

    @Inject
    private ColetaTecidos coletaTecidos;

    @Inject
    ColetaAmostras amostras;

    private List<OcorrenciaNaoReprodutiva> lista;

    @Inject
    private OcorrenciaNAOReprodutivaDAO dao;

    @PostConstruct
    public void init() {
        lista = dao.listar();
    }

    public String editar() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        if (naoReprodutiva != null) {
            System.out.println("EDITAR");
            flash.put("naoReprodutiva", naoReprodutiva);
            flash.put("ocorrencia", naoReprodutiva.getIdOcorrenciafk());
            flash.put("geograficas", naoReprodutiva.getIdOcorrenciafk().getIdCoordenadasGeograficasfk());
            flash.put("tartaruga", naoReprodutiva.getIdOcorrenciafk().getIdTartarugafk());
           
        }else{
            System.out.println("NOVO");
            flash.put("naoReprodutiva", new OcorrenciaNaoReprodutiva());
            flash.put("ocorrencia", ocorrencia);
            flash.put("geograficas", geograficas);
            flash.put("tartaruga", tartaruga);
            flash.put("coletaTecidos", coletaTecidos);
            flash.put("amostras", amostras);
        }

        return "ocorrenciaNAOReprodutiva?faces-redirect=true";

    }

    public OcorrenciaNaoReprodutiva getNaoReprodutiva() {
        return naoReprodutiva;
    }

    public void setNaoReprodutiva(OcorrenciaNaoReprodutiva naoReprodutiva) {
        this.naoReprodutiva = naoReprodutiva;
    }

    public List<OcorrenciaNaoReprodutiva> getLista() {
        return lista;
    }

    public void setLista(List<OcorrenciaNaoReprodutiva> lista) {
        this.lista = lista;
    }

}
