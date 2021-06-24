/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.FiguraControlador;
import Controlador.PlanoControlador;
import Modelo.Figura;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class FiguraVista {
    private FiguraControlador figuraControlador;
    private PlanoControlador planosControlador;
    private Scanner teclado;
    public FiguraVista(PlanoControlador planoControlador){
        this.planosControlador=planoControlador;
        figuraControlador=new FiguraControlador();
        teclado=new Scanner(System.in);
    }
    public void Menu(){
        int opcion=0;
        do {            
            System.out.println("\n****************FIGURAS*******************\n1.Crear\n2.Buscar\n3.Actualizar\n4.Eliminar\n5.Imprimir\n6.Salir");
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
        System.out.println("Ingresar el identificador de la figura: ");
        String identificador=teclado.next();
        System.out.println("Ingresar el nombre: ");
        String nombre=teclado.next();
        System.out.println("Ingresar el color: ");
        String color=teclado.next();
        boolean resultado=figuraControlador.Crear(identificador, nombre, color, 50, 800, planosControlador.getSeleccionado());
        System.out.println("Creado = "+resultado);
    }
   
   
    public Figura Buscar(){
        System.out.println("Ingresar el identificador que desea buscar: ");
        String identificador=teclado.next();
        Figura figura=figuraControlador.Buscar(identificador);
        System.out.println(figura);
        return figura;
    }
    public void Actualizar(){
        System.out.println("Ingresar el identificador que desea actualizar: ");
        String identificador=teclado.next();
        System.out.println("Ingresar el nuevo nombre: ");
        String nombre=teclado.next();
        System.out.println("Ingresar el nuevo color: ");
        String color=teclado.next();
        boolean resultado=figuraControlador.Actualizar(identificador, nombre, color);
        System.out.println("Resultado = "+resultado);
    }
    public void Eliminar(){
        System.out.println("Ingresar el identificador que desea eliminar: ");
        String identificador=teclado.next();
        boolean resultado=figuraControlador.Eliminar(identificador);
        System.out.println("Eliminado = "+resultado);
    }
    public void Imprimir(){
        for (Figura figuras :figuraControlador.getListaFiguras()) {
            System.out.println(figuras);
        }
    }
    public void asignarSeleccionado(Figura figura){
        figuraControlador.setSeleccionado(figura);
    }

    public FiguraControlador getFiguraControlador() {
        return figuraControlador;
    }

    public void setFiguraControlador(FiguraControlador figuraControlador) {
        this.figuraControlador = figuraControlador;
    }

    public PlanoControlador getPlanosControlador() {
        return planosControlador;
    }

    public void setPlanosControlador(PlanoControlador planosControlador) {
        this.planosControlador = planosControlador;
    }
    
}
