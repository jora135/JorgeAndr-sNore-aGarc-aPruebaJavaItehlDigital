import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import Datos.GenDatosCurso;
import Datos.GenDatosDescuento;
import Datos.GenDatosModalidad;
import Model.Curso;
import Model.Curso1;
import Model.descuento;
import Model.descuento1;
import Model.modalidad;
import Model.modalidad1;
import tools.EntradaTeclado;
import tools.Menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cursosrespuesta {
    
    static ArrayList<Curso1> datos = new ArrayList<Curso1>();
    static ArrayList<descuento1> datosm = new ArrayList<descuento1>();
    static ArrayList<modalidad1> datosmod = new ArrayList<modalidad1>();
    String[] lineas = null;
    String[] lineas1 = null;
    String[] lineas2 = null;
    private final String USER_AGENT = "Mozilla/5.0"; //privado constante string nombre = estandar de mozila/5.0

    public static void main(String[] arg) throws Exception {   //control de errores (throws Exception)
        
        cursosrespuesta http = new cursosrespuesta();
        
        Menu funMenu = new Menu();

        while(true){
            String opcionUsuario = funMenu.leerOpcion();

            switch (opcionUsuario){
                case "#1":{ 
                    http.sendGetCurso1();
                    http.sendGetDescuento1();
                    http.sendGetModalidad1();
                    case1();
                    System.out.println("\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");
                    break;
                }
                case "#2":{    
                    Curso valorescurso = GenDatosCurso.generarCurso();
                    http.sendPostCurso(valorescurso);
                    System.out.println("\n");
                    descuento valoresdescuento = GenDatosDescuento.generarDescuento();
                    http.sendPostDescuento1(valoresdescuento);
                    System.out.println("\n");
                    modalidad valoresmodalidad = GenDatosModalidad.generarModalidad();
                    http.sendPostModalidad1(valoresmodalidad);
                    System.out.println("\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");
                    break;
                }
                case "#3":{  
                    int id = EntradaTeclado.leerInt("Ingrese id del curso a actualizar");
                    Curso valorescurso = GenDatosCurso.generarCurso();
                    http.sendPutCurso(id, valorescurso);
                    System.out.println("\n");
                    descuento valoresdescuento = GenDatosDescuento.generarDescuento();
                    http.sendPutDescuento1(id, valoresdescuento);
                    System.out.println("\n");
                    modalidad valoresmodalidad = GenDatosModalidad.generarModalidad();
                    http.sendPutModalidad1(id, valoresmodalidad);
                    System.out.println("\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");
                    break;
                }
                case "#4":{ 
                    int id = EntradaTeclado.leerInt("Ingrese id del curso a eliminar");
                    http.sendDeleteCurso(id);
                    http.sendDeleteDescuento1(id);
                    http.sendDeleteModalidad1(id);
                    System.out.println("\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");     
                    break;
                }
                case "#5":{ 
                    http.case5();
                    System.out.println("\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");     
                    break;
                }
                case "Salir":{
                    System.out.println("Saliste Del Menu, Gracias!!!");
                    return;
                }
            }

        }

        //==================================================================================

    }

    private void case5() throws Exception{
        System.out.println("\n");
        cursosrespuesta http = new cursosrespuesta();
        System.out.println("A que curso desea activar descuento:");
        int id = EntradaTeclado.leerInt("Ingrese id de curso");
        for(int i=0;i<datos.size(); i++){
            if(datos.get(id-1).getModalidad()=="Privado"){
                Curso valorescurso = GenDatosCurso.generarCurso();
                http.sendPostCurso(valorescurso);
                http.sendDeleteCurso(id);
                System.out.println("\n");
                descuento valoresdescuento = GenDatosDescuento.generarDescuento();
                http.sendPostDescuento1(valoresdescuento);
                http.sendDeleteDescuento1(id);
                System.out.println("\n");
                modalidad valoresmodalidad = GenDatosModalidad.generarModalidad();
                http.sendPostModalidad1(valoresmodalidad); 
                http.sendDeleteModalidad1(id);   
            }
        } 
        
    }

    private static void case1(){
        System.out.println("\n");
        
        System.out.println("Que modalidad desea filtrar:");
        System.out.println("  0) Todos los cursos");
        System.out.println("  1) Privado");
        System.out.println("  2) Online");
        System.out.println("  3) OnDemand");
        int opc = EntradaTeclado.leerInt("Ingrese opcion");
        
            //System.out.println(datos.get(i));
            
        if (opc==0){
            for(int i=0;i<datos.size(); i++){
                System.out.println(datos.get(i));
                System.out.println(datosm.get(i));
                System.out.println(datosmod.get(i));
            }
        }
        //String str = Arrays.toString(datos.get(i).getModalidad().toCharArray());
        
        if (opc==1){
            for(int i=0;i<datos.size(); i++){
                String str = String.join("",datos.get(i).getModalidad());
                String str1 = String.join("","Privado");
                if (str==str1){
                    System.out.println(datos.get(i));
                    System.out.println(datosm.get(i));
                    System.out.println(datosmod.get(i));
                }
            }
        }
        if (opc==2){
            for(int i=0;i<datos.size(); i++){
                String str = String.join("",datos.get(i).getModalidad());
                if (str=="Online"){
                    System.out.println(datos.get(i));
                    System.out.println(datosm.get(i));
                    System.out.println(datosmod.get(i));
                }
            }
        }
        if (opc==3){
            for(int i=0;i<datos.size(); i++){
                String str = String.join("",datos.get(i).getModalidad());
                if (str=="OnDemand"){
                    System.out.println(datos.get(i));
                    System.out.println(datosm.get(i));
                    System.out.println(datosmod.get(i));
                }
            }
        }
        
    }

    private void sendGetCurso1() throws Exception {
        String url = "http://localhost:9080/api/cursos/";

        URL objNet = new URL(url);
        HttpURLConnection conexion = (HttpURLConnection) objNet.openConnection();

        conexion.setRequestMethod("GET");
        conexion.addRequestProperty("User-Agent", USER_AGENT);
            
        // mostrar los datos de la respuesta
        BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String lineaEntrada = entrada.readLine();
        
        // System.out.println(lineaEntrada); //tupla de todos los datos de base de datos
        // System.out.println("===================================================================================================================================================");

        entrada.close();

        lineas = lineaEntrada.split("}");
        
        for(int i=0; i<lineas.length-1; i++){
            lineas[i] = lineas[i].substring(2);
            String[] campos = lineas[i].split(",");

            String[] columnas = campos[0].split(":");
            int id = Integer.parseInt(columnas[1]);
            

            columnas = campos[1].split(":");
            String nombre = columnas[1].substring(1, columnas[1].length()-1);
            

            columnas = campos[2].split(":");
            int costo = Integer.parseInt(columnas[1]);
            

            columnas = campos[3].split(":");
            String descripcion = columnas[1].substring(1,columnas[1].length()-1);
            

            columnas = campos[4].split(":");
            int horas_duracion = Integer.parseInt(columnas[1]);
            

            columnas = campos[5].split(":");
            String dirigido_a = columnas[1].substring(1,columnas[1].length()-1);
            

            columnas = campos[6].split(":");
            String modalidad = columnas[1].substring(1,columnas[1].length()-1);
            

            datos.add(new Curso1(id, nombre, costo, descripcion, horas_duracion, dirigido_a, modalidad));
        }
    }

    private void sendPostCurso(Curso valorescurso) throws Exception{
        String url = "http://localhost:9080/api/cursos";

        //establezco conexion 
        URL objNet = new URL(url);
        HttpURLConnection conexion = (HttpURLConnection) objNet.openConnection();

        conexion.setRequestMethod("POST"); //metodo get que voy a cargar
        conexion.addRequestProperty("User_Agent", USER_AGENT);//añado la solicitud (le mando llave y valor)
        conexion.setRequestProperty("Accept-Language", "en-US, es, en;q=0.5"); //estandar 0.5 (cierta libertad al escribir) //lenguaje que acepto
    
        String urlParameters = valorescurso+"";

        //envio de solicitud
        conexion.setDoOutput(true);
        DataOutputStream salida= new DataOutputStream(conexion.getOutputStream());
        salida.writeBytes(urlParameters);
        salida.flush(); //empaqueta con el tamaño del protocolo http de 32k
        salida.close();

        //codigo de error o de exito que tiene

        // int codigoRespuesta = conexion.getResponseCode(); // es cuando sale 200 o 400 o 500 para ver si se hizo con exito o no
    
        // System.out.println("\nUsando metodo POST en: " + url);
        // System.out.println("\nParametros: " + urlParameters);
        // System.out.println("Codigo de respuesta " + codigoRespuesta);
        // System.out.println("\n ==============================");
        // System.out.println(valorescurso);

    }

    private void sendPutCurso(int valorid, Curso valor ) throws Exception{
        sendPostCurso(valor);
        sendDeleteCurso(valorid);
    }

    private void sendDeleteCurso(int valor) throws Exception{
        String url = "http://localhost:9080/api/cursos/"+valor;

        //establezco conexion 
        URL objNet = new URL(url);
        HttpURLConnection conexion = (HttpURLConnection) objNet.openConnection();

        conexion.setRequestMethod("DELETE"); //metodo get que voy a cargar
        conexion.addRequestProperty("User_Agent", USER_AGENT);//añado la solicitud (le mando llave y valor)
        conexion.setRequestProperty("Accept-Language", "en-US, es, en;q=0.5"); //estandar 0.5 (cierta libertad al escribir) //lenguaje que acepto
    
        String urlParameters = valor+"";

        //envio de solicitud
        conexion.setDoOutput(true);
        DataOutputStream salida= new DataOutputStream(conexion.getOutputStream());
        salida.writeBytes(urlParameters);
        salida.flush(); //empaqueta con el tamaño del protocolo http de 32k
        salida.close();

        //codigo de error o de exito que tiene

        // int codigoRespuesta = conexion.getResponseCode(); // es cuando sale 200 o 400 o 500 para ver si se hizo con exito o no
    
        // System.out.println("\nUsando metodo POST en: " + url);
        // System.out.println("\nParametros: " + urlParameters);
        // System.out.println("Codigo de respuesta " + codigoRespuesta);
        // System.out.println("\n ==============================");
        // System.out.println(valor);
    }

    //======================================================================================================================================

    public void sendGetDescuento1() throws Exception {
        String url = "http://localhost:9080/api/descuento/";

        URL objNet = new URL(url);
        HttpURLConnection conexion = (HttpURLConnection) objNet.openConnection();

        conexion.setRequestMethod("GET");
        conexion.addRequestProperty("User-Agent", USER_AGENT);
            
        // mostrar los datos de la respuesta
        BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String lineaEntrada = entrada.readLine();
        
        // System.out.println(lineaEntrada); //tupla de todos los datos de base de datos
        // System.out.println("===================================================================================================================================================");

        entrada.close();

        lineas1 = lineaEntrada.split("}");
        
        for(int i=0; i<lineas1.length-1; i++){
            lineas1[i] = lineas1[i].substring(2);
            String[] campos = lineas1[i].split(",");

            String[] columnas = campos[0].split(":");
            int id = Integer.parseInt(columnas[1]);
            // System.out.println(id);

            columnas = campos[1].split(":");
            String nombre_des = columnas[1].substring(1, columnas[1].length()-1);
            // System.out.println(nombre_des);


            columnas = campos[2].split(":");
            String modalidad = columnas[1].substring(1, columnas[1].length()-1);
            // System.out.println(modalidad);

            columnas = campos[3].split(":");
            String pais = columnas[1].substring(1, columnas[1].length()-1);
            // System.out.println(pais);

            columnas = campos[4].split(":");
            int descuento = Integer.parseInt(columnas[1]);
            // System.out.println(descuento);

            columnas = campos[5].split(":");
            String curso = columnas[1].substring(1,columnas[1].length()-1);
            // System.out.println(curso);

            columnas = campos[6].split(":");
            String fecha_fin_promo = columnas[1].substring(1,columnas[1].length()-1);
            // System.out.println(fecha_fin_promo);

            datosm.add(new descuento1(id, nombre_des, modalidad, pais, descuento, curso, fecha_fin_promo));
        }
    }

    public void sendPostDescuento1(descuento valorescurso) throws Exception{
        String url = "http://localhost:9080/api/descuento";

        //establezco conexion 
        URL objNet = new URL(url);
        HttpURLConnection conexion = (HttpURLConnection) objNet.openConnection();

        conexion.setRequestMethod("POST"); //metodo get que voy a cargar
        conexion.addRequestProperty("User_Agent", USER_AGENT);//añado la solicitud (le mando llave y valor)
        conexion.setRequestProperty("Accept-Language", "en-US, es, en;q=0.5"); //estandar 0.5 (cierta libertad al escribir) //lenguaje que acepto
    
        String urlParameters = valorescurso+"";

        //envio de solicitud
        conexion.setDoOutput(true);
        DataOutputStream salida= new DataOutputStream(conexion.getOutputStream());
        salida.writeBytes(urlParameters);
        salida.flush(); //empaqueta con el tamaño del protocolo http de 32k
        salida.close();

        //codigo de error o de exito que tiene

        // int codigoRespuesta = conexion.getResponseCode(); // es cuando sale 200 o 400 o 500 para ver si se hizo con exito o no
    
        // System.out.println("\nUsando metodo POST en: " + url);
        // System.out.println("\nParametros: " + urlParameters);
        // System.out.println("Codigo de respuesta " + codigoRespuesta);
        // System.out.println("\n ==============================");
        // System.out.println(valorescurso);

    }

    public void sendPutDescuento1(int valorid, descuento valor ) throws Exception{
        sendPostDescuento1(valor);
        sendDeleteDescuento1(valorid);
    }

    public void sendDeleteDescuento1(int valor) throws Exception{
        String url = "http://localhost:9080/api/descuento/"+valor;

        //establezco conexion 
        URL objNet = new URL(url);
        HttpURLConnection conexion = (HttpURLConnection) objNet.openConnection();

        conexion.setRequestMethod("DELETE"); //metodo get que voy a cargar
        conexion.addRequestProperty("User_Agent", USER_AGENT);//añado la solicitud (le mando llave y valor)
        conexion.setRequestProperty("Accept-Language", "en-US, es, en;q=0.5"); //estandar 0.5 (cierta libertad al escribir) //lenguaje que acepto
    
        String urlParameters = valor+"";

        //envio de solicitud
        conexion.setDoOutput(true);
        DataOutputStream salida= new DataOutputStream(conexion.getOutputStream());
        salida.writeBytes(urlParameters);
        salida.flush(); //empaqueta con el tamaño del protocolo http de 32k
        salida.close();

        //codigo de error o de exito que tiene

        // int codigoRespuesta = conexion.getResponseCode(); // es cuando sale 200 o 400 o 500 para ver si se hizo con exito o no
    
        // System.out.println("\nUsando metodo POST en: " + url);
        // System.out.println("\nParametros: " + urlParameters);
        // System.out.println("Codigo de respuesta " + codigoRespuesta);
        // System.out.println("\n ==============================");
        // System.out.println(valor);
    }


    //=========================================================================================================================

    public void sendGetModalidad1() throws Exception {
        String url = "http://localhost:9080/api/modalidad/";

        URL objNet = new URL(url);
        HttpURLConnection conexion = (HttpURLConnection) objNet.openConnection();

        conexion.setRequestMethod("GET");
        conexion.addRequestProperty("User-Agent", USER_AGENT);
            
        // mostrar los datos de la respuesta
        BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String lineaEntrada = entrada.readLine();
        
        // System.out.println(lineaEntrada); //tupla de todos los datos de base de datos
        // System.out.println("===================================================================================================================================================");

        entrada.close();

        lineas2 = lineaEntrada.split("}");
        
        for(int i=0; i<lineas2.length-1; i++){
            lineas2[i] = lineas2[i].substring(2);
            String[] campos = lineas2[i].split(",");

            String[] columnas = campos[0].split(":");
            int id = Integer.parseInt(columnas[1]);
            // System.out.println(id);

            columnas = campos[1].split(":");
            String nombre_mod = columnas[1].substring(1, columnas[1].length()-1);
            // System.out.println(nombre_mod);


            columnas = campos[2].split(":");
            String descripcion_mod = columnas[1].substring(1, columnas[1].length()-1);
            // System.out.println(descripcion_mod);

            datosmod.add(new modalidad1(id, nombre_mod, descripcion_mod));
        }
    }

    public void sendPostModalidad1(modalidad valorescurso) throws Exception{
        String url = "http://localhost:9080/api/modalidad";

        //establezco conexion 
        URL objNet = new URL(url);
        HttpURLConnection conexion = (HttpURLConnection) objNet.openConnection();

        conexion.setRequestMethod("POST"); //metodo get que voy a cargar
        conexion.addRequestProperty("User_Agent", USER_AGENT);//añado la solicitud (le mando llave y valor)
        conexion.setRequestProperty("Accept-Language", "en-US, es, en;q=0.5"); //estandar 0.5 (cierta libertad al escribir) //lenguaje que acepto
    
        String urlParameters = valorescurso+"";

        //envio de solicitud
        conexion.setDoOutput(true);
        DataOutputStream salida= new DataOutputStream(conexion.getOutputStream());
        salida.writeBytes(urlParameters);
        salida.flush(); //empaqueta con el tamaño del protocolo http de 32k
        salida.close();

        //codigo de error o de exito que tiene

        // int codigoRespuesta = conexion.getResponseCode(); // es cuando sale 200 o 400 o 500 para ver si se hizo con exito o no
    
        // System.out.println("\nUsando metodo POST en: " + url);
        // System.out.println("\nParametros: " + urlParameters);
        // System.out.println("Codigo de respuesta " + codigoRespuesta);
        // System.out.println("\n ==============================");
        // System.out.println(valorescurso);

    }

    public void sendPutModalidad1(int valorid, modalidad valor ) throws Exception{
        sendPostModalidad1(valor);
        sendDeleteModalidad1(valorid);
    }

    public void sendDeleteModalidad1(int valor) throws Exception{
        String url = "http://localhost:9080/api/modalidad/"+valor;

        //establezco conexion 
        URL objNet = new URL(url);
        HttpURLConnection conexion = (HttpURLConnection) objNet.openConnection();

        conexion.setRequestMethod("DELETE"); //metodo get que voy a cargar
        conexion.addRequestProperty("User_Agent", USER_AGENT);//añado la solicitud (le mando llave y valor)
        conexion.setRequestProperty("Accept-Language", "en-US, es, en;q=0.5"); //estandar 0.5 (cierta libertad al escribir) //lenguaje que acepto
    
        String urlParameters = valor+"";

        //envio de solicitud
        conexion.setDoOutput(true);
        DataOutputStream salida= new DataOutputStream(conexion.getOutputStream());
        salida.writeBytes(urlParameters);
        salida.flush(); //empaqueta con el tamaño del protocolo http de 32k
        salida.close();

        //codigo de error o de exito que tiene

        // int codigoRespuesta = conexion.getResponseCode(); // es cuando sale 200 o 400 o 500 para ver si se hizo con exito o no
    
        // System.out.println("\nUsando metodo POST en: " + url);
        // System.out.println("\nParametros: " + urlParameters);
        // System.out.println("Codigo de respuesta " + codigoRespuesta);
        // System.out.println("\n ==============================");
        // System.out.println(valor);
    }
}
