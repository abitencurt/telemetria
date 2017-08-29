
package br.com.telemetria.bean;

import br.com.telemetria.dao.EstagioDecomposicaoDAO;
import br.com.telemetria.entidade.EstagioDecomposicao;
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
public class EstagioDecomposicaoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private EstagioDecomposicao bean;
    private List<EstagioDecomposicao> lista;

    @Inject
    private EstagioDecomposicaoDAO dao;
    
    public void novo() {
        bean = new EstagioDecomposicao();
    }

    @Transactional
    public void salvar() {
        dao.salvar(bean);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        bean = (EstagioDecomposicao) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public EstagioDecomposicao getBean() {
        return bean;
    }

    public void setBean(EstagioDecomposicao bean) {
        this.bean = bean;
    }

    public List<EstagioDecomposicao> getLista() {
       if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<EstagioDecomposicao> lista) {
        this.lista = lista;
    }
    
    
    
    
    

   
    
    
}
