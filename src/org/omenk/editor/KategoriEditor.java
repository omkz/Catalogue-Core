package org.omenk.editor;

import java.beans.PropertyEditorSupport;

import org.omenk.dao.KategoriDAO;
import org.omenk.model.Kategori;

import org.springframework.beans.SimpleTypeConverter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ski
 */
public class KategoriEditor extends PropertyEditorSupport{

    // ------------------------------ FIELDS ------------------------------

    private KategoriDAO kategoriDAO;

    private SimpleTypeConverter simpleTypeConverter = new SimpleTypeConverter();

// --------------------------- CONSTRUCTORS ---------------------------

    public KategoriEditor(KategoriDAO kategoriDAO) {
        this.kategoriDAO = kategoriDAO;
    }

// --------------------- Interface PropertyEditor ---------------------


    // ------------------------ INTERFACE METHODS ------------------------
    @Override
    public String getAsText() {
        Object obj = getValue();
        if (obj == null) {
            return null;
        }
        return simpleTypeConverter.convertIfNecessary(((Kategori) obj).getId(), String.class);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.length() == 0) {
            setValue(null);
            return;
        }

        Long identifier = simpleTypeConverter.convertIfNecessary(text, Long.class);
        if (identifier == null) {
            setValue(null);
            return;
        }

        try {
            setValue(kategoriDAO.find(identifier));
        } catch (Exception e) {
            setValue(null);
            System.err.println(e.getMessage());
        }
    }

}
