package tools;
import java.util.Scanner;

public class Menu {
    
    private Scanner tec;

    private void mostrarMenu(){
        System.out.println("\n");
        System.out.println("|===========================================================|");
        System.out.println("|                       Menu de Cursos                      |");
        System.out.println("|===========================================================|");

        System.out.println("|1) Buscar un curso                                         |");
        System.out.println("|2) Crear un curso                                          |");
        System.out.println("|3) Editar un curso                                         |");
        System.out.println("|4) Eliminar un curso                                       |");
        System.out.println("|5) Crear descuento                                         |");
        System.out.println("|                                                           |");
        System.out.println("|0) Salir                                                   |");
        System.out.println("|===========================================================|");
        System.out.print("Opcion > ");
    }
    public String leerOpcion(){
        tec = new Scanner(System.in);
        this.mostrarMenu();
        String opcion = tec.nextLine();
        switch(opcion){
            case "1":{
                return "#1";
            }
            case "2":{
                return "#2";
            }
            case "3":{
                return "#3";
            }
            case "4":{
                return "#4";
            }
            case "5":{
                return "#5";
            }
            case "0":{
                return "Salir";
            }
            default:{
                System.out.println("\n");
                System.out.println("|===========================================================|");
                System.out.println("|  !!!! La opcion no se reconoce, intente nuevamente !!!!   |");
                System.out.println("|===========================================================|");
                System.out.println("\n");
                return this.leerOpcion();
            }
        }
    }
}
