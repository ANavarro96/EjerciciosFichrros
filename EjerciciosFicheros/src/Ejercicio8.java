import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

public class Ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Supongo que estoy guardando un String Int Double */
		
		BufferedReader br;
		DataOutputStream dis;
		
		try {
		
		br = new BufferedReader(new FileReader("ficheros/gatitos"));
		dis = new DataOutputStream(new FileOutputStream("ficheros/gatitosBinario"));

		String gatito = br.readLine();
	    StringTokenizer gatitoAPiezas;
		
		while(gatito!=null) {
			gatitoAPiezas = new StringTokenizer(gatito);
			dis.writeUTF(gatitoAPiezas.nextToken());
			dis.writeInt(Integer.parseInt(gatitoAPiezas.nextToken()));
			dis.writeDouble(Double.parseDouble(gatitoAPiezas.nextToken()));
			
			gatito = br.readLine();
		}
		
		br.close();
		dis.close();
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}


