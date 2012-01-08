package org.omenk.editor;

import java.beans.PropertyEditorSupport;


import org.omenk.dao.PengarangDAO;

import org.omenk.model.Pengarang;

import org.springframework.beans.SimpleTypeConverter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ski
 */
public class PengarangEditor extends PropertyEditorSupport{

    // ------------------------------ FIELDS ------------------------------

    private  PengarangDAO  pengarangDAO;

    private SimpleTypeConverter simpleTypeConverter = new SimpleTypeConverter();

// --------------------------- CONSTRUCTORS ---------------------------

    public PengarangEditor(PengarangDAO  pengarangDAO) {
        this. pengarangDAO =  pengarangDAO;
    }

// --------------------- Interface PropertyEditor ---------------------


    // ------------------------ INTERFACE METHODS ------------------------
    @Override
    public String getAsText() {
        Object obj = getValue();
        if (obj == null) {
            return null;
        }
        return simpleTypeConverter.convertIfNecessary(((Pengarang) obj).getId(), String.class);
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
            setValue(pengarangDAO.find(identifier));
        } catch (Exception e) {
            setValue(null);
            System.err.println(e.getMessage());
        }
    }

}
