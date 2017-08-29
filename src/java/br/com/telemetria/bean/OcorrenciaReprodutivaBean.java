package br.com.telemetria.bean;

import br.com.telemetria.dao.CoordenadasGeograficasDAO;
import br.com.telemetria.dao.NinhoDAO;
import br.com.telemetria.dao.OcorrenciaDAO;
import br.com.telemetria.dao.OcorrenciaReprodutivaDAO;
import br.com.telemetria.dao.TartarugaDAO;
import br.com.telemetria.dao.TransferenciaNinhoDAO;
import br.com.telemetria.entidade.CoordenadasGeograficas;
import br.com.telemetria.entidade.Ninho;
import br.com.telemetria.entidade.Ocorrencia;
import br.com.telemetria.entidade.OcorrenciaReprodutiva;
import br.com.telemetria.entidade.Tartaruga;
import br.com.telemetria.entidade.TransferenciaNinho;
import br.com.telemetria.entidade.tx.Transactional;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Messages;

@Named
@ViewScoped
public class OcorrenciaReprodutivaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private OcorrenciaReprodutiva ocorrenciaReprodutiva;

    @Inject
    private Ocorrencia ocorrencia;

    @Inject
    private CoordenadasGeograficas coordenadasGeografica;

    @Inject
    private CoordenadasGeograficas coordenadasGeograficaTransf;

    @Inject
    private Tartaruga tartaruga;

    @Inject
    private Ninho ninho;

    @Inject
    private TransferenciaNinho transferenciaNinho;

    @Inject
    private TransferenciaNinhoDAO transferenciaNinhoDAO;

    @Inject
    private TartarugaDAO tartarugaDAO;

    @Inject
    private NinhoDAO ninhoDAO;

    @Inject
    private OcorrenciaDAO ocorrenciaDAO;

    @Inject
    private OcorrenciaReprodutivaDAO ocorrenciaReprodutivaDAO;

    @Inject
    private CoordenadasGeograficasDAO coordenadasGeograficasDAO;

    private List<OcorrenciaReprodutiva> lista;

    private List<Ocorrencia> resultado;

    private boolean habilitarTabNinho = false;

    @Transactional
    public void update() throws IOException {
        tartarugaDAO.salvar(tartaruga);
        coordenadasGeograficasDAO.salvar(coordenadasGeografica);
        ocorrenciaDAO.salvar(ocorrencia);
        if (ocorrenciaReprodutiva.getIdTipoOcorrenciaReprodutivofk().isIsNinho() == true) {
            ninhoDAO.salvar(ninho);
            if (ocorrenciaReprodutiva.getIdSituacaoOcorrenciaReprodutivofk().isIsTransfer() == true) {
                coordenadasGeograficasDAO.salvar(coordenadasGeograficaTransf);
                transferenciaNinhoDAO.salvar(transferenciaNinho);
            }
        }
        ocorrenciaReprodutivaDAO.salvar(ocorrenciaReprodutiva);
        this.novo();

        FacesContext.getCurrentInstance().getExternalContext().redirect("ocorrenciaReprodutiva.xhtml");
        Messages.addGlobalInfo("Registro alterado com sucesso.");
    }

    @Transactional
    public void salvar() throws IOException {
        tartarugaDAO.gravar(tartaruga);
        ocorrencia.setIdTartarugafk(tartaruga);

        coordenadasGeograficasDAO.gravar(coordenadasGeografica);
        ocorrencia.setIdCoordenadasGeograficasfk(coordenadasGeografica);
        ocorrenciaDAO.gravar(ocorrencia);

        if (ocorrenciaReprodutiva.getIdTipoOcorrenciaReprodutivofk().isIsNinho() == true) {
            ninhoDAO.gravar(ninho);
            ocorrenciaReprodutiva.setIdNinhofk(ninho);

            if (ocorrenciaReprodutiva.getIdSituacaoOcorrenciaReprodutivofk().isIsTransfer() == true) {
                coordenadasGeograficasDAO.gravar(coordenadasGeograficaTransf);
                transferenciaNinho.setIdCoordenadasGeograficasfk(coordenadasGeograficaTransf);
                transferenciaNinhoDAO.gravar(transferenciaNinho);
                ocorrenciaReprodutiva.setIdTransferenciaNinhofk(transferenciaNinho);
            }

        }

        ocorrenciaReprodutiva.setIdOcorrenciafk(ocorrencia);
        ocorrenciaReprodutivaDAO.gravar(ocorrenciaReprodutiva);

        this.novo();

        lista = ocorrenciaReprodutivaDAO.listarOcorrencia();

        FacesContext.getCurrentInstance().getExternalContext().redirect("ocorrenciaReprodutiva.xhtml");
        Messages.addGlobalInfo("Registro salvo com sucesso.");

    }

    @Transactional
    public void excluir() throws IOException {
        ocorrenciaReprodutivaDAO.excluir(ocorrenciaReprodutiva);
        lista = ocorrenciaReprodutivaDAO.listarOcorrencia();
        Messages.addGlobalInfo("Registro excluido com sucesso.");
    }

    public void novo() {

        tartaruga = new Tartaruga();
        coordenadasGeografica = new CoordenadasGeograficas();
        transferenciaNinho = new TransferenciaNinho();
        ninho = new Ninho();
        ocorrencia = new Ocorrencia();
        ocorrenciaReprodutiva = new OcorrenciaReprodutiva();
        coordenadasGeograficaTransf = new CoordenadasGeograficas();

    }

    public List<Ocorrencia> consutar() {
        resultado = ocorrenciaDAO.consultar(ocorrencia);
        if (resultado.isEmpty()) {
            Messages.addGlobalError("Sua consulta não encontrou dados para exibir.Por favor revise os parâmetros informados e tente outra vez.");
        }
        return resultado;
    }

    public Ocorrencia consutarPorMarca() {
        ocorrencia = ocorrenciaDAO.consultarPorMarca(tartaruga);
        return ocorrencia;
    }

    public boolean tabNinho() {

        habilitarTabNinho = ocorrenciaReprodutiva.getIdTipoOcorrenciaReprodutivofk().isIsNinho();

        System.out.println("" + habilitarTabNinho);
        return habilitarTabNinho;
    }

    public OcorrenciaReprodutiva getOcorrenciaReprodutiva() {
        return ocorrenciaReprodutiva;
    }

    public void setOcorrenciaReprodutiva(OcorrenciaReprodutiva ocorrenciaReprodutiva) {
        this.ocorrenciaReprodutiva = ocorrenciaReprodutiva;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public CoordenadasGeograficas getCoordenadasGeografica() {
        return coordenadasGeografica;
    }

    public void setCoordenadasGeografica(CoordenadasGeograficas coordenadasGeografica) {
        this.coordenadasGeografica = coordenadasGeografica;
    }

    public Tartaruga getTartaruga() {
        return tartaruga;
    }

    public void setTartaruga(Tartaruga tartaruga) {
        this.tartaruga = tartaruga;
    }

    public Ninho getNinho() {
        return ninho;
    }

    public void setNinho(Ninho ninho) {
        this.ninho = ninho;
    }

    public TransferenciaNinho getTransferenciaNinho() {
        return transferenciaNinho;
    }

    public void setTransferenciaNinho(TransferenciaNinho transferenciaNinho) {
        this.transferenciaNinho = transferenciaNinho;
    }

    public CoordenadasGeograficas getCoordenadasGeograficaTransf() {
        return coordenadasGeograficaTransf;
    }

    public void setCoordenadasGeograficaTransf(CoordenadasGeograficas coordenadasGeograficaTransf) {
        this.coordenadasGeograficaTransf = coordenadasGeograficaTransf;
    }

    public List<OcorrenciaReprodutiva> getLista() {
        if (lista == null) {
            lista = ocorrenciaReprodutivaDAO.listarOcorrencia();
        }
        return lista;
    }

    public void setLista(List<OcorrenciaReprodutiva> lista) {
        this.lista = lista;
    }

    public List<Ocorrencia> getResultado() {
        return resultado;
    }

    public void setResultado(List<Ocorrencia> resultado) {
        this.resultado = resultado;
    }

    public boolean isHabilitarTabNinho() {
        return habilitarTabNinho;
    }

    public void setHabilitarTabNinho(boolean habilitarTabNinho) {
        this.habilitarTabNinho = habilitarTabNinho;
    }

}
