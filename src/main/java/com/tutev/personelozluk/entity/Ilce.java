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
@Table(name="ILCE")
public class Ilce implements Serializable{
    Long id;
    Il il;
    String tanim;
    String kod;

    @Id
    @SequenceGenerator(name = "ilce_seq", sequenceName = "ilce_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ilce_seq")
    @Column(name = "ILCE_ID", updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional = true)
    @JoinColumn(columnDefinition = "IL_ID")
    public Il getIl() {
        return il;
    }

    public void setIl(Il il) {
        this.il = il;
    }

    @Column(name = "ILCE_TANIM")
    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }

    @Column(name = "ILCE_KOD")
    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }
    
    
    
}
