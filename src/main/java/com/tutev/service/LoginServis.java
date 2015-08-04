package com.tutev.service;

import com.tutev.entity.Kisi;
import com.tutev.entity.Kullanici;
import com.tutev.entity.KullaniciYetkiRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loginServis")
@SuppressWarnings("unchecked")
public class LoginServis {

  @Autowired
  private transient BaseServis baseServis;

  public Kisi login(String tcKimlikNo, String sifre) {
    String[] parameterNames = {"tcKimlikNo", "sifre"};
    String[] parameterValues = {tcKimlikNo, sifre};

    List<Kisi> list = (List<Kisi>) baseServis.get(parameterNames,
        parameterValues, Kisi.class);

    if (list.size() > 0) {
      return list.get(0);
    }
    return null;
  }

  public List<KullaniciYetkiRol> getKullaniciRolByKullaniciId(Long id) {
    String[] parameterNames = {"kullanici.id"};
    Object[] parameterValues = {id};

    List<KullaniciYetkiRol> list = (List<KullaniciYetkiRol>) baseServis
        .get(parameterNames, parameterValues, KullaniciYetkiRol.class);

    return list;
  }

  public Kullanici getUserByName(String username) {
    String[] parameterNames = {"username"};
    Object[] parameterValues = {username};

    List<Kullanici> list = (List<Kullanici>) baseServis.get(parameterNames,
        parameterValues, Kullanici.class);

    if (list.size() > 0) {
      return list.get(0);
    } else {
      return null;
    }
  }


}
