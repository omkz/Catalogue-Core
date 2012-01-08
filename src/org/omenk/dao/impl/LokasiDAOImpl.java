package org.omenk.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;
import org.omenk.dao.LokasiDAO;
import org.omenk.model.Lokasi;

@Repository
@Transactional
public class LokasiDAOImpl implements LokasiDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    public Long count() {
        return (Long) this.entityManager.createQuery("SELECT count(a) FROM Lokasi a").getSingleResult();
    }

    @Override
    public List< Lokasi> findAll() {
        return this.entityManager.createQuery("SELECT o FROM Lokasi o").getResultList();
    }

    @Override
    public  Lokasi findByNiy(String niy) {
        return (Lokasi) this.entityManager.createQuery("SELECT o FROM Lokasi o WHERE o.niy=:niy").setParameter("niy", niy).getSingleResult();
    }

    @Override
    public List<Lokasi> findEntries(int firstResult, int maxResults) {
        return this.entityManager.createQuery("SELECT o FROM Lokasi o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public Lokasi find(Long id) {
        return entityManager.find(Lokasi.class, id);
    }

    @Override
    public void persist(Lokasi o) {
        this.entityManager.persist(o);
    }

    @Override
    public void merge(Lokasi o) {
        this.entityManager.merge(o);
    }

    @Override
    public void remove(Lokasi o) {
        this.entityManager.remove(this.entityManager.merge(o));
    }
}
