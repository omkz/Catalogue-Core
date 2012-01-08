package org.omenk.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.omenk.model.Penerbit;

public interface PenerbitDAO {

    public Long count();

    public Penerbit find(Long id);

    public List<Penerbit> findAll();

    public Penerbit findByNiy(String niy);

    public List<Penerbit> findEntries(int firstResult, int maxResults);

    @Transactional
    public void merge(Penerbit o);

    @Transactional
    public void persist(Penerbit o);

    @Transactional
    public void remove(Penerbit o);
}
