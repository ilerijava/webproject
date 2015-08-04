package com.tutev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "YETKI")
public class Yetki implements Serializable {

  private static final long serialVersionUID = -5467745860308785145L;
  Long id;
  String tanim;
  String kod;

  public Yetki() {

  }


  public Yetki(Long id, String tanim, String kod) {
    this.id = id;
    this.tanim = tanim;
    this.kod = kod;
  }


  @Id
  @Column(name = "id")
  @SequenceGenerator(allocationSize = 1, name = "seq_yetki_id", initialValue = 1, sequenceName = "seq_yetki_id")
  @GeneratedValue(generator = "seq_yetki_id", strategy = GenerationType.SEQUENCE)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "tanim")
  public String getTanim() {
    return tanim;
  }

  public void setTanim(String tanim) {
    this.tanim = tanim;
  }

  @Column(name = "kod")
  public String getKod() {
    return kod;
  }

  public void setKod(String kod) {
    this.kod = kod;
  }

}
