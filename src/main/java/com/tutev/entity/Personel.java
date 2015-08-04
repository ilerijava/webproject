/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tutev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Tutev
 */
@Entity
@Table(name = "PERSONEL")
public class Personel implements Serializable {
  Long id;
  Firma firma;
  Kisi kisi;
  String personelSicilNo;


  @Id
  @SequenceGenerator(name = "kisi_seq", sequenceName = "kisi_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "kisi_seq")
  @Column(name = "KISI_ID", updatable = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @ManyToOne(optional = true)
  @JoinColumn(columnDefinition = "FIRMA_ID")
  public Firma getFirma() {
    return firma;
  }

  public void setFirma(Firma firma) {
    this.firma = firma;
  }

  @ManyToOne(optional = true)
  @JoinColumn(columnDefinition = "KISI_ID")
  public Kisi getKisi() {
    return kisi;
  }

  public void setKisi(Kisi kisi) {
    this.kisi = kisi;
  }

  @Column(name = "PERSONEL_SICIL_NO", length = 30)
  public String getPersonelSicilNo() {
    return personelSicilNo;
  }

  public void setPersonelSicilNo(String personelSicilNo) {
    this.personelSicilNo = personelSicilNo;
  }


}
