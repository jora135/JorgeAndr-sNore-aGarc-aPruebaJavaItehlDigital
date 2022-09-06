package Datos;

import Model.modalidad;
import tools.EntradaTeclado;

public class GenDatosModalidad {

    public static String generadorNombreMod(){
        String val = EntradaTeclado.leerString("Ingrese nombre de modalidad");
        return val;
    }

    public static String generadorDescripcionMod(){
        String val = EntradaTeclado.leerString("Ingrese descripcion de modalidad");
        return val;
    }

    public static modalidad generarModalidad(){
        modalidad genModalidad = new modalidad( 
            generadorNombreMod(),
            generadorDescripcionMod());
        return genModalidad;
    }
}
