/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.omenk.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author ndh
 */
@Entity
@Table
public class Pengarang implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Size(min=2,message="nama kagak boleh kosong")
    private String nama;
    
    private String biografi;
    @Pattern(regexp=".+@.+\\.[a-z]+", message="email yang anda masukan salah,ex : omenkzz@gmail.com")
    private String email;
    private String alamat;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiografi() {
        return biografi;
    }

    public void setBiografi(String biografi) {
        this.biografi = biografi;
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pengarang other = (Pengarang) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nama == null) ? (other.nama != null) : !this.nama.equals(other.nama)) {
            return false;
        }
        if ((this.biografi == null) ? (other.biografi != null) : !this.biografi.equals(other.biografi)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.alamat == null) ? (other.alamat != null) : !this.alamat.equals(other.alamat)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 53 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        hash = 53 * hash + (this.biografi != null ? this.biografi.hashCode() : 0);
        hash = 53 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 53 * hash + (this.alamat != null ? this.alamat.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Pengarang{" + "id=" + id + "nama=" + nama + "biografi=" + biografi + "email=" + email + "alamat=" + alamat + '}';
    }

    



}
