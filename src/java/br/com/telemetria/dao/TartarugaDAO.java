package br.com.telemetria.dao;

import br.com.telemetria.entidade.Tartaruga;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hibernate.Session;

public class TartarugaDAO extends GenericDAO<Tartaruga> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager em;

    private Session session;

    public void excluir(Tartaruga entidade) {
        Tartaruga o = em.merge(entidade);
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
