import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br;
		BufferedWriter bw ;
		
		try {
			bw = new BufferedWriter(new FileWriter("ficheros/Ejercicio6"));
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Introduce frases, las escribiré en el fichero Ejercicio6! (fin o FIN para terminar!):");
		String escribir = sc.nextLine();
		
		while(!escribir.toUpperCase().equalsIgnoreCase("fin")) {
		
				bw.write(escribir);
				bw.newLine();
				System.out.println("Introduce frases, las escribiré en el fichero Ejercicio6! (fin o FIN para terminar!):");
				escribir = sc.nextLine();
			}
		
		bw.close();
		
		br = new BufferedReader(new FileReader("ficheros/Ejercicio6"));
		
		String linea = br.readLine();
		while(linea!=null) {
			
			System.out.println(linea);
							
			linea = br.readLine();
		}
		
		br.close();
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}


