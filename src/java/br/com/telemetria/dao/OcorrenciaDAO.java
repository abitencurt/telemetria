package br.com.telemetria.dao;

import br.com.telemetria.entidade.Ocorrencia;
import br.com.telemetria.entidade.Tartaruga;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

public class OcorrenciaDAO extends GenericDAO<Ocorrencia> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager em;

    private Session session;

    public List<Ocorrencia> consultar(Ocorrencia objeto) {
        session = (Session) getEm().getDelegate();
        Criteria consulta = session.createCriteria(Ocorrencia.class);
        consulta.add(Restrictions.between("dataOcorrencia", objeto.getDataOcorrencia(), objeto.getTermino()));
        return consulta.list();
    }

    public Ocorrencia consultarPorMarca(Tartaruga objeto) {

        session = (Session) getEm().getDelegate();
        Criteria consulta = session.createCriteria(Ocorrencia.class);
        consulta.createAlias("idTartarugafk", "tart");
        consulta.add(Restrictions.eq("tart.numMarcaEncontrada", objeto.getNumMarcaAplicada()));
        Ocorrencia o = (Ocorrencia) consulta.uniqueResult();
        return o;
    }

    public void excluir(Ocorrencia entidade) {
        Ocorrencia o = em.merge(entidade);
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
