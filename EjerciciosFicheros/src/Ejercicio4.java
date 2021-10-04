import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class Ejercicio4 {

	public static void main(String args[]) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("ficheros/fichero"));
			char[] vocales = {'a','e','i','o','u'};
			ArrayList<Integer> cuentaVocales = new ArrayList<Integer>();
			for (int i = 0; i < vocales.length;i++) cuentaVocales.add(0);
			
			
			String linea = br.readLine();
			while(linea!=null) {
				
				for(int i = 0; i < vocales.length;i++) {
					cuentaVocales.add(i, cuentaVocales.get(i) + StringUtils.countMatches(linea, vocales[i]) + 
							StringUtils.countMatches(linea, Character.toUpperCase(vocales[i])));
				}
								
				linea = br.readLine();
			}
			
			
			br.close();
			
			for(int i = 0; i < vocales.length;i++) System.out.println("La vocal " + vocales[i] + " aparece un total de: " + cuentaVocales.get(i));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
