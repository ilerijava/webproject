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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Tutev
 */
@Entity
@Table(name = "IL")
public class Il implements Serializable{

    Long id;
    String tanim;
    String plaka;
    String kod;

    @Id
    @SequenceGenerator(name = "il_seq", sequenceName = "il_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "il_seq")
    @Column(name = "IL_ID", updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "IL_TANIM")
    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }

    @Column(name = "IL_PLAKA")
    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    @Column(name = "IL_KOD")
    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

}
