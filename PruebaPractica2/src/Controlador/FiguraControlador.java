/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Figura;
import Modelo.Plano;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class FiguraControlador {
    private List<Figura> listaFiguras;
    private Figura seleccionado;
    public FiguraControlador(){
        listaFiguras= new ArrayList<>();
        seleccionado=null;
    }
    public long generarID(){
        if(listaFiguras.size()>0){ 
            return listaFiguras.get(listaFiguras.size()-1).getId()+1;
        }else{
            return 1;
        }
    }
    public boolean Crear(String identificador, String nombre, String color,double perimetro, double area){
        Figura figura=new Figura(this.generarID(), identificador, nombre, color,perimetro, area);
        return listaFiguras.add(figura);
    }
    public boolean Crear(String identificador, String nombre, String color, double perimetro, double area, Plano planos){
        Figura figuras=new Figura(this.generarID(), identificador, nombre, color,perimetro, area, planos);
        planos.getFigura().add(figuras);
        return listaFiguras.add(figuras);
    }
    public Figura Buscar(String identificador){
        for (Figura figura : listaFiguras) {
            if (figura.getIdentificador().equals(identificador)) {
                return figura;
            }
        }
        return null;
    }
    public boolean Actualizar(String identificador, String nombre, String color){
        Figura figura=this.Buscar(identificador);
        if (figura!=null) {
            int posicion=listaFiguras.indexOf(figura);
            figura.setIdentificador(identificador);
            figura.setNombre(nombre);
            figura.setColor(color);
            listaFiguras.set(posicion, figura);
            return true;
        }
        return false;
    }
    public boolean Eliminar(String identificador){
        Figura figura=this.Buscar(identificador);
        if (figura!=null) {
            figura.getPlanos().getFigura().remove(figura);
            listaFiguras.remove(figura);
        }
        return false;
    }
    public void Imprimir(){
        listaFiguras.forEach(figura -> {
            System.out.println(figura);
        });
    }

    public List<Figura> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(List<Figura> listaFiguras) {
        this.listaFiguras = listaFiguras;
    }

    public Figura getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Figura seleccionado) {
        this.seleccionado = seleccionado;
    }
}
