/*
Se requiere un programa que lea y guarde países, y para evitar que se ingresen
repetidos usaremos un conjunto. El programa pedirá un país en un bucle, se
guardará el país en el conjunto y después se le preguntará al usuario si quiere
guardar otro país o si quiere salir, si decide salir, se mostrará todos los países
guardados en el conjunto.
Después deberemos mostrar el conjunto ordenado alfabéticamente para esto
recordar como se ordena un conjunto.
Y por ultimo, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator,
se buscará el país en el conjunto y si está en el conjunto se eliminará el país que
ingresó el usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto
se le informará al usuario.
*/
package ejercicio_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Walter
 */
public class Ejercicio_05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Este programa guarda países en un conjunto y los muestra.");
        HashSet<String> Paises = new HashSet();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String respuesta;
        boolean continuar=false;
        
        do{
            System.out.print("Ingrese un país: ");
            Paises.add(leer.nextLine());
            
            do{
                System.out.print("\n¿Desea agregar otra pelicula?(s/n) ");
                respuesta = leer.next().toLowerCase();
                switch(respuesta){
                    case "s":
                        continuar=true;
                        break;
                    case "n":
                        continuar=false;
                        break;
                    default:
                        System.out.println("Opción no valida");
                }
            }while(!(respuesta.equals("s")||respuesta.equals("n")));
            leer.nextLine();
        }while(continuar==true);
        
        System.out.println("\nMostrando países:");
        for(String i: Paises){
            System.out.println(i);
        }
        
        System.out.println("\nMostrando países ordenados alfabéticamente:");
        ArrayList<String> PaisesLista = new ArrayList(Paises);
        Collections.sort(PaisesLista);
        for(String i: PaisesLista){
            System.out.println(i);
        }
        
        System.out.print("\nIngrese un pais para eliminar del conjunto: ");
        String buscar = leer.nextLine();
        int tamOri=Paises.size(),tamMod=Paises.size();
        Iterator<String> it = Paises.iterator();
        
        while(it.hasNext()){
            if(it.next().equals(buscar)){
                it.remove();
                tamMod--;
            }
        }
        
        System.out.println((tamOri==tamMod)?"No se eliminó "+buscar+" porque no estaba en el conjunto."
                :"Se eliminó "+buscar+" del conjunto.");
        
        System.out.println("\nMostrando países:");
        for(String i: Paises){
            System.out.println(i);
        }
        
    }
    
}
