package org.omenk.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.omenk.model.Pengarang;

public interface PengarangDAO {

    public Long count();

    public Pengarang find(Long id);

    public List<Pengarang> findAll();

    public Pengarang findByNiy(String niy);

    public List<Pengarang> findEntries(int firstResult, int maxResults);

    @Transactional
    public void merge(Pengarang o);

    @Transactional
    public void persist(Pengarang o);

    @Transactional
    public void remove(Pengarang o);
}
