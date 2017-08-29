
package br.com.telemetria.bean;

import br.com.telemetria.dao.InteracaoDAO;
import br.com.telemetria.entidade.Interacao;
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
public class InteracaoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Interacao bean;
    private List<Interacao> lista;

    @Inject
    private InteracaoDAO dao;
    
    public void novo() {
        bean = new Interacao();
    }

    @Transactional
    public void salvar() {
        dao.salvar(bean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        bean = (Interacao) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public Interacao getBean() {
        return bean;
    }

    public void setBean(Interacao bean) {
        this.bean = bean;
    }

    public List<Interacao> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<Interacao> lista) {
        this.lista = lista;
    }
    
    
    
    
    

   
    
    
}
