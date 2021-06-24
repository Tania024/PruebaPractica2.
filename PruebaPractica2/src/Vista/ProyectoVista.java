/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.JefeProyectoControlador;
import Controlador.ProyectoControlador;
import Modelo.Proyecto;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class ProyectoVista {
    private ProyectoControlador proyectoControlador;
    private JefeProyectoControlador jefeProyectoControlador;
    private Scanner teclado;
    public ProyectoVista(JefeProyectoControlador jefeProyectoControlador){
        this.jefeProyectoControlador=jefeProyectoControlador;
        proyectoControlador=new ProyectoControlador();
        teclado=new Scanner(System.in);
    }public void Menu(){
        int opcion=0;
        do {            
            System.out.println("\n************PROYECTOS***************\n1.Crear\n2.Buscar\n3.Actualizar\n4.Eliminar\n5.Imprimir\n6.Salir");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1:
                    this.Crear();break;
                case 2:
                    this.Buscar();break;
                case 3:
                    this.Actualizar();break;
                case 4:
                    this.Eliminar();break;
                case 5:
                    this.Imprimir();break;
            }
        } while (opcion<6);
    }
    public void Crear(){
        System.out.println("Ingresar el codigo del proyecto: ");
        String codigo=teclado.next();
        System.out.println("Ingresar el nombre : ");
        String nombre=teclado.next();
        boolean resultado=proyectoControlador.Crear(codigo, nombre, jefeProyectoControlador.getSeleccionado());
        System.out.println("Creado = "+resultado);
    }
    
    public Proyecto Buscar(){
        System.out.println("Ingresar el nombre : ");
        String nombre=teclado.next();
        Proyecto proyecto=proyectoControlador.Buscar(nombre);
        System.out.println(proyecto);
        return proyecto;
    }
    public void Actualizar(){
        System.out.println("Ingresar el nombre que desea actualizar: ");
        String nombre=teclado.next();
        System.out.println("Ingresar el nuevo nombre : ");
        String nombrenuev=teclado.next();
        System.out.println("Ingresar el codigo nuevo : ");
        String codigo=teclado.next();
        boolean resultado=proyectoControlador.Actualizar(codigo, nombre, nombrenuev);
        System.out.println("Resultado = "+resultado);
    }
    public void Eliminar(){
        System.out.println("Ingresar el nombre que desea eliminar: ");
        String nombre=teclado.next();
        boolean resultado=proyectoControlador.Eliminar(nombre);
        System.out.println("Eliminado = "+resultado);
    }
    public void Imprimir(){
        for (Proyecto proyecto : proyectoControlador.getListaProyectos()) {
            System.out.println(proyecto);
        }
    }
    public void asignarSeleccionado(Proyecto proyecto){
        proyectoControlador.setSeleccionado(proyecto);
    }

    public ProyectoControlador getProyectoControlador() {
        return proyectoControlador;
    }

    public void setProyectoControlador(ProyectoControlador proyectoControlador) {
        this.proyectoControlador = proyectoControlador;
    }

    public JefeProyectoControlador getJefeProyectoControlador() {
        return jefeProyectoControlador;
    }

    public void setJefeProyectoControlador(JefeProyectoControlador jefeProyectoControlador) {
        this.jefeProyectoControlador = jefeProyectoControlador;
    }
}
