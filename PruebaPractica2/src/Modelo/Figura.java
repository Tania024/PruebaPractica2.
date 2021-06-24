/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Figura {
    private long id;
    private String identificador;
    private String nombre;
    private String color;
    private double perimetro;
    private double area;
    private List<Poligono> listapoligonos;
    private Plano planos;

    public Figura(long id, String identificador, String nombre, String color, double perimetro, double area) {
        this.id = id;
        this.identificador = identificador;
        this.nombre = nombre;
        this.color = color;
        this.perimetro = perimetro;
        this.area = area;
    }

    public Figura(long id, String identificador, String nombre, String color, double perimetro, double area, Plano planos) {
        this.id = id;
        this.identificador = identificador;
        this.nombre = nombre;
        this.color = color;
        this.perimetro = perimetro;
        this.area = area;
        this.listapoligonos = new ArrayList<>();
        this.planos = planos;
    }
   
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public void setArea(double area) {
        this.area = area;
    }
    
    public double getPerimetro() {
        return perimetro;
    }

    public double getArea() {
        return area;
    }
    
    public List<Poligono> getListapoligonos() {
        return listapoligonos;
    }

    public void setListapoligonos(List<Poligono> listapoligonos) {
        this.listapoligonos = listapoligonos;
    }

    public Plano getPlanos() {
        return planos;
    }

    public void setPlanos(Plano planos) {
        this.planos = planos;
    }

    @Override
    public String toString() {
        return "Figura{" + "id=" + id + ", identificador=" + identificador + ", nombre=" + nombre + ", color=" + color + ", perimetro=" + perimetro + ", area=" + area + ", planos=" + planos + '}';
    }


   
}
