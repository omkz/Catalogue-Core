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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table
public class Kategori implements Serializable {

    @GeneratedValue
    @Id
    private Long id;
    @Column(unique = true, nullable = false)
    @Size(min = 2,message="tidak boleh kosong")   
    private String nama;
   
    
    //@Size(min = 2,message="tidak boleh kosong")
    private String Keterangan;

    public String getKeterangan() {
        return Keterangan;
    }

    public void setKeterangan(String Keterangan) {
        this.Keterangan = Keterangan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kategori other = (Kategori) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nama == null) ? (other.nama != null) : !this.nama.equals(other.nama)) {
            return false;
        }
        if ((this.Keterangan == null) ? (other.Keterangan != null) : !this.Keterangan.equals(other.Keterangan)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 31 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        hash = 31 * hash + (this.Keterangan != null ? this.Keterangan.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Kategori{" + "id=" + id + "nama=" + nama + "Keterangan=" + Keterangan + '}';
    }
}
