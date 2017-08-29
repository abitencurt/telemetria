package br.com.telemetria.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class GenericDAO<Entidade> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager em;

    private Session session;

    private Class<Entidade> classe;

    public GenericDAO() {
        this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).
                getActualTypeArguments()[0];
    }
    
    public void gravar(Entidade obj) {
        em.persist(obj);
    }

    public void salvar(Entidade obj) {
        em.merge(obj);
    }
    
     public void editar(Entidade obj) {
        em.merge(obj);
    }

  

    public List<Entidade> listar() {
        session = (Session) getEm().getDelegate();
        Criteria consulta = session.createCriteria(classe);
        List<Entidade> resultado = consulta.list();
        return resultado;
    }
    
   

    public Entidade buscar(Integer id) {
        session = (Session) getEm().getDelegate();
        Criteria consulta = session.createCriteria(classe);
        consulta.add(Restrictions.idEq(id));
        Entidade resultado = (Entidade) consulta.uniqueResult();
        return resultado;
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
