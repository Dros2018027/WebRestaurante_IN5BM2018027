/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duglasRos.sessionsbeans;

import com.duglasRos.entities.Puestos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author programacion
 */
@Local
public interface PuestosFacadeLocal {

    void create(Puestos puestos);

    void edit(Puestos puestos);

    void remove(Puestos puestos);

    Puestos find(Object id);

    List<Puestos> findAll();

    List<Puestos> findRange(int[] range);

    int count();
    
}
