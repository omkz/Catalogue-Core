package org.omenk.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;


import org.omenk.dao.PengarangDAO;


import org.omenk.model.Pengarang;

@Repository
@Transactional
public class PengarangDAOImpl implements PengarangDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    public Long count() {
        return (Long) this.entityManager.createQuery("SELECT count(a) FROM Pengarang a").getSingleResult();
    }

    @Override
    public List<Pengarang> findAll() {
        return this.entityManager.createQuery("SELECT o FROM Pengarang o ORDER BY o.nama").getResultList();
    }

    @Override
    public  Pengarang findByNiy(String niy) {
        return (Pengarang) this.entityManager.createQuery("SELECT o FROM Pengarang o WHERE o.niy=:niy").setParameter("niy", niy).getSingleResult();
    }

    @Override
    public List<Pengarang> findEntries(int firstResult, int maxResults) {
        return this.entityManager.createQuery("SELECT o FROM Pengarang o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public Pengarang find(Long id) {
        return entityManager.find(Pengarang.class, id);
    }

    @Override
    public void persist(Pengarang o) {
        this.entityManager.persist(o);
    }

    @Override
    public void merge(Pengarang o) {
        this.entityManager.merge(o);
    }

    @Override
    public void remove(Pengarang o) {
        this.entityManager.remove(this.entityManager.merge(o));
    }
}
