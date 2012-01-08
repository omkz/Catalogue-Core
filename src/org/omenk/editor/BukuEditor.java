package org.omenk.editor;

import java.beans.PropertyEditorSupport;

import org.omenk.dao.BukuDAO;
import org.omenk.model.Buku;
import org.springframework.beans.SimpleTypeConverter;


public class BukuEditor extends PropertyEditorSupport {

    private final BukuDAO bukuDAO;

     // ------------------------------ FIELDS ------------------------------



    private SimpleTypeConverter simpleTypeConverter = new SimpleTypeConverter();

// --------------------------- CONSTRUCTORS ---------------------------

   public BukuEditor(BukuDAO bukuDAO) {
        this.bukuDAO = bukuDAO;
    }

// --------------------- Interface PropertyEditor ---------------------


    // ------------------------ INTERFACE METHODS ------------------------
    @Override
    public String getAsText() {
        Object obj = getValue();
        if (obj == null) {
            return null;
        }
        return simpleTypeConverter.convertIfNecessary(((Buku) obj).getId(), String.class);
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
            setValue(bukuDAO.find(identifier));
        } catch (Exception e) {
            setValue(null);
            System.err.println(e.getMessage());
        }
    }
}
