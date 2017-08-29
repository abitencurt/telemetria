
package br.com.telemetria.bean;

import br.com.telemetria.dao.LocalDAO;
import br.com.telemetria.entidade.Local;
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
public class LocalBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Local bean;
    private List<Local> lista;

    @Inject
    private LocalDAO dao;
    
    public void novo() {
        bean = new Local();
    }

    @Transactional
    public void salvar() {
        dao.salvar(bean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        bean = (Local) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public Local getBean() {
        return bean;
    }

    public void setBean(Local bean) {
        this.bean = bean;
    }

    public List<Local> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<Local> lista) {
        this.lista = lista;
    }
    
    
    
    
    

   
    
    
}
