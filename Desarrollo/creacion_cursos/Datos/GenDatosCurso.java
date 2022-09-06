package Datos;

import Model.Curso;
import tools.EntradaTeclado;


public class GenDatosCurso {

    public static String generadorNombre(){
        String val = EntradaTeclado.leerString("Ingrese nombre del curso");
        return val;
    }

    public static int generadorCosto(){
        int val = EntradaTeclado.leerInt("Ingrese costo del curso");
        return val;
    }

    public static String generadorDescripcion(){
        String val = EntradaTeclado.leerString("Ingrese descripcion del curso");
        return val;
    }

    public static int generadorHoras_duracion(){
        int val = EntradaTeclado.leerInt("Ingrese horas de duracion del curso");
        return val;
    }

    public static String generadorDirigido_a(){
        String val = EntradaTeclado.leerString("Ingrese a quien es dirigido el curso");
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
    

    public static Curso generarCurso(){
        Curso genCurso = new Curso( 
                                    generadorNombre(),
                                    generadorCosto(),
                                    generadorDescripcion(),
                                    generadorHoras_duracion(),
                                    generadorDirigido_a(),
                                    generadorModalidad());
        return genCurso;
    }

}
