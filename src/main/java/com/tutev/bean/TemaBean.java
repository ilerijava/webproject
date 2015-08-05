package com.tutev.bean;


import com.tutev.entity.Tema;
import com.tutev.service.TemaServis;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import java.util.List;

@ManagedBean(name = "temaView")
@ViewScoped
public class TemaBean {

  private List<Tema> temaList;

  private Tema selectedTema;
  private String tema;

  @ManagedProperty("#{TemaServis}")
  private TemaServis temaServis;

  @PostConstruct
  public void init() {
    temaList = temaServis.getTemaList();
    tema = temaList.get(0).getName();
  }

  public void seciliTemaKaydet() {
      System.out.println(tema);
  }

  public List<Tema> getTemaList() {
    return temaList;
  }

  public void setTemaList(List<Tema> temaList) {
    this.temaList = temaList;
  }

  public Tema getSelectedTema() {
    return selectedTema;
  }

  public void setSelectedTema(Tema selectedTema) {
    this.selectedTema = selectedTema;
  }

  public TemaServis getTemaServis() {
    return temaServis;
  }

  public void setTemaServis(TemaServis temaServis) {
    this.temaServis = temaServis;


  }

  public String getTema() {
    return tema;
  }

  public void setTema(String tema) {
    this.tema = tema;
  }
}