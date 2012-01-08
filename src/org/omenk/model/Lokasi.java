/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.omenk.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author ski
 */
@Entity
@Table
public class Lokasi implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Size(min=1, message="tidak boleh kosong")
    private String nama;
    
    
    private String keterangan;

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lokasi other = (Lokasi) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nama == null) ? (other.nama != null) : !this.nama.equals(other.nama)) {
            return false;
        }
        if ((this.keterangan == null) ? (other.keterangan != null) : !this.keterangan.equals(other.keterangan)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 61 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        hash = 61 * hash + (this.keterangan != null ? this.keterangan.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Lokasi{" + "id=" + id + "nama=" + nama + "keterangan=" + keterangan + '}';
    }
    
}
