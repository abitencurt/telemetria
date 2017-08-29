
package br.com.telemetria.bean;

import br.com.telemetria.dao.DestinoDAO;
import br.com.telemetria.entidade.Destino;
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
public class DestinoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Destino bean;
    private List<Destino> lista;

    @Inject
    private DestinoDAO dao;
    
    public void novo() {
        bean = new Destino();
    }

    @Transactional
    public void salvar() {
        dao.salvar(bean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        bean = (Destino) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public Destino getBean() {
        return bean;
    }

    public void setBean(Destino bean) {
        this.bean = bean;
    }

    public List<Destino> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<Destino> lista) {
        this.lista = lista;
    }
    
    
    
    
    

   
    
    
}
