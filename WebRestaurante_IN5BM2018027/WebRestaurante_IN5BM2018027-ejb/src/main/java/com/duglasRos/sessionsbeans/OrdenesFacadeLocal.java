/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duglasRos.sessionsbeans;

import com.duglasRos.entities.Ordenes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author programacion
 */
@Local
public interface OrdenesFacadeLocal {

    void create(Ordenes ordenes);

    void edit(Ordenes ordenes);

    void remove(Ordenes ordenes);

    Ordenes find(Object id);

    List<Ordenes> findAll();

    List<Ordenes> findRange(int[] range);

    int count();
    
}
