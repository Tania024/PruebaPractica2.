/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.LineaControlador;
import Controlador.PoligonoControlador;
import Modelo.Linea;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class LineaVista {
    private PoligonoControlador poligonosControlador;
    private LineaControlador lineasControlador;
    private Scanner teclado;
    public LineaVista(PoligonoControlador poligonosControlador){
        this.poligonosControlador=poligonosControlador;
        lineasControlador=new LineaControlador();
        teclado=new Scanner(System.in);
    }
    public void Menu(){
        int opcion=0;
        do {            
            System.out.println("\n****************LINEAS*************\n1.Crear\n2.Buscar\n3.Actualizar\n4.Eliminar\n5.Imprimir\n6.Salir");
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
        System.out.println("Ingresar el identificador de las líneas: ");
        String identificador=teclado.next();
        System.out.println("Ingresar el punto inicial del eje X: ");
        double P1X=teclado.nextDouble();
        System.out.println("Ingresar el punto final del eje X: ");
        double P2X=teclado.nextDouble();
        System.out.println("Ingresar el punto inicial del eje Y: ");
        double P1Y=teclado.nextDouble();
        System.out.println("Ingresar el punto final del eje Y: ");
        double P2Y=teclado.nextDouble();
        double longitud=this.longitud(P1X, P2X, P1Y, P2Y);
        boolean resultado=lineasControlador.Crear(identificador, longitud, P1X, P1Y, P2X, P2Y,poligonosControlador.getSeleccionado());
        System.out.println("Creado = "+resultado);
    }
    public double longitud(double P1X,double P2X,double P1Y,double P2Y){
        double val=Math.pow((P2Y-P1Y),2)+Math.pow((P2X-P1X),2);
        double longi=Math.sqrt(val);
        return longi;
    }
    public Linea Buscar(){
        System.out.println("Ingresar el identificador que desea buscar: ");
        String identificador=teclado.next();
        Linea linea=lineasControlador.Buscar(identificador);
        System.out.println(linea);
        return linea;
    }
    public void Actualizar(){
        System.out.println("Ingresar el identificador que desea actualizar");
        String identificador=teclado.next();
        System.out.println("Ingresar el punto inicial del eje X: ");
        double P1X=teclado.nextDouble();
        System.out.println("Ingresar el punto final del eje X: ");
        double P2X=teclado.nextDouble();
        System.out.println("Ingresar el punto inicial del eje X: ");
        double P1Y=teclado.nextDouble();
        System.out.println("Ingresar el punto final del eje Y: ");
        double P2Y=teclado.nextDouble();
        double longitud=this.longitud(P1X, P2X, P1Y, P2Y);
        boolean resultado=lineasControlador.Actualizar(identificador, longitud, P1X, P1Y, P2X, P2Y);
        System.out.println("Resultado = "+resultado);
    }
    public void Eliminar(){
        System.out.println("Ingresar el identificador que desea eliminar: ");
        String identificador=teclado.next();
        boolean resultado=lineasControlador.Eliminar(identificador);
        System.out.println("Eliminado = "+resultado);
    }
    public void Imprimir(){
        for (Linea linea : lineasControlador.getListaLineas()) {
            System.out.println(linea);
        }
    }
}
