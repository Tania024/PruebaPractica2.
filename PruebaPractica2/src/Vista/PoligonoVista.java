/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.FiguraControlador;
import Controlador.PoligonoControlador;
import Modelo.Poligono;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class PoligonoVista {
    private PoligonoControlador poligonoControlador;
    private FiguraControlador figuraControlador;
    private Scanner teclado;
    public PoligonoVista(FiguraControlador figuraControlador){
        this.figuraControlador=figuraControlador;
        poligonoControlador=new PoligonoControlador();
        teclado=new Scanner(System.in);
        
    }
    public void Menu(){
        int opcion=0;
        do {            
            System.out.println("\n***********POLIGONOS************\n1.Crear\n2.Buscar\n3.Actualizar\n4.Eliminar\n5.Imprimir\n6.Salir");
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
        System.out.println("Ingresar el numero de lineas: ");
        int numLineas=teclado.nextInt();
        boolean resultado=poligonoControlador.Crear(numLineas, figuraControlador.getSeleccionado());
        System.out.println("Creado = "+resultado);
    }
   
   
    public Poligono Buscar(){
        System.out.println("Ingresar el numero de lineas que desea buscar: ");
        int numLineas=teclado.nextInt();
        Poligono poligono=poligonoControlador.Buscar(numLineas);
        System.out.println(poligono);
        return poligono;
    }
    public void Actualizar(){
        System.out.println("Ingresar el numero de lineas que va a actualizar: ");
        int numLineas=teclado.nextInt();
        System.out.println("Ingresar el numero de lineas nuevo: ");
        int numLineasAnt=teclado.nextInt();
        boolean resultado=poligonoControlador.Actualizar(numLineas, numLineasAnt);
        System.out.println("Resultado = "+resultado);
    }
    public void Eliminar(){
        System.out.println("Ingresar el numero de lineas que desea eliminar");
        int numlineas=teclado.nextInt();
        boolean resultado=poligonoControlador.Eliminar(numlineas);
        System.out.println("Eliminado = "+resultado);
    }
    public void Imprimir(){
        for (Poligono poligono : poligonoControlador.getListaPoligonos()) {
            System.out.println(poligono);
        }
    }
    public void AsignarSeleccionado(Poligono poligonos){
        poligonoControlador.setSelccionado(poligonos);
    }

    public PoligonoControlador getPoligonoControlador() {
        return poligonoControlador;
    }

    public void setPoligonosControlador(PoligonoControlador poligonoControlador) {
        this.poligonoControlador = poligonoControlador;
    }

    public FiguraControlador getFiguraControlador() {
        return figuraControlador;
    }

    public void setFiguraControlador(FiguraControlador figuraControlador) {
        this.figuraControlador = figuraControlador;
    }
}
