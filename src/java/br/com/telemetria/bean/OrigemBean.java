
package br.com.telemetria.bean;

import br.com.telemetria.dao.CausaPrimariaDAO;
import br.com.telemetria.dao.OrigemDAO;
import br.com.telemetria.entidade.CausaPrimaria;
import br.com.telemetria.entidade.Origem;
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
public class OrigemBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Origem bean;
    private List<Origem> lista;

    @Inject
    private OrigemDAO dao;
    
    public void novo() {
        bean = new Origem();
    }

    @Transactional
    public void salvar() {
        dao.salvar(bean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        bean = (Origem) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public Origem getBean() {
        return bean;
    }

    public void setBean(Origem bean) {
        this.bean = bean;
    }

    public List<Origem> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<Origem> lista) {
        this.lista = lista;
    }
    
    
    
    
    

   
    
    
}
