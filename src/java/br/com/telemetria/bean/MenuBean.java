package br.com.telemetria.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MenuBean {

    private String pagina;

    public String login() {
        return pagina = "ocorrenciaReprodutiva?faces-redirect=true";
    }

    public String consuta() {
        return pagina = "concultarOcorrenciaReprodutiva?faces-redirect=true";
    }

    public String consutaMarca() {
        return pagina = "concultarPorMarca?faces-redirect=true";
    }

    public String tipoOcorrencia() {
        return pagina = "tipoOcorrenciaReprodutivo?faces-redirect=true";
    }

    public String tipoEspecie() {
        return pagina = "tipoEspecie?faces-redirect=true";
    }

    public String praia() {
        return pagina = "praias?faces-redirect=true";
    }

    public String idade() {
        return pagina = "idade?faces-redirect=true";
    }

    public String situacaoOcorrencia() {
        return pagina = "situacaoOcorrenciaReprodutivo?faces-redirect=true";
    }

    public String tumores() {
        return pagina = "tumores?faces-redirect=true";
    }

    public String subBase() {
        return pagina = "subBase?faces-redirect=true";
    }

    public String causaPrimaria() {
        return pagina = "causaPrimaria?faces-redirect=true";
    }

    public String causaSecundaria() {
        return pagina = "causaSecundaria?faces-redirect=true";
    }

    public String condicaoCorporal() {
        return pagina = "condicaoCorporal?faces-redirect=true";
    }

    public String condicaoNecropsia() {
        return pagina = "condicaoNecropsia?faces-redirect=true";
    }

    public String destino() {
        return pagina = "destino?faces-redirect=true";
    }

    public String origem() {
        return pagina = "origem?faces-redirect=true";
    }

    public String estagioDecomposicao() {
        return pagina = "estagioDecomposicao?faces-redirect=true";
    }

    public String interacao() {
        return pagina = "interacao?faces-redirect=true";
    }

    public String local() {
        return pagina = "local?faces-redirect=true";
    }

    public String tempTrans() {
        return pagina = "tempoTransf?faces-redirect=true";
    }

    public String tipoOcorrenciaNaoReprodutivo() {
        return pagina = "tipoOcorrenciaNaoReprodutivo?faces-redirect=true";
    }

    public String evidenciaPesca() {
        return pagina = "evidenciaPesca?faces-redirect=true";
    }

    public String forma() {
        return pagina = "forma?faces-redirect=true";
    }

    public String historicoNinho() {
        return pagina = "historicoNinho?faces-redirect=true";
    }

    public String naoReprodutivo() {
        return pagina = "gridNaoReprodutivo?faces-redirect=true";
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

}
