
package br.com.telemetria.bean;

import br.com.telemetria.dao.EvidenciaPescaDAO;
import br.com.telemetria.entidade.EvidenciaPesca;
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
public class EvidenciaPescaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private EvidenciaPesca bean;
    private List<EvidenciaPesca> lista;

    @Inject
    private EvidenciaPescaDAO dao;
    
    public void novo() {
        bean = new EvidenciaPesca();
    }

    @Transactional
    public void salvar() {
        dao.salvar(bean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        bean = (EvidenciaPesca) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public EvidenciaPesca getBean() {
        return bean;
    }

    public void setBean(EvidenciaPesca bean) {
        this.bean = bean;
    }

    public List<EvidenciaPesca> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<EvidenciaPesca> lista) {
        this.lista = lista;
    }
    
    
    
    
    

   
    
    
}
