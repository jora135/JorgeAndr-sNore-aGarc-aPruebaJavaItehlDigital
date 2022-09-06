package Datos;

import Model.descuento;
import tools.EntradaTeclado;

public class GenDatosDescuento {
    public static String generadorNombreDes(){
        String val = EntradaTeclado.leerString("Ingrese nombre del descuento");
        return val;
    }

    public static String generadorModalidad(){
        System.out.println("Ingrese modalidad del curso:");
        System.out.println("  1) Privado");
        System.out.println("  2) Online");
        System.out.println("  3) OnDemand");
        int val1 = EntradaTeclado.leerInt("Ingrese opcion");
        String val = "";
        if(val1==1){
            val = "Privado";
        }else if(val1==2){
            val = "Online";
        }else if(val1==3){
            val = "OnDemand";
        }
        return val;
    }

    public static String generadorPais(){
        String val = EntradaTeclado.leerString("Ingrese pais para el que aplica el descuento");
        return val;
    }

    public static int generadorDescuento(){
        int val = EntradaTeclado.leerInt("Ingrese descuento del curso");
        return val;
    }

    public static String generadorCurso(){
        String val = EntradaTeclado.leerString("Ingrese nombre del curso");
        return val;
    }

    public static String generadorFechaFinPromo(){
        String val = EntradaTeclado.leerString("Ingrese fecha de finalizacion de la promocion");
        return val;
    }

    public static descuento generarDescuento(){
        descuento genDescuento = new descuento( generadorNombreDes(),
        generadorModalidad(),
        generadorPais(),
        generadorDescuento(),
        generadorCurso(),
        generadorFechaFinPromo());
        return genDescuento;
    }
}
