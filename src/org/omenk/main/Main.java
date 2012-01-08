/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.omenk.main;

import org.omenk.dao.KategoriDAO;
import org.omenk.model.Kategori;
import org.omenk.provider.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author ski
 */
public class Main {

    public static void main(String[] omenkzzzzzz) {

        ApplicationContext appContext = ApplicationContextProvider.getInstance().getApplicationContext();

        KategoriDAO kategoriDAO = appContext.getBean("kategoriDAOImpl", KategoriDAO.class);

        /*
        Kategori kategori = new Kategori();
        kategori.setNama("Komputer");
        kategori.setKeterangan("Buku Komputer");
        kategoriDAO.persist(kategori);
*/
    }

}
