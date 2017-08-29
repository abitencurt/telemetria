
package br.com.telemetria.bean;

import br.com.telemetria.dao.CondicaoCorporalDAO;
import br.com.telemetria.entidade.CondicaoCorporal;
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
public class CondicaoCorporalBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private CondicaoCorporal bean;
    private List<CondicaoCorporal> lista;

    @Inject
    private CondicaoCorporalDAO dao;
    
    public void novo() {
        bean = new CondicaoCorporal();
    }

    @Transactional
    public void salvar() {
        dao.salvar(bean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        bean = (CondicaoCorporal) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public CondicaoCorporal getBean() {
        return bean;
    }

    public void setBean(CondicaoCorporal bean) {
        this.bean = bean;
    }

    public List<CondicaoCorporal> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<CondicaoCorporal> lista) {
        this.lista = lista;
    }
    
    
    
    
    

   
    
    
}
