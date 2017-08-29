
package br.com.telemetria.bean;

import br.com.telemetria.dao.TumoresDAO;
import br.com.telemetria.entidade.Tumores;
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
public class TumoresBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Tumores tumor;
    private List<Tumores> lista;

    @Inject
    private TumoresDAO dao;
    
    public void novo() {
        tumor = new Tumores();
    }

    @Transactional
    public void salvar() {
        dao.salvar(tumor);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        tumor = (Tumores) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public Tumores getTumor() {
        return tumor;
    }

    public void setTumor(Tumores tumor) {
        this.tumor = tumor;
    }

    public List<Tumores> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<Tumores> lista) {
        this.lista = lista;
    }
    
    
    
    
    

   
    
    
}
