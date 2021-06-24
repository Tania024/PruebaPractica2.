/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Figura;
import Modelo.JefeProyecto;
import Modelo.Plano;
import Modelo.Poligono;
import Modelo.Proyecto;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class VistaGeneral {
    private LineaVista lineaVista;
    private PoligonoVista poligonoVista;
    private FiguraVista figuraVista;
    private PlanoVista planosVista;
    private ProyectoVista proyectoVista;
    private JefeProyectoVista jefeProyectoVista;
    private Scanner teclado;
    public VistaGeneral(){
        jefeProyectoVista=new JefeProyectoVista();
        proyectoVista=new ProyectoVista(jefeProyectoVista.getJefeProyectoControlador());
        planosVista=new PlanoVista(proyectoVista.getProyectoControlador());
        figuraVista=new FiguraVista(planosVista.getPlanoControlador());
        poligonoVista=new PoligonoVista(figuraVista.getFiguraControlador());
        lineaVista=new LineaVista(poligonoVista.getPoligonoControlador());
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int op=0;
        do{
            System.out.println("SELECCIONE UNA OPCIÓN");
            System.out.println("1.JEFE DEL PROYECTO");
            System.out.println("2.PROYECTO");
            System.out.println("3.PLANO");
            System.out.println("4.FIGURA");
            System.out.println("5.POLIGONOS");
            System.out.println("6.LINEAS");
            System.out.println("7.SALIR");
            op=teclado.nextInt();
            switch(op){
                case 1:
                    jefeProyectoVista.Menu();break;
                case 2:
                    this.Proyecto();break;
                case 3:
                    this.Planos();break;
                case 4:
                    this.Figura();break;
                case 5:
                    this.Poligono();break;
                case 6:
                    this.Linea();break;
            }
        }while(op<7);
    }
    public void Proyecto(){
        System.out.println("Jefe del proyecto");
        JefeProyecto jefe=jefeProyectoVista.Buscar();
        if (jefe!=null) {
            proyectoVista.Menu();
        }else{
            System.out.println("Resultado no encontrado");
            this.Proyecto();
        }
    }
    public void Planos(){
        System.out.println("Ingreso de datos del proyecto para administrar los planos: ");
        Proyecto proyecto=proyectoVista.Buscar();
        if (proyecto!=null) {
            proyectoVista.asignarSeleccionado(proyecto);
            planosVista.Menu();
        }else{
            System.out.println("Resultado no encontrado");
            this.Planos();
        }
    }
    public void Figura(){
        System.out.println("Ingreso de datos del plano para adminsitrar la figura");
        Plano planos=planosVista.Buscar();
        if (planos!=null) {
            planosVista.asignarSeleccionado(planos);
            figuraVista.Menu();
        }else{
            System.out.println("Resultado no encontrado");
            this.Figura();
        }
    }
    public void Poligono(){
        System.out.println("Ingreso de datos de la figura para administrar los poligonos");
        Figura figura=figuraVista.Buscar();
        if (figura!=null) {
            figuraVista.asignarSeleccionado(figura);
            poligonoVista.Menu();
        }else{
            System.out.println("Resultado no encontrado");
            this.Poligono();
        }
    }
    public void Linea(){
        System.out.println("Ingreso de datos del poligono para administrar las lineas");
        Poligono poligono=poligonoVista.Buscar();
        if (poligono!=null) {
            poligonoVista.AsignarSeleccionado(poligono);
            lineaVista.Menu();
        }else{
            System.out.println("Resultado no encontrado");
            this.Linea();
        }
    }
}
