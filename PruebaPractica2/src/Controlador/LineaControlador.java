/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Linea;
import Modelo.Poligono;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class LineaControlador {
    private List<Linea> listaLineas;
    private Linea seleccionado;
    public LineaControlador(){
        listaLineas=new ArrayList<>();
        seleccionado=null;
    }
    public long  generarid(){
        if(listaLineas.size()>0)     
            return listaLineas.get(listaLineas.size()-1).getId()+1;
        else
            return 1;
    }
    public boolean Crear( String identificador, double longitud, double P1X, double P1Y, double P2X, double P2Y,Poligono poligonos){
        Linea lineas=new Linea(this.generarid(),identificador,longitud,P1X,P1Y,P2X,P2Y,poligonos);
        poligonos.getListaLineas().add(lineas);
        return listaLineas.add(lineas);
    }
    public boolean Crear( String identificador, double longitud, double P1X, double P1Y, double P2X, double P2Y){
        Linea lineas=new Linea(this.generarid(),identificador,longitud,P1X,P1Y,P2X,P2Y);
        return listaLineas.add(lineas);
    }
    public Linea Buscar(String identificador){
        for (Linea Linea : listaLineas) {
            if(Linea.getIdentificador().equals(identificador))
                return Linea;
        }
        return null;
    }
    public boolean Actualizar(String identificador, double longitud, double P1X, double P1Y, double P2X, double P2Y){
        Linea linea= Buscar(identificador);
        if(linea!=null){
            int posicion=listaLineas.indexOf(linea);
            linea.setP1X(P1X);
            linea.setP2X(P2X);
            linea.setP1Y(P1Y);
            linea.setP2Y(P2Y);
            linea.setLongitud(longitud);
            listaLineas.set(posicion, linea);
            return true;
        }
        return false;
    }
    public boolean Eliminar(String identificador){
        Linea linea=Buscar(identificador);
        if(linea!=null){
            linea.getPoligonos().getListaLineas().remove(linea);
            return listaLineas.remove(linea);
        }
        return false;
    }

    public List<Linea> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(List<Linea> listaLineas) {
        this.listaLineas = listaLineas;
    }

    public Linea getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Linea seleccionado) {
        this.seleccionado = seleccionado;
    }
}
