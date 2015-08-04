package com.tutev.bean;


import com.tutev.entity.Tema;
import com.tutev.service.TemaServis;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean
public class TemaBean {

  private List<Tema> temaList;

  @ManagedProperty("#{temaServis}")
  private TemaServis servis;

  @PostConstruct
  public void init() {
    temaList = servis.getTemaList();
  }

  public List<Tema> getTemaList() {
    return temaList;
  }

  public void setService(TemaServis servis) {
    this.servis = servis;
  }
}