package org.omenk.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.omenk.model.Kategori;


public interface KategoriDAO {

    public Long count();

    public Kategori find(Long id);

    public List<Kategori> findAll();

    public Kategori findByNiy(String niy);

    public List<Kategori> findEntries(int firstResult, int maxResults);

     

    @Transactional
    public void merge(Kategori o);

    @Transactional
    public void persist(Kategori o);

    @Transactional
    public void remove(Kategori o);
}
