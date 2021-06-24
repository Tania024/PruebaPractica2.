/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.JefeProyecto;
import Modelo.Proyecto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class JefeProyectoControlador {
     private List<JefeProyecto> listaPersonas;
    private JefeProyecto seleccionado;
    public JefeProyectoControlador(){
        listaPersonas=new ArrayList<>();
        
    }
    public long generarID(){
        if(listaPersonas.size()>0){
            return listaPersonas.get(listaPersonas.size()-1).getId()+1;
        }else{
            return 1;
        }
    }
    public boolean Crear(int codigo, String nombre, String direccion, String telefono){
        JefeProyecto persona=new JefeProyecto(this.generarID(), codigo, nombre, direccion, telefono);
        return listaPersonas.add(persona);
    }
    public boolean Crear(int codigo, String nombre, String direccion, String telefono,Proyecto proyecto){
        JefeProyecto persona=new JefeProyecto(this.generarID(), codigo, nombre, direccion, telefono,proyecto);
        proyecto.setJefeProyecto(persona);
        return listaPersonas.add(persona);
    }
    public JefeProyecto Buscar(String nombre){
        for (JefeProyecto persona : listaPersonas) {
            if (persona.getNombre().equals(nombre)) {
                return persona;
            }
        }
        return null;
    }
    public boolean Actualizar(int codigo, String nombre, String direccion,String nombrenuevo, String telefono){
        JefeProyecto persona=Buscar(nombre);
        if (persona!=null) {
            int posicion=listaPersonas.indexOf(persona);
            persona.setNombre(nombrenuevo);
            persona.setDireccion(direccion);
            persona.setTelefono(telefono);
            persona.setCodigo(codigo);
            listaPersonas.set(posicion, persona);
            return true;
        }
        return false;
    }
    public boolean Eliminar (String nombre){
        JefeProyecto persona=Buscar(nombre);
        if (persona!=null) {
            return listaPersonas.remove(persona);
        }
        return false;
    }

    public List<JefeProyecto> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<JefeProyecto> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public JefeProyecto getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(JefeProyecto seleccionado) {
        this.seleccionado = seleccionado;
    }
}
