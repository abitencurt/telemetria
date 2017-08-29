
package br.com.telemetria.bean;


import br.com.telemetria.dao.TipoRegistroNaoReprodutivoDAO;
import br.com.telemetria.entidade.TipoRegistroNaoReprodutivo;
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
public class TipoRegNaoReprodutivoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private TipoRegistroNaoReprodutivo bean;
    private List<TipoRegistroNaoReprodutivo> lista;

    @Inject
    private TipoRegistroNaoReprodutivoDAO dao;
    
    public void novo() {
        bean = new TipoRegistroNaoReprodutivo();
    }

    @Transactional
    public void salvar() {
        dao.salvar(bean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        bean = (TipoRegistroNaoReprodutivo) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public TipoRegistroNaoReprodutivo getBean() {
        return bean;
    }

    public void setBean(TipoRegistroNaoReprodutivo bean) {
        this.bean = bean;
    }

    public List<TipoRegistroNaoReprodutivo> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<TipoRegistroNaoReprodutivo> lista) {
        this.lista = lista;
    }
    
    
    
    
    

   
    
    
}
