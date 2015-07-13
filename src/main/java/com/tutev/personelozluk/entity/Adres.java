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
@Table(name = "ADRES")
public class Adres implements Serializable{

	private static final long serialVersionUID = -4234253797464481734L;
	Long id;
    String adresTanim;
    Il il = new Il(); 
    Ilce ilce = new Ilce();

    @Id
    @SequenceGenerator(name = "adres_seq", sequenceName = "adres_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "adres_seq")
    @Column(name = "ADRES_ID", updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ADRES_TANIM",length = 100)
    public String getAdresTanim() {
        return adresTanim;
    }

    public void setAdresTanim(String adresTanim) {
        this.adresTanim = adresTanim;
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

}
