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

/**
 *
 * @author Tutev
 */
@Entity
@Table()
public class Firma implements Serializable{
    Long id;
    String firmaAd;
    String vergiNo;
    Kisi firmaYetkilisi;
    Il il;
    Ilce ilce;
    Adres adres;

    @Id
    @SequenceGenerator(name = "firma_seq", sequenceName = "firma_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "firma_seq")
    @Column(name = "FIRMA_ID", updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FIRMA_AD")
    public String getFirmaAd() {
        return firmaAd;
    }

    public void setFirmaAd(String firmaAd) {
        this.firmaAd = firmaAd;
    }

    @Column(name = "FIRMA_VERGI_NO" , length = 11)
    public String getVergiNo() {
        return vergiNo;
    }

    public void setVergiNo(String vergiNo) {
        this.vergiNo = vergiNo;
    }

    @ManyToOne(optional = true)
    @JoinColumn(columnDefinition = "KISI_ID")
    public Kisi getFirmaYetkilisi() {
        return firmaYetkilisi;
    }

    public void setFirmaYetkilisi(Kisi firmaYetkilisi) {
        this.firmaYetkilisi = firmaYetkilisi;
    }

    @ManyToOne(optional = true)
    @JoinColumn(columnDefinition = "IL_ID")
    public Il getIl() {
        return il;
    }

    public void setIl(Il il) {
        this.il = il;
    }

    @ManyToOne(optional = true)
    @JoinColumn(columnDefinition = "ILCE_ID")
    public Ilce getIlce() {
        return ilce;
    }

    public void setIlce(Ilce ilce) {
        this.ilce = ilce;
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
