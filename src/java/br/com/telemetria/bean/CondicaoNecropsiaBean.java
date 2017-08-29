
package br.com.telemetria.bean;

import br.com.telemetria.dao.CondicaoNecropsiaDAO;
import br.com.telemetria.entidade.CondicaoNecropsia;
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
public class CondicaoNecropsiaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private CondicaoNecropsia bean;
    private List<CondicaoNecropsia> lista;

    @Inject
    private CondicaoNecropsiaDAO dao;
    
    public void novo() {
        bean = new CondicaoNecropsia();
    }

    @Transactional
    public void salvar() {
        dao.salvar(bean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        bean = (CondicaoNecropsia) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public CondicaoNecropsia getBean() {
        return bean;
    }

    public void setBean(CondicaoNecropsia bean) {
        this.bean = bean;
    }

    public List<CondicaoNecropsia> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<CondicaoNecropsia> lista) {
        this.lista = lista;
    }
    
  
    
}
