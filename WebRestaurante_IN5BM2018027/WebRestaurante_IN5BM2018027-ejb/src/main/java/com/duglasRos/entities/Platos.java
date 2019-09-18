/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duglasRos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "platos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platos.findAll", query = "SELECT p FROM Platos p")
    , @NamedQuery(name = "Platos.findByIdplato", query = "SELECT p FROM Platos p WHERE p.idplato = :idplato")
    , @NamedQuery(name = "Platos.findByPlato", query = "SELECT p FROM Platos p WHERE p.plato = :plato")
    , @NamedQuery(name = "Platos.findByCosto", query = "SELECT p FROM Platos p WHERE p.costo = :costo")})
public class Platos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idplato")
    private Integer idplato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "plato")
    private String plato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private long costo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplato")
    private List<Ordenes> ordenesList;

    public Platos() {
    }

    public Platos(Integer idplato) {
        this.idplato = idplato;
    }

    public Platos(Integer idplato, String plato, long costo) {
        this.idplato = idplato;
        this.plato = plato;
        this.costo = costo;
    }

    public Integer getIdplato() {
        return idplato;
    }

    public void setIdplato(Integer idplato) {
        this.idplato = idplato;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }

    @XmlTransient
    public List<Ordenes> getOrdenesList() {
        return ordenesList;
    }

    public void setOrdenesList(List<Ordenes> ordenesList) {
        this.ordenesList = ordenesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplato != null ? idplato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Platos)) {
            return false;
        }
        Platos other = (Platos) object;
        if ((this.idplato == null && other.idplato != null) || (this.idplato != null && !this.idplato.equals(other.idplato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.duglasRos.entities.Platos[ idplato=" + idplato + " ]";
    }
    
}
