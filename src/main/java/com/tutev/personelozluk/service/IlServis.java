/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tutev.personelozluk.service;

import java.util.List;

import com.tutev.personelozluk.dao.GenericDao;
import com.tutev.personelozluk.entity.Il;

/**
 *
 * @author Tutev
 */
public class IlServis {
    GenericDao genericDao=new GenericDao();
    
    public void save(Il il){
        if(il.getTanim()==null){
            return;
        }
        genericDao.save(il);
    }
    
    public void update(Il il){
        if(il.getTanim()==null){
            return;
        }
        genericDao.saveOrUpdate(il);
    }
    
    public void delete(Il il){
        genericDao.delete(il);
    }
    
    public List<Il> getAll(){
        return (List<Il>)genericDao.get(Il.class);
     }
    
    
}
