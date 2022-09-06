package tools;
import java.util.Scanner;

public class EntradaTeclado {
    private static Scanner teclado;

    public static String leerString(String Texto){
        teclado = new Scanner(System.in);
        System.out.print(Texto+": ");
        String variable = teclado.nextLine();
        return variable;
    }
    public static int leerInt(String Texto){
        try{
            teclado = new Scanner(System.in);
            System.out.print(Texto+": ");
            int variable = teclado.nextInt();
            return variable;
        }
        catch (Exception err){
            System.out.println("Error: Se debe ingresar un numero");
            return (leerInt(""));
        }
    }
    public static Double leerReal(String texto){
        teclado = new Scanner(System.in);
        System.out.print(texto+": ");
        double variable = teclado.nextDouble();
        return variable;
    }   
}
