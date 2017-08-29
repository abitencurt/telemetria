
package br.com.telemetria.bean;

import br.com.telemetria.dao.CausaPrimariaDAO;
import br.com.telemetria.entidade.CausaPrimaria;
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
public class CausaPrimariaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private CausaPrimaria bean;
    private List<CausaPrimaria> lista;

    @Inject
    private CausaPrimariaDAO dao;
    
    public void novo() {
        bean = new CausaPrimaria();
    }

    @Transactional
    public void salvar() {
        dao.salvar(bean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        bean = (CausaPrimaria) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public CausaPrimaria getBean() {
        return bean;
    }

    public void setBean(CausaPrimaria bean) {
        this.bean = bean;
    }

    public List<CausaPrimaria> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<CausaPrimaria> lista) {
        this.lista = lista;
    }
    
    
    
    
    

   
    
    
}
