package org.omenk.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

import org.omenk.dao.PenerbitDAO;

import org.omenk.model.Penerbit;

@Repository
@Transactional
public class PenerbitDAOImpl implements PenerbitDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    public Long count() {
        return (Long) this.entityManager.createQuery("SELECT count(a) FROM Penerbit a").getSingleResult();
    }

    @Override
    public List<Penerbit> findAll() {
        return this.entityManager.createQuery("SELECT o FROM Penerbit o ORDER BY o.nama").getResultList();
    }

    @Override
    public  Penerbit findByNiy(String niy) {
        return (Penerbit) this.entityManager.createQuery("SELECT o FROM Penerbit o WHERE o.niy=:niy").setParameter("niy", niy).getSingleResult();
    }

    @Override
    public List<Penerbit> findEntries(int firstResult, int maxResults) {
        return this.entityManager.createQuery("SELECT o FROM Penerbit o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public Penerbit find(Long id) {
        return entityManager.find(Penerbit.class, id);
    }

    @Override
    public void persist(Penerbit o) {
        this.entityManager.persist(o);
    }

    @Override
    public void merge(Penerbit o) {
        this.entityManager.merge(o);
    }

    @Override
    public void remove(Penerbit o) {
        this.entityManager.remove(this.entityManager.merge(o));
    }
}
