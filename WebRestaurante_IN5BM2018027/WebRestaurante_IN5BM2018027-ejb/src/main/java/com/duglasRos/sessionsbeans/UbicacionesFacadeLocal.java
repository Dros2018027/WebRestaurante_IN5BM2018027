/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duglasRos.sessionsbeans;

import com.duglasRos.entities.Ubicaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author programacion
 */
@Local
public interface UbicacionesFacadeLocal {

    void create(Ubicaciones ubicaciones);

    void edit(Ubicaciones ubicaciones);

    void remove(Ubicaciones ubicaciones);

    Ubicaciones find(Object id);

    List<Ubicaciones> findAll();

    List<Ubicaciones> findRange(int[] range);

    int count();
    
}
