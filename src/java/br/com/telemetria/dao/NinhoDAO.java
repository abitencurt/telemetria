package br.com.telemetria.dao;

import br.com.telemetria.entidade.Ninho;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hibernate.Session;

public class NinhoDAO extends GenericDAO<Ninho> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager em;

    private Session session;

    public void excluir(Ninho entidade) {
        Ninho o = em.merge(entidade);
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
