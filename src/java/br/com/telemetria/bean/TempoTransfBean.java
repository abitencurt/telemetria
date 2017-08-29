
package br.com.telemetria.bean;

import br.com.telemetria.dao.TempoTransferenciaDAO;
import br.com.telemetria.entidade.TempoTransferencia;
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
public class TempoTransfBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TempoTransferencia tempoTransferencia;
    private List<TempoTransferencia> lista;

    @Inject
    private TempoTransferenciaDAO dao;
    
    public void novo() {
        tempoTransferencia = new TempoTransferencia();
    }

    @Transactional
    public void salvar() {
        dao.salvar(tempoTransferencia);
        lista = dao.listar();
        Messages.addGlobalInfo("Registro salvo com sucesso");
    }

    public void editar(ActionEvent evento) {
        tempoTransferencia = (TempoTransferencia) evento.getComponent().getAttributes().get("registroSelecionado");
    }

    public TempoTransferencia getTempoTransferencia() {
        return tempoTransferencia;
    }

    public void setTempoTransferencia(TempoTransferencia tempoTransferencia) {
        this.tempoTransferencia = tempoTransferencia;
    }

    public List<TempoTransferencia> getLista() {
         if (lista == null) {
            lista = dao.listar();
        }
        return lista;
    }

    public void setLista(List<TempoTransferencia> lista) {
        this.lista = lista;
    }

}
