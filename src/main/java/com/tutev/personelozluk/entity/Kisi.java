/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tutev.personelozluk.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "KISI")
public class Kisi implements Serializable {

	Long id;
	String ad;
	String soyad;
	String tcKimlikNo;

	Adres adres = new Adres();

	@Id
	@SequenceGenerator(name = "kisi_seq", sequenceName = "kisi_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "kisi_seq")
	@Column(name = "KISI_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "KISI_AD", length = 100)
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	@Column(name = "KISI_SOYAD", length = 100)
	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	@Column(name = "KISI_TCKN", length = 11)
	public String getTcKimlikNo() {
		return tcKimlikNo;
	}

	public void setTcKimlikNo(String tcKimlikNo) {
		this.tcKimlikNo = tcKimlikNo;
	}

	@ManyToOne(optional = true)
	@JoinColumn(columnDefinition = "ADRES_ID")
	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

}
