package com.tutev.personelozluk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "KULLANICI")
public class Kullanici implements Serializable {

	private static final long serialVersionUID = 32432432432432432L;
	Long id;
    String username;
    String password;
    Kisi kisi;

    public Kullanici() {
    }

    public Kullanici(Long id, String username, String password, Kisi kisi) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.kisi = kisi;
    }
    
    

    @Id
    @Column(name = "id")
    @SequenceGenerator(allocationSize = 1, name = "seq_kullanici_id", initialValue = 1, sequenceName = "seq_kullanici_id")
    @GeneratedValue(generator = "seq_kullanici_id", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true,name = "username",length = 100,nullable = false,updatable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password",length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JoinColumn(name = "kisi_id")
    @ManyToOne(fetch = FetchType.LAZY)
    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    @Override
    public String toString() {
        return "Kullanici{" + "id=" + id + ", username=" + username + ", password=" + password + ", kisi=" + kisi + '}';
    }

    
}
