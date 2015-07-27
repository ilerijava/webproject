package com.tutev.entity;

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
@Table(name = "KULLANICIYETKIROL")
public class KullaniciYetkiRol implements Serializable {

	private static final long serialVersionUID = 3454359864385643L;
	Long id;
	Rol rol;
	Kullanici kullanici;
	Yetki yetki;
	Boolean ins;
	Boolean del;
	Boolean que;
	Boolean upd;

	public KullaniciYetkiRol() {

	}

	public KullaniciYetkiRol(Long id, Rol rol, Kullanici kullanici,
			Yetki yetki, Boolean ins, Boolean del, Boolean que, Boolean upd) {

		this.del = del;
		this.id = id;
		this.ins = ins;
		this.kullanici = kullanici;
		this.que = que;
		this.rol = rol;
		this.yetki = yetki;
		this.upd = upd;

	}

	@Id
	@Column(name = "id")
	@SequenceGenerator(allocationSize = 1, name = "seq_kullanici_yetki_rol_id", initialValue = 1, sequenceName = "seq_kullanici_yetki_rol_id")
	@GeneratedValue(generator = "seq_kullanici_yetki_rol_id", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JoinColumn(name = "rol_id")
	@ManyToOne(fetch = FetchType.LAZY)
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@JoinColumn(name = "kullanici_id")
	@ManyToOne(fetch = FetchType.LAZY)
	public Kullanici getKullanici() {
		return kullanici;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}

	@JoinColumn(name = "yetki_id")
	@ManyToOne(fetch = FetchType.LAZY)
	public Yetki getYetki() {
		return yetki;
	}

	public void setYetki(Yetki yetki) {
		this.yetki = yetki;
	}

	@Column(unique = true, name = "ekleme")
	public Boolean getIns() {
		return ins;
	}

	public void setIns(Boolean ins) {
		this.ins = ins;
	}

	@Column(unique = true, name = "silme")
	public Boolean getDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	@Column(unique = true, name = "sorgulama")
	public Boolean getQue() {
		return que;
	}

	public void setQue(Boolean que) {
		this.que = que;
	}

	@Column(unique = true, name = "guncelleme")
	public Boolean getUpd() {
		return upd;
	}

	public void setUpd(Boolean upd) {
		this.upd = upd;
	}

}
