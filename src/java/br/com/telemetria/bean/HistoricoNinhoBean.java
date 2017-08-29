
package br.com.telemetria.bean;

import br.com.telemetria.dao.HistoricoNinhoDAO;
import br.com.telemetria.entidade.HistoricoNinho;
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
public class HistoricoNinhoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private HistoricoNinho bean;
    private List<HistoricoNinho> lista;

    @Inject
    private HistoricoNinhoDAO dao;
    
    public void novo() {
        bean = new HistoricoNinho();
    }

    @Transactional
    public void salvar() {
        dao.salvar(bean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        bean = (HistoricoNinho) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public HistoricoNinho getBean() {
        return bean;
    }

    public void setBean(HistoricoNinho bean) {
        this.bean = bean;
    }

    public List<HistoricoNinho> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<HistoricoNinho> lista) {
        this.lista = lista;
    }
    
    
    
    
    

   
    
    
}
