
package br.com.telemetria.bean;

import br.com.telemetria.dao.SubBaseDAO;
import br.com.telemetria.entidade.SubBase;
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
public class SubBaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SubBase base;
    private List<SubBase> lista;

    @Inject
    private SubBaseDAO dao;
    
    public void novo() {
        base = new SubBase();
    }

    @Transactional
    public void salvar() {
        dao.salvar(base);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        base = (SubBase) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public SubBase getSubBase() {
        return base;
    }

    public void setSubBase(SubBase base) {
        this.base = base;
    }

    public List<SubBase> getLista() {
         if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<SubBase> lista) {
        this.lista = lista;
    }
    
    

}
