/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tutev.personelozluk.service;

import com.tutev.personelozluk.dao.GenericDao;
import com.tutev.personelozluk.entity.Personel;
import java.util.List;

/**
 *
 * @author Tutev
 */
public class PersonelServis {
    GenericDao genericDao=new GenericDao();
    
    public void save(Personel personel){
        if(personel.getKisi().getAd()==null && personel.getKisi().getTcKimlikNo()==null){
            return;
        }
        genericDao.save(personel);
    }
    
    public void update(Personel personel){
        if(personel.getKisi().getAd()==null&& personel.getKisi().getTcKimlikNo()==null){
            return;
        }
        genericDao.saveOrUpdate(personel);
    }
    
    public void delete(Personel personel){
        genericDao.delete(personel);
    }
    
    public List<Personel> getAll(){
       return (List<Personel>)genericDao.get(Personel.class);
    }
    
}
