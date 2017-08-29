package br.com.telemetria.bean;

import br.com.telemetria.dao.TipoOcorrenciaReprodutivoDAO;
import br.com.telemetria.entidade.TipoOcorrenciaReprodutivo;
import br.com.telemetria.entidade.tx.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Messages;

@Named
@ViewScoped
public class TipoOcorrenciaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TipoOcorrenciaReprodutivo tipoOcorrenciaBean;
    private List<TipoOcorrenciaReprodutivo> lista;

    @Inject
    private TipoOcorrenciaReprodutivoDAO dao;

    public void novo() {
        tipoOcorrenciaBean = new TipoOcorrenciaReprodutivo();
    }

    @Transactional
    public void salvar() {
        dao.salvar(tipoOcorrenciaBean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        tipoOcorrenciaBean = (TipoOcorrenciaReprodutivo) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public TipoOcorrenciaReprodutivo getTipoOcorrenciaBean() {
        return tipoOcorrenciaBean;
    }

    public void setTipoOcorrenciaBean(TipoOcorrenciaReprodutivo tipoOcorrenciaBean) {
        this.tipoOcorrenciaBean = tipoOcorrenciaBean;
    }

    public List<TipoOcorrenciaReprodutivo> getLista() {
        if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<TipoOcorrenciaReprodutivo> lista) {
        this.lista = lista;
    }

}
