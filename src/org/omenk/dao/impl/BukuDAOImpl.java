package org.omenk.dao.impl;

import org.omenk.services.SearchCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;
import org.omenk.dao.BukuDAO;
import org.omenk.model.Buku;
import org.springframework.util.StringUtils;

@Repository
@Transactional
public class BukuDAOImpl implements BukuDAO {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public Long count() {
        return (Long) this.entityManager.createQuery("SELECT count(a) FROM Buku a").getSingleResult();
    }

    @Override
    public List<Buku> findAll() {
        return this.entityManager.createQuery("SELECT o FROM Buku o").getResultList();
    }

    @Override
    public Buku findByNiy(String niy) {
        return (Buku) this.entityManager.createQuery("SELECT o FROM Buku o WHERE o.niy=:niy").setParameter("niy", niy).getSingleResult();
    }

    @Override
    public List<Buku> findEntries(int firstResult, int maxResults) {
        return this.entityManager.createQuery("SELECT o FROM Buku o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public Buku find(Long id) {
        return entityManager.find(Buku.class, id);
    }

    @Override
    public void persist(Buku o) {
        this.entityManager.persist(o);
    }

    @Override
    public void merge(Buku o) {
        this.entityManager.merge(o);
    }

    @Override
    public void remove(Buku o) {
        this.entityManager.remove(this.entityManager.merge(o));
    }

    public List<Buku> search(String emboh) {
        return (List<Buku>) this.entityManager.createQuery("SELECT b FROM Buku b WHERE b.judul LIKE ':emboh'").setParameter("emboh", emboh).getResultList();
    }

    public void persist(List<Buku> buku) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Buku> cari(SearchCriteria criteria) {
        String pattern = getSearchPattern(criteria);
        return entityManager.createQuery(
                "select b from Buku b where lower(b.judul) like " + pattern) //+ " or lower(b.penerbit.nama) like " + pattern
                //+ " or lower(b.kategori.nama) like " + pattern
                //+ " or lower(b.pengarang.nama) like " + pattern)
                .setMaxResults(criteria.getPageSize()).setFirstResult(
                criteria.getPage() * criteria.getPageSize()).getResultList();
    }

    public List<Buku> cariPengarang(SearchCriteria criteria) {
        String pattern = getSearchPattern(criteria);
        return entityManager.createQuery(
                "select b from Buku b where lower(b.pengarang.nama) like " + pattern) //+ " or lower(b.penerbit.nama) like " + pattern
                //+ " or lower(b.kategori.nama) like " + pattern
                //+ " or lower(b.pengarang.nama) like " + pattern)
                .setMaxResults(criteria.getPageSize()).setFirstResult(
                criteria.getPage() * criteria.getPageSize()).getResultList();
    }

    // helpers
    private String getSearchPattern(SearchCriteria criteria) {
        if (StringUtils.hasText(criteria.getSearchString())) {
            return "'%"
                    + criteria.getSearchString().toLowerCase().replace('*', '%') + "%'";
        } else {
            return "'%'";
        }
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Buku> findBookings(String nama) {
        if (nama != null) {
            return entityManager.createQuery(
                    "select b from Buku b where b.user.nama = :nama").setParameter("username", nama).getResultList();
        } else {
            return null;
        }
    }

    public List<Buku> jumlahCari() {
        return this.entityManager.createQuery("SELECT o FROM Buku o "
                + "WHERE o.jumlahCari != 0 ORDER BY o.jumlahCari DESC, o.judul").setMaxResults(5).getResultList();
    }

    public void updateJumlah(Long id) {
        this.entityManager.createQuery("UPDATE Buku b SET b.jumlahCari = b.jumlahCari+1 "
                + "WHERE b.id = :id").setParameter("id", id).executeUpdate();
    }

    public List<Buku> sepiCari() {
        return this.entityManager.createQuery("SELECT o FROM Buku o "
                + "WHERE o.jumlahCari=0").getResultList();
    }
    
      //menghitung jumlah judul yang berhasil dicari
    public Long countResultSearch(SearchCriteria criteria) {
        String pattern = getSearchPattern(criteria);
       // String p = criteria.getSearchString();
        // List<Buku> patternCari = cariPengarang(criteria);
        return (Long) entityManager.createQuery("SELECT count(b) FROM Buku b WHERE b.judul LIKE "+pattern ).getSingleResult();

       
    }

     public Long countResultSearchPengarang(SearchCriteria criteria) {
        String pattern = getSearchPattern(criteria);

        return (Long) entityManager.createQuery("SELECT count(b) FROM Buku b WHERE b.pengarang.nama LIKE "+pattern ).getSingleResult();


    }
}
