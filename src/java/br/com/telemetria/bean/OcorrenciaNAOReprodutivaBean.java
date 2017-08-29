package br.com.telemetria.bean;

import br.com.telemetria.dao.ColetaAmostrasDAO;
import br.com.telemetria.dao.ColetaTecidosDAO;
import br.com.telemetria.dao.CoordenadasGeograficasDAO;
import br.com.telemetria.dao.OcorrenciaDAO;
import br.com.telemetria.dao.OcorrenciaNAOReprodutivaDAO;
import br.com.telemetria.dao.TartarugaDAO;
import br.com.telemetria.entidade.ColetaAmostras;
import br.com.telemetria.entidade.ColetaTecidos;
import br.com.telemetria.entidade.CoordenadasGeograficas;
import br.com.telemetria.entidade.Ocorrencia;
import br.com.telemetria.entidade.OcorrenciaNaoReprodutiva;
import br.com.telemetria.entidade.Tartaruga;
import br.com.telemetria.entidade.tx.Transactional;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Messages;

@Named
@ViewScoped
public class OcorrenciaNAOReprodutivaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private OcorrenciaNaoReprodutiva naoReprodutiva;

    @Inject
    private Ocorrencia ocorrencia;

    @Inject
    private CoordenadasGeograficas geograficas;

    @Inject
    private Tartaruga tartaruga;

    @Inject
    private OcorrenciaNAOReprodutivaDAO dao;

    @Inject
    private OcorrenciaDAO ocorrenciaDAO;

    @Inject
    private CoordenadasGeograficasDAO geograficasDAO;

    @Inject
    private TartarugaDAO tartarugaDAO;

   

    @Transactional
    public void salvar() throws IOException {
        if (naoReprodutiva.getId() == null) {

            geograficasDAO.gravar(geograficas);
            tartarugaDAO.gravar(tartaruga);

            ocorrencia.setIdCoordenadasGeograficasfk(geograficas);
            ocorrencia.setIdTartarugafk(tartaruga);
            ocorrenciaDAO.gravar(ocorrencia);

            naoReprodutiva.setIdOcorrenciafk(ocorrencia);
           

            dao.gravar(naoReprodutiva);

            Messages.addGlobalInfo("Registro salvo com sucesso.");
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().getExternalContext().redirect("gridNaoReprodutivo.xhtml");

        } else {

            geograficasDAO.salvar(geograficas);
            tartarugaDAO.salvar(tartaruga);
            ocorrenciaDAO.salvar(ocorrencia);
            dao.salvar(naoReprodutiva);

            Messages.addGlobalInfo("Registro alterado com sucesso.");
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().getExternalContext().redirect("gridNaoReprodutivo.xhtml");
        }

    }

    @Transactional
    public void update() {
        tartarugaDAO.salvar(tartaruga);
        geograficasDAO.salvar(geograficas);
        ocorrenciaDAO.salvar(ocorrencia);
        dao.salvar(naoReprodutiva);
    }

    @Transactional
    public void excluir() throws IOException {
        dao.excluir(naoReprodutiva);
        Messages.addGlobalInfo("Registro excluido com sucesso.");
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().getExternalContext().redirect("gridNaoReprodutivo.xhtml");
    }

    public String novo() {
        return "ocorrenciaNAOReprodutiva?faces-redirect=true";
    }

    @PostConstruct
    public void init() {
       
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        naoReprodutiva = (OcorrenciaNaoReprodutiva) flash.get("naoReprodutiva");
        ocorrencia = (Ocorrencia) flash.get("ocorrencia");
        geograficas = (CoordenadasGeograficas) flash.get("geograficas");
        tartaruga = (Tartaruga) flash.get("tartaruga");
    }

    public OcorrenciaNaoReprodutiva getNaoReprodutiva() {
        return naoReprodutiva;
    }

    public void setNaoReprodutiva(OcorrenciaNaoReprodutiva naoReprodutiva) {
        this.naoReprodutiva = naoReprodutiva;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public CoordenadasGeograficas getGeograficas() {
        return geograficas;
    }

    public void setGeograficas(CoordenadasGeograficas geograficas) {
        this.geograficas = geograficas;
    }

    public Tartaruga getTartaruga() {
        return tartaruga;
    }

    public void setTartaruga(Tartaruga tartaruga) {
        this.tartaruga = tartaruga;
    }


}
