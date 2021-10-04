import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br;
		BufferedWriter bw;
		try {
			br = new BufferedReader(new FileReader("ficheros/fichero"));

			String linea = br.readLine();
			while(linea!=null) {
				
				linea = br.readLine();
			}
			
			br.close();
			
			bw = new BufferedWriter(new FileWriter("ficheros/fichero",true));
			bw.newLine();
			bw.write(System.getProperty("user.name") + " ");
			String fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			bw.write(fecha);
			bw.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
