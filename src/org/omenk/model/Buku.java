/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.omenk.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author ndh
 */
@Entity
@Table
public class Buku implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    private String isbn;
    @Size(min = 1, message = "tidak boleh kosong")
    private String kodeBuku;
    @Size(min = 1, message = "tidak boleh kosong")
    private String judul;
    @ManyToOne(targetEntity = Kategori.class)
    //@JoinColumn(name="kategori")
    private Kategori kategori;
    @ManyToOne(targetEntity = Penerbit.class)
    //@JoinColumn(name="penerbit")
    private Penerbit penerbit;
    @ManyToOne(targetEntity = Pengarang.class)
    //@JoinColumn(name="pengarang")
    private Pengarang pengarang;
    @ManyToOne(targetEntity = Lokasi.class)
    //@JoinColumn(name="lokasi")
    private Lokasi lokasi;
    private CommonsMultipartFile fileData;
    private String cover;
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMMM-yyyy")
    private Date tanggalTerbit;
    @Column(name = "jumlahCari", columnDefinition = "bigint(20) default 0")
    private Integer jumlahCari = 0;

    public CommonsMultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }

    public Integer getJumlahCari() {
        return jumlahCari;
    }

    public void setJumlahCari(Integer jumlahCari) {
        this.jumlahCari = jumlahCari;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }

    public Penerbit getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(Penerbit penerbit) {
        this.penerbit = penerbit;
    }

    public Pengarang getPengarang() {
        return pengarang;
    }

    public void setPengarang(Pengarang pengarang) {
        this.pengarang = pengarang;
    }

    public Date getTanggalTerbit() {
        return tanggalTerbit;
    }

    public void setTanggalTerbit(Date tanggalTerbit) {
        this.tanggalTerbit = tanggalTerbit;
    }

    @Override
    public String toString() {
        return "Buku{" + "id=" + id + "isbn=" + isbn + "kodeBuku=" + kodeBuku + "judul=" + judul + "kategori=" + kategori + "penerbit=" + penerbit + "pengarang=" + pengarang + "lokasi=" + lokasi + "cover=" + cover + "tanggalTerbit=" + tanggalTerbit + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Buku other = (Buku) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.isbn == null) ? (other.isbn != null) : !this.isbn.equals(other.isbn)) {
            return false;
        }
        if ((this.kodeBuku == null) ? (other.kodeBuku != null) : !this.kodeBuku.equals(other.kodeBuku)) {
            return false;
        }
        if ((this.judul == null) ? (other.judul != null) : !this.judul.equals(other.judul)) {
            return false;
        }
        if (this.kategori != other.kategori && (this.kategori == null || !this.kategori.equals(other.kategori))) {
            return false;
        }
        if (this.penerbit != other.penerbit && (this.penerbit == null || !this.penerbit.equals(other.penerbit))) {
            return false;
        }
        if (this.pengarang != other.pengarang && (this.pengarang == null || !this.pengarang.equals(other.pengarang))) {
            return false;
        }
        if (this.lokasi != other.lokasi && (this.lokasi == null || !this.lokasi.equals(other.lokasi))) {
            return false;
        }
        if ((this.cover == null) ? (other.cover != null) : !this.cover.equals(other.cover)) {
            return false;
        }
        if (this.tanggalTerbit != other.tanggalTerbit && (this.tanggalTerbit == null || !this.tanggalTerbit.equals(other.tanggalTerbit))) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 29 * hash + (this.isbn != null ? this.isbn.hashCode() : 0);
        hash = 29 * hash + (this.kodeBuku != null ? this.kodeBuku.hashCode() : 0);
        hash = 29 * hash + (this.judul != null ? this.judul.hashCode() : 0);
        hash = 29 * hash + (this.kategori != null ? this.kategori.hashCode() : 0);
        hash = 29 * hash + (this.penerbit != null ? this.penerbit.hashCode() : 0);
        hash = 29 * hash + (this.pengarang != null ? this.pengarang.hashCode() : 0);
        hash = 29 * hash + (this.lokasi != null ? this.lokasi.hashCode() : 0);
        hash = 29 * hash + (this.cover != null ? this.cover.hashCode() : 0);
        hash = 29 * hash + (this.tanggalTerbit != null ? this.tanggalTerbit.hashCode() : 0);

        return hash;
    }
}
