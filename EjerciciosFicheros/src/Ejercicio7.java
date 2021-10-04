import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br;
		BufferedWriter bw ;
		
		try {
		bw = new BufferedWriter(new FileWriter("ficheros/ficheroMayusculas"));
		br = new BufferedReader(new FileReader("ficheros/fichero"));
		

		String linea = br.readLine();
		String lineaCambiada = "";
		while(linea!=null) {
			
			for(int i = 0; i < linea.length();i++) {
					if(Character.isLowerCase(linea.charAt(i))) lineaCambiada += Character.toUpperCase(linea.charAt(i));
					else lineaCambiada += Character.toLowerCase(linea.charAt(i));
			}
			bw.write(lineaCambiada);
			bw.newLine();
			lineaCambiada = "";
			linea = br.readLine();
		}
		
		
		bw.close();
		br.close();
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}


