
package br.com.telemetria.bean;

import br.com.telemetria.dao.IdadeDAO;
import br.com.telemetria.entidade.Idade;
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
public class IdadeBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Idade idade;
    private List<Idade> lista;
    
    @Inject
    private IdadeDAO dao;
    
    public void novo() {
        idade = new Idade();
    }

    @Transactional
    public void salvar() {
        dao.salvar(idade);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        idade = (Idade) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public Idade getIdade() {
        return idade;
    }

    public void setIdade(Idade idade) {
        this.idade = idade;
    }

    public List<Idade> getLista() {
         if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<Idade> lista) {
        this.lista = lista;
    }
    
    
    
}
