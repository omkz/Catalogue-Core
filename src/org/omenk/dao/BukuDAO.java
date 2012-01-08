package org.omenk.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.omenk.model.Buku;
import org.omenk.services.SearchCriteria;
//import java.security.MessageDigest;

public interface BukuDAO {

    public Long count();

    public Buku find(Long id);

    public List<Buku> findAll();

    public List<Buku> jumlahCari();

    public List<Buku> sepiCari();

    public Buku findByNiy(String nim);

    public List<Buku> findEntries(int firstResult, int maxResults);

    @Transactional
    public void merge(Buku o);

    @Transactional
    public void persist(Buku o);

    @Transactional
    public void remove(Buku o);

    public List<Buku> search(String emboh);

    public void persist(List<Buku> buku);

    @Transactional
    public List<Buku> cari(SearchCriteria criteria);

    @Transactional
    public List<Buku> cariPengarang(SearchCriteria criteria);

    public void updateJumlah(Long id);

    public Long countResultSearch(SearchCriteria criteria);

    public Long countResultSearchPengarang(SearchCriteria criteria);
}
