package br.com.telemetria.dao;

import br.com.telemetria.entidade.OcorrenciaNaoReprodutiva;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class OcorrenciaNAOReprodutivaDAO extends GenericDAO<OcorrenciaNaoReprodutiva> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager em;

    public void excluir(OcorrenciaNaoReprodutiva entidade) {
        OcorrenciaNaoReprodutiva o = em.merge(entidade);
        em.remove(o);
    }

    public EntityManager getEm() {
        return em;
    }

}
