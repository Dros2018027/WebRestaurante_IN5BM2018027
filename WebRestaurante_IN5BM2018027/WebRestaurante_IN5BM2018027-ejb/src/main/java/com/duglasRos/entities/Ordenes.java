/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duglasRos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenes.findAll", query = "SELECT o FROM Ordenes o")
    , @NamedQuery(name = "Ordenes.findByIdorden", query = "SELECT o FROM Ordenes o WHERE o.idorden = :idorden")
    , @NamedQuery(name = "Ordenes.findByPlatoCosto", query = "SELECT o FROM Ordenes o WHERE o.platoCosto = :platoCosto")
    , @NamedQuery(name = "Ordenes.findByCantidadplatos", query = "SELECT o FROM Ordenes o WHERE o.cantidadplatos = :cantidadplatos")
    , @NamedQuery(name = "Ordenes.findByDescripcion", query = "SELECT o FROM Ordenes o WHERE o.descripcion = :descripcion")
    , @NamedQuery(name = "Ordenes.findByTotalventa", query = "SELECT o FROM Ordenes o WHERE o.totalventa = :totalventa")})
public class Ordenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idorden")
    private Integer idorden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plato_costo")
    private long platoCosto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadplatos")
    private int cantidadplatos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "totalventa")
    private Long totalventa;
    @JoinTable(name = "orden_factura", joinColumns = {
        @JoinColumn(name = "idorden", referencedColumnName = "idorden")}, inverseJoinColumns = {
        @JoinColumn(name = "idfactura", referencedColumnName = "idfactura")})
    @ManyToMany
    private List<Factura> facturaList;
    @JoinColumn(name = "idmesa", referencedColumnName = "idmesa")
    @ManyToOne(optional = false)
    private Mesas idmesa;
    @JoinColumn(name = "idplato", referencedColumnName = "idplato")
    @ManyToOne(optional = false)
    private Platos idplato;

    public Ordenes() {
    }

    public Ordenes(Integer idorden) {
        this.idorden = idorden;
    }

    public Ordenes(Integer idorden, long platoCosto, int cantidadplatos, String descripcion) {
        this.idorden = idorden;
        this.platoCosto = platoCosto;
        this.cantidadplatos = cantidadplatos;
        this.descripcion = descripcion;
    }

    public Integer getIdorden() {
        return idorden;
    }

    public void setIdorden(Integer idorden) {
        this.idorden = idorden;
    }

    public long getPlatoCosto() {
        return platoCosto;
    }

    public void setPlatoCosto(long platoCosto) {
        this.platoCosto = platoCosto;
    }

    public int getCantidadplatos() {
        return cantidadplatos;
    }

    public void setCantidadplatos(int cantidadplatos) {
        this.cantidadplatos = cantidadplatos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getTotalventa() {
        return totalventa;
    }

    public void setTotalventa(Long totalventa) {
        this.totalventa = totalventa;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public Mesas getIdmesa() {
        return idmesa;
    }

    public void setIdmesa(Mesas idmesa) {
        this.idmesa = idmesa;
    }

    public Platos getIdplato() {
        return idplato;
    }

    public void setIdplato(Platos idplato) {
        this.idplato = idplato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorden != null ? idorden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenes)) {
            return false;
        }
        Ordenes other = (Ordenes) object;
        if ((this.idorden == null && other.idorden != null) || (this.idorden != null && !this.idorden.equals(other.idorden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.duglasRos.entities.Ordenes[ idorden=" + idorden + " ]";
    }
    
}
