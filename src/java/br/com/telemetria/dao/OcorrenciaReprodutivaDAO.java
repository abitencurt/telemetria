package br.com.telemetria.dao;

import br.com.telemetria.entidade.OcorrenciaReprodutiva;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.sql.JoinType;

public class OcorrenciaReprodutivaDAO extends GenericDAO<OcorrenciaReprodutiva> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager em;

    private Session session;

    public List<OcorrenciaReprodutiva> listarOcorrencia() {
        session = (Session) getEm().getDelegate();

        Criteria consulta = session.createCriteria(OcorrenciaReprodutiva.class);
        consulta.createCriteria("idNinhofk", JoinType.LEFT_OUTER_JOIN);
        consulta.createCriteria("idTransferenciaNinhofk", JoinType.LEFT_OUTER_JOIN);
        consulta.createCriteria("idSituacaoOcorrenciaReprodutivofk", JoinType.LEFT_OUTER_JOIN);
        List<OcorrenciaReprodutiva> resultado = consulta.list();
        return resultado;

    }
    
      public void excluir(OcorrenciaReprodutiva entidade) {
      OcorrenciaReprodutiva o =  em.merge(entidade);
        em.remove(o);
    }

    public EntityManager getEm() {
        return em;
    }

    public Session getSession() {
        if (em != null) {
            session = (Session) getEm().getDelegate();
        }
        return session;
    }

}
