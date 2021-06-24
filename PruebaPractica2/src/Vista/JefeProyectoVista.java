/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.JefeProyectoControlador;
import Modelo.JefeProyecto;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class JefeProyectoVista {
    
    private JefeProyectoControlador jefeProyectoControlador;
    private Scanner teclado;
    public JefeProyectoVista(){
        jefeProyectoControlador = new JefeProyectoControlador();
        teclado=new Scanner(System.in);
    }
    public void Menu(){
        int opcion=0;
        do {            
            System.out.println("\n***************JEFE DEL PROYECTO*************\n1.Crear\n2.Buscar\n3.Actualizar\n4.Eliminar\n5.Imprimir\n6.Salir");
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
        System.out.println("Ingresar el codigo del jefe de proyecto: ");
        int codigo=teclado.nextInt();
        System.out.println("Ingresar el nombre : ");
        String nombre=teclado.next();
        System.out.println("Ingresar la direccion : ");
        String direccion=teclado.next();
        System.out.println("Ingresar el telefono : ");
        String telefono=teclado.next();
        boolean resultado=jefeProyectoControlador.Crear(codigo, nombre, direccion, telefono);
        System.out.println("Creado = "+resultado);
    }
    
    public JefeProyecto Buscar(){
        System.out.println("Ingresar el nombre que desea buscar: ");
        String nombre=teclado.next();
        JefeProyecto persona=jefeProyectoControlador.Buscar(nombre);
        System.out.println(persona);
        jefeProyectoControlador.setSeleccionado(persona);
        return persona;
    }
    public void Actualizar(){
        
        System.out.println("Ingresar el nombre que desea actualizar: ");
        String nombre=teclado.next();
        System.out.println("Ingresar el nuevo nombre ");
        String nombrenuevo=teclado.next();
        System.out.println("Ingresar el codigo nuevo : ");
        int codigo=teclado.nextInt();
        System.out.println("Ingresar la direccion : ");
        String direccion=teclado.next();
        System.out.println("Ingresar el telefono : ");
        String telefono=teclado.next();
        boolean resultado=jefeProyectoControlador.Actualizar(codigo, nombre, direccion, nombrenuevo, telefono);
        System.out.println("Resultado = "+resultado);
    }
    public void Eliminar(){
        System.out.println("Ingresar el nombre que desea eliminar: ");
        String nombre=teclado.next();
        boolean resultado=jefeProyectoControlador.Eliminar(nombre);
        System.out.println("Eliminado = "+resultado);
    }
    public void Imprimir(){
        for (JefeProyecto listaPersona : jefeProyectoControlador.getListaPersonas()) {
            System.out.println(listaPersona);
        }
    }
    public void asignarSeleccionado(JefeProyecto jefe){
        jefeProyectoControlador.setSeleccionado(jefe);
    }

    public JefeProyectoControlador getJefeProyectoControlador() {
        return jefeProyectoControlador;
    }

    public void setJefeProyectoControlador(JefeProyectoControlador jefeProyectoControlador) {
        this.jefeProyectoControlador = jefeProyectoControlador;
    }
}
