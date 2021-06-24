/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Plano {
    private long id;
    private int identificacion;
    private Date fechaEntrega;
    private int arquitectos;
    private int numFiguras;
    private List<Figura> figura;
    private Proyecto proyecto;

    public Plano(long id, int identificacion, Date fechaEntrega, int arquitectos, int numFiguras) {
        this.id = id;
        this.identificacion = identificacion;
        this.fechaEntrega = fechaEntrega;
        this.arquitectos = arquitectos;
        this.numFiguras = numFiguras;
    }

    public Plano(long id, int identificacion, Date fechaEntrega, int arquitectos, int numFiguras, Proyecto proyecto) {
        this.id = id;
        this.identificacion = identificacion;
        this.fechaEntrega = fechaEntrega;
        this.arquitectos = arquitectos;
        this.numFiguras = numFiguras;
        this.figura = new ArrayList<>();
        this.proyecto = proyecto;
    }


    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getArquitectos() {
        return arquitectos;
    }

    public void setArquitectos(int arquitectos) {
        this.arquitectos = arquitectos;
    }

    public int getNumFiguras() {
        return numFiguras;
    }

    public void setNumFiguras(int numFiguras) {
        this.numFiguras = numFiguras;
    }

    public List<Figura> getFigura() {
        return figura;
    }

    public void setFiguras(List<Figura> figura) {
        this.figura = figura;
    }
    
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Plano{" + "id=" + id + ", identificacion=" + identificacion + ", fechaEntrega=" + fechaEntrega + ", arquitectos=" + arquitectos + ", numFiguras=" + numFiguras + ", proyecto=" + proyecto + '}';
    }


    
}
