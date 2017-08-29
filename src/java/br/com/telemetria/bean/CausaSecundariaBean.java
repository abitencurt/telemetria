
package br.com.telemetria.bean;

import br.com.telemetria.dao.CausaSecundariaDAO;
import br.com.telemetria.entidade.CausaSecundaria;
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
public class CausaSecundariaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private CausaSecundaria bean;
    private List<CausaSecundaria> lista;

    @Inject
    private CausaSecundariaDAO dao;
    
    public void novo() {
        bean = new CausaSecundaria();
    }

    @Transactional
    public void salvar() {
        dao.salvar(bean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        bean = (CausaSecundaria) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public CausaSecundaria getBean() {
        return bean;
    }

    public void setBean(CausaSecundaria bean) {
        this.bean = bean;
    }

    public List<CausaSecundaria> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<CausaSecundaria> lista) {
        this.lista = lista;
    }
    
    
    
    
    

   
    
    
}
