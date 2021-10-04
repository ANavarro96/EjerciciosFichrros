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
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

public class Ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Supongo que estoy guardando un String Int Double */
		
		final long tamanyo = 4;
		RandomAccessFile raf;
		int max = 0,min = 0, cont = 0,suma = 0;
		try {
		
		
		raf = new RandomAccessFile("ficheros/enterosRAF", "rw");
		
		

		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Introduce ENTEROS, las escribiré en el fichero enterosRAF! (0 para terminar!):");
		int escribir = sc.nextInt();
		sc.nextLine();
		
		while( escribir != 0) {

				raf.writeInt(escribir);
				escribir = sc.nextInt();
				sc.nextLine();
		}
		
		raf.seek(0);
		long numEnteros = raf.length() / tamanyo;
		int leido = 0;
		
		for(int i = 0; i < numEnteros;i++) {
			leido = raf.readInt();
			System.out.println(leido);
		}
	
		System.out.println("¿Cuál quiere ver? Disponemos de " + numEnteros + " enteros en el fichero (las posiciones van de 0 a " + (numEnteros -1) + ")");
		escribir = sc.nextInt();
		sc.nextLine();
		
		if( escribir < numEnteros) {
		raf.seek(escribir * tamanyo);
		
		
		System.out.println(raf.readInt());
		
		// Si quisieramos modificar el valor, habría que escribir un entero nueo -> raf.writeInt(44) por ejemplo
		}
		else {
			System.out.println("Has elegido una posición demasiado grande!!");
		}
		}
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}


