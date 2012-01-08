package org.omenk.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;
import org.omenk.dao.KategoriDAO;
import org.omenk.model.Kategori;


@Repository
@Transactional
public class KategoriDAOImpl implements KategoriDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    public Long count() {
        return (Long) this.entityManager.createQuery("SELECT count(a) FROM Kategori a").getSingleResult();
    }

    @Override
    public List<Kategori> findAll() {
        return this.entityManager.createQuery("SELECT o FROM Kategori o").getResultList();
    }

    @Override
    public Kategori findByNiy(String niy) {
        return (Kategori) this.entityManager.createQuery("SELECT o FROM Kategori o WHERE o.niy=:niy").setParameter("niy", niy).getSingleResult();
    }

    @Override
    public List<Kategori> findEntries(int firstResult, int maxResults) {
        return this.entityManager.createQuery("SELECT o FROM Kategori o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public Kategori find(Long id) {
        return entityManager.find(Kategori.class, id);
    }

    @Override
    public void persist(Kategori o) {
        this.entityManager.persist(o);
    }

    @Override
    public void merge(Kategori o) {
        this.entityManager.merge(o);
    }

    @Override
    public void remove(Kategori o) {
        this.entityManager.remove(this.entityManager.merge(o));
    }

}
