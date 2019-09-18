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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "mesas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesas.findAll", query = "SELECT m FROM Mesas m")
    , @NamedQuery(name = "Mesas.findByIdmesa", query = "SELECT m FROM Mesas m WHERE m.idmesa = :idmesa")
    , @NamedQuery(name = "Mesas.findByCantidadpersonas", query = "SELECT m FROM Mesas m WHERE m.cantidadpersonas = :cantidadpersonas")})
public class Mesas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmesa")
    private Integer idmesa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadpersonas")
    private int cantidadpersonas;
    @JoinColumn(name = "idubicacion", referencedColumnName = "idubicacion")
    @ManyToOne(optional = false)
    private Ubicaciones idubicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmesa")
    private List<Factura> facturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmesa")
    private List<Ordenes> ordenesList;

    public Mesas() {
    }

    public Mesas(Integer idmesa) {
        this.idmesa = idmesa;
    }

    public Mesas(Integer idmesa, int cantidadpersonas) {
        this.idmesa = idmesa;
        this.cantidadpersonas = cantidadpersonas;
    }

    public Integer getIdmesa() {
        return idmesa;
    }

    public void setIdmesa(Integer idmesa) {
        this.idmesa = idmesa;
    }

    public int getCantidadpersonas() {
        return cantidadpersonas;
    }

    public void setCantidadpersonas(int cantidadpersonas) {
        this.cantidadpersonas = cantidadpersonas;
    }

    public Ubicaciones getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(Ubicaciones idubicacion) {
        this.idubicacion = idubicacion;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
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
        hash += (idmesa != null ? idmesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesas)) {
            return false;
        }
        Mesas other = (Mesas) object;
        if ((this.idmesa == null && other.idmesa != null) || (this.idmesa != null && !this.idmesa.equals(other.idmesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.duglasRos.entities.Mesas[ idmesa=" + idmesa + " ]";
    }
    
}
