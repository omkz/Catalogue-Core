package org.omenk.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.omenk.model.Lokasi;

public interface LokasiDAO {

    public Long count();

    public Lokasi find(Long id);

    public List<Lokasi> findAll();

    public Lokasi findByNiy(String niy);

    public List<Lokasi> findEntries(int firstResult, int maxResults);

    @Transactional
    public void merge(Lokasi o);

    @Transactional
    public void persist(Lokasi o);

    @Transactional
    public void remove(Lokasi o);
}
