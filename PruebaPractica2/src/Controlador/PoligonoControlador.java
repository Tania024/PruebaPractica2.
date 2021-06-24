/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Figura;
import Modelo.Poligono;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PoligonoControlador {
     private List<Poligono> listaPoligonos;
    private Poligono seleccionado;
    public PoligonoControlador(){
        listaPoligonos=new ArrayList<>();
        seleccionado=null;
    }
    public long generarId(){
        if(listaPoligonos.size()>0){ 
            return listaPoligonos.get(listaPoligonos.size()-1).getId()+1;
        }else{
            return 1;
        }
    }
    public boolean Crear( int numLineas){
        Poligono poligonos=new Poligono(this.generarId(), numLineas);
        return listaPoligonos.add(poligonos);
    }
    public boolean Crear( int numLineas, Figura figura){
        Poligono poligono = new Poligono(this.generarId(), numLineas, figura);
        figura.getListapoligonos().add(poligono);
        return listaPoligonos.add(poligono);
    }
    public Poligono Buscar(int numLineas){
        for (Poligono poligono : listaPoligonos) {
            if(poligono.getNumLineas()==numLineas){
                return poligono;
            }
        }
        return null;
    }
    public boolean Actualizar(int numLineas, int numLineasNuevo ){
        Poligono poligono = Buscar(numLineas);
        if (poligono!=null) {
            int posicion=listaPoligonos.indexOf(poligono);
            poligono.setNumLineas(numLineasNuevo);
            listaPoligonos.set(posicion, poligono);
            return true;
        }
        return false;
    }
    public boolean Eliminar(int numLineas){
        Poligono poligono = Buscar(numLineas);
        if(poligono!=null){
            poligono.getFigura().getListapoligonos().remove(poligono);
            listaPoligonos.remove(poligono);
        }
        return false;
    }
    public void Imprimir(){
        listaPoligonos.forEach(poligono -> {
            System.out.println(poligono);
        });
    }

    public List<Poligono> getListaPoligonos() {
        return listaPoligonos;
    }

    public void setListaPoligonos(List<Poligono> listaPoligonos) {
        this.listaPoligonos = listaPoligonos;
    }

    public Poligono getSeleccionado() {
        return seleccionado;
    }

    public void setSelccionado(Poligono selccionado) {
        this.seleccionado = selccionado;
    }
}
