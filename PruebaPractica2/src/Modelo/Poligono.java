/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Poligono {
    private long id;
    private int numLineas;
    private List<Linea> listaLineas;
    private Figura figura;

    public Poligono(long id, int numLineas) {
        this.id = id;
        this.numLineas = numLineas;
    }

    public Poligono(long id, int numLineas, Figura figura) {
        this.id = id;
        this.numLineas = numLineas;
        this.listaLineas = new ArrayList<>();
        this.figura = figura;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumLineas() {
        return numLineas;
    }

    public void setNumLineas(int numLineas) {
        this.numLineas = numLineas;
    }

    public List<Linea> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(List<Linea> listaLineas) {
        this.listaLineas = listaLineas;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    @Override
    public String toString() {
        return "Poligono{" + "id=" + id + ", numLineas=" + numLineas + ", figura=" + figura + '}';
    }


}
