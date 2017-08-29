package br.com.telemetria.bean;

import br.com.telemetria.dao.EspecieTartarugaDAO;
import br.com.telemetria.entidade.EspecieTartaruga;
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
public class EspecieTartarugaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private EspecieTartaruga especieTartaruga;
    private List<EspecieTartaruga> lista;

    @Inject
    private EspecieTartarugaDAO dao;
    
     public void novo() {
        especieTartaruga = new EspecieTartaruga();
    }

    @Transactional
    public void salvar() {
        dao.salvar(especieTartaruga);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        especieTartaruga = (EspecieTartaruga) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public EspecieTartaruga getEspecieTartaruga() {
        return especieTartaruga;
    }

    public void setEspecieTartaruga(EspecieTartaruga especieTartaruga) {
        this.especieTartaruga = especieTartaruga;
    }
    

   

    public List<EspecieTartaruga> getLista() {
           if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

}
