package com.tutev.service;

import com.tutev.entity.Tema;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "TemaServis", eager = true)
@ApplicationScoped
public class TemaServis {

  private List<Tema> temaList;

  @PostConstruct
  public void init() {
    temaList = new ArrayList<Tema>();
    temaList.add(new Tema(0, "Afterdark", "afterdark"));
    temaList.add(new Tema(1, "Afternoon", "afternoon"));
    temaList.add(new Tema(2, "Afterwork", "afterwork"));
    temaList.add(new Tema(3, "Aristo", "aristo"));
    temaList.add(new Tema(4, "Black-Tie", "black-tie"));
    temaList.add(new Tema(5, "Blitzer", "blitzer"));
    temaList.add(new Tema(6, "Bluesky", "bluesky"));
    temaList.add(new Tema(7, "Bootstrap", "bootstrap"));
    temaList.add(new Tema(8, "Casablanca", "casablanca"));
    temaList.add(new Tema(9, "Cupertino", "cupertino"));
    temaList.add(new Tema(10, "Cruze", "cruze"));
    temaList.add(new Tema(11, "Dark-Hive", "dark-hive"));
    temaList.add(new Tema(12, "Delta", "delta"));
    temaList.add(new Tema(13, "Dot-Luv", "dot-luv"));
    temaList.add(new Tema(14, "Eggplant", "eggplant"));
    temaList.add(new Tema(15, "Excite-Bike", "excite-bike"));
    temaList.add(new Tema(16, "Flick", "flick"));
    temaList.add(new Tema(17, "Glass-X", "glass-x"));
    temaList.add(new Tema(18, "Home", "home"));
    temaList.add(new Tema(19, "Hot-Sneaks", "hot-sneaks"));
    temaList.add(new Tema(20, "Humanity", "humanity"));
    temaList.add(new Tema(21, "Le-Frog", "le-frog"));
    temaList.add(new Tema(22, "Midnight", "midnight"));
    temaList.add(new Tema(23, "Mint-Choc", "mint-choc"));
    temaList.add(new Tema(24, "Overcast", "overcast"));
    temaList.add(new Tema(25, "Pepper-Grinder", "pepper-grinder"));
    temaList.add(new Tema(26, "Redmond", "redmond"));
    temaList.add(new Tema(27, "Rocket", "rocket"));
    temaList.add(new Tema(28, "Sam", "sam"));
    temaList.add(new Tema(29, "Smoothness", "smoothness"));
    temaList.add(new Tema(30, "South-Street", "south-street"));
    temaList.add(new Tema(31, "Start", "start"));
    temaList.add(new Tema(32, "Sunny", "sunny"));
    temaList.add(new Tema(33, "Swanky-Purse", "swanky-purse"));
    temaList.add(new Tema(34, "Trontastic", "trontastic"));
    temaList.add(new Tema(35, "UI-Darkness", "ui-darkness"));
    temaList.add(new Tema(36, "UI-Lightness", "ui-lightness"));
    temaList.add(new Tema(37, "Vader", "vader"));
  }

  public List<Tema> getTemaList() {
    return temaList;
  }

}
