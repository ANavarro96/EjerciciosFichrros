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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

import model.Producto;

public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Supongo que estoy guardando un String Int Double */

		ObjectOutputStream dos;
		ObjectInputStream dis;
		ArrayList<Producto> productos =  new ArrayList();
		productos.add(new Producto("Disco ELCD", 23.2, 1));
		productos.add(new Producto("Disco Melendi", 21.2, 34));
		try {
		
		
		dos = new ObjectOutputStream(new FileOutputStream("ficheros/productos"));

		for(Producto p: productos) dos.writeObject(p); 
		
		dos.close();
		
		
		dis = new ObjectInputStream(new FileInputStream("ficheros/productos"));
		Producto leido;
		while(true) {
			leido = (Producto) dis.readObject();
			System.out.println(leido.getNombre());
			
		}
	
		}catch (EOFException e) {
			System.out.println("Hemos terminado!");
			
		}
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		

	}


