import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Supongo que estoy guardando un String Int Double */
		
		BufferedReader br;
		DataOutputStream dos;
		DataInputStream dis;
		int max = 0,min = 0, cont = 0,suma = 0;
		try {
		
		
		dos = new DataOutputStream(new FileOutputStream("ficheros/enterosBinarios"));

		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Introduce ENTEROS, las escribiré en el fichero enterosBinarios! (0 para terminar!):");
		int escribir = sc.nextInt();
		sc.nextLine();
		
		while( escribir != 0) {

				dos.writeInt(escribir);
				escribir = sc.nextInt();
				sc.nextLine();
		}
		
		dos.close();
		
		
		dis = new DataInputStream(new FileInputStream("ficheros/enterosBinarios"));
		int leido = min = max =  dis.readInt();
		
		while(true) {
			if( leido > max) max = leido;
			else if (min > leido) min = leido;
			suma += leido;
			cont++;
			leido = dis.readInt();
			
		}
	
		}catch (EOFException e) {
			System.out.println("Hemos terminado!");
			System.out.println("El mayor es: " + max);
			System.out.println("El menor es: " + min);
			System.out.println("la media es: " + suma/cont);
			
		}
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}


