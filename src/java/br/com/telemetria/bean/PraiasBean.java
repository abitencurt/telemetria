
package br.com.telemetria.bean;

import br.com.telemetria.dao.PraiasDAO;
import br.com.telemetria.entidade.Municipios;
import br.com.telemetria.entidade.Praias;
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
public class PraiasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Praias praias;
    private List<Praias> lista;

    @Inject
    private PraiasDAO dao;
    
    public void novo() {
        praias = new Praias();
    }

    @Transactional
    public void salvar() {
        Municipios idMunicipios = new Municipios();
        idMunicipios.setId(1);
        praias.setIdMunicipiofk(idMunicipios);
        dao.salvar(praias);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        praias = (Praias) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public Praias getPraias() {
        return praias;
    }

    public void setPraias(Praias praias) {
        this.praias = praias;
    }

    public List<Praias> getLista() {
         if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<Praias> lista) {
        this.lista = lista;
    }
    
    

}
