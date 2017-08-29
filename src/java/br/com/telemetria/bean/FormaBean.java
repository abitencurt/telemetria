
package br.com.telemetria.bean;

import br.com.telemetria.dao.FormaDAO;
import br.com.telemetria.entidade.Forma;
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
public class FormaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Forma bean;
    private List<Forma> lista;

    @Inject
    private FormaDAO dao;
    
    public void novo() {
        bean = new Forma();
    }

    @Transactional
    public void salvar() {
        dao.salvar(bean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        bean = (Forma) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public Forma getBean() {
        return bean;
    }

    public void setBean(Forma bean) {
        this.bean = bean;
    }

    public List<Forma> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<Forma> lista) {
        this.lista = lista;
    }
    
    
    
    
    

   
    
    
}
