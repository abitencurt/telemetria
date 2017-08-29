
package br.com.telemetria.bean;

import br.com.telemetria.dao.SituacaoOcorrenciaReprodutivoDAO;
import br.com.telemetria.entidade.SituacaoOcorrenciaReprodutivo;
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
public class SituacaoOcorrenciaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private SituacaoOcorrenciaReprodutivo situacaoOcorrenciaReprodutivo;
    private List<SituacaoOcorrenciaReprodutivo> lista;

    @Inject
    private SituacaoOcorrenciaReprodutivoDAO dao;
    
    public void novo() {
        situacaoOcorrenciaReprodutivo = new SituacaoOcorrenciaReprodutivo();
    }

    @Transactional
    public void salvar() {
        dao.salvar(situacaoOcorrenciaReprodutivo);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        situacaoOcorrenciaReprodutivo = (SituacaoOcorrenciaReprodutivo) evento.getComponent().getAttributes().get("registroSelecionado");
    }
    

    public SituacaoOcorrenciaReprodutivo getSituacaoOcorrenciaReprodutivo() {
        return situacaoOcorrenciaReprodutivo;
    }

    public void setSituacaoOcorrenciaReprodutivo(SituacaoOcorrenciaReprodutivo situacaoOcorrenciaReprodutivo) {
        this.situacaoOcorrenciaReprodutivo = situacaoOcorrenciaReprodutivo;
    }

    public List<SituacaoOcorrenciaReprodutivo> getLista() {
         if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<SituacaoOcorrenciaReprodutivo> lista) {
        this.lista = lista;
    }
    
    
    
}
