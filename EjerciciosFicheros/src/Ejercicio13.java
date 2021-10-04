import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import model.Canciones;

public class Ejercicio13 {
	
	private static int pedirInt(String frase) {

		Scanner teclado = new Scanner(System.in);

			System.out.println(frase);
			

		return teclado.nextInt();
	}
	
	private static String pedirString(String frase) {

		Scanner teclado = new Scanner(System.in);

			System.out.println(frase);


		return teclado.next();
	}
	
	private static boolean pedirBoolean(String frase) {

		Scanner teclado = new Scanner(System.in);

			System.out.println(frase);


		return teclado.nextBoolean();
	}

	public static boolean escribirCanciones(ArrayList<Canciones> listaCanciones, File fichero) {
		boolean escritas = false;
		try {

			StringBuffer buffer = null;
			RandomAccessFile RAF = new RandomAccessFile(fichero, "rw");

			int numeroCanciones = (int) (RAF.length() / 111);

			RAF.seek(0);

			for (Canciones c : listaCanciones) {

				buffer = new StringBuffer(c.getNombre());
				buffer.setLength(20);
				RAF.writeChars(buffer.toString());

				buffer = new StringBuffer(c.getDisco());
				buffer.setLength(20);
				RAF.writeChars(buffer.toString());

				buffer = new StringBuffer(c.getAutor());
				buffer.setLength(15);
				RAF.writeChars(buffer.toString());

				RAF.writeBoolean(c.isEspañola());

			}

			String nombre = "";
			String disco = "";
			String autor = "";
			boolean español = false;

			int pos = pedirInt("Introduce el numero de la cancion que quieres ver");
			RAF.seek(111*(pos-1));

				for (int j = 0; j < 20; j++) {

					nombre += RAF.readChar();

				}

				System.out.println(nombre);
				
				for (int j = 0; j < 20; j++) {

					disco += RAF.readChar();

				}

				System.out.println(disco);

				for (int j = 0; j < 15; j++) {

					autor += RAF.readChar();

				}

				System.out.println(autor);

				español = RAF.readBoolean();

				System.out.println(español);

				System.out.println("----------");

				español = false;
				nombre="";
				disco="";
				autor="";

			RAF.close();

			escritas = true;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return escritas;
	}
	
	
	public static Canciones modificarCancinon(int posicion, File fichero) {
		
		String nombre = "";
		String disco = "";
		String autor = "";
		boolean español = false;
		
		try {

			StringBuffer buffer = null;
			RandomAccessFile RAF = new RandomAccessFile(fichero, "rw");

			RAF.seek(111*(posicion-1));
			
			buffer = new StringBuffer(pedirString("Introduce el nuevo nombre de la cancion"));
			buffer.setLength(20);
			RAF.writeChars(buffer.toString());

			buffer = new StringBuffer(pedirString("Introduce el nuevo nombre del disco"));
			buffer.setLength(20);
			RAF.writeChars(buffer.toString());

			buffer = new StringBuffer(pedirString("Introduce el nuevo autor"));
			buffer.setLength(15);
			RAF.writeChars(buffer.toString());

			RAF.writeBoolean(pedirBoolean("Es española?"));

			RAF.seek(111*(posicion-1));

				for (int j = 0; j < 20; j++) {

					nombre += RAF.readChar();

				}

				System.out.println(nombre);
				
				for (int j = 0; j < 20; j++) {

					disco += RAF.readChar();

				}

				System.out.println(disco);

				for (int j = 0; j < 15; j++) {

					autor += RAF.readChar();

				}

				System.out.println(autor);

				español = RAF.readBoolean();

				System.out.println(español);

				System.out.println("----------");

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Canciones(nombre,disco,autor,español);
	}

	public static void main(String[] args) {

		File fichero = new File("canciones.txt");

		ArrayList<Canciones> listaCanciones = new ArrayList<>();

		listaCanciones.add(new Canciones("Corazon de mimbre", "Revolcon", "Marea", true));
		listaCanciones.add(new Canciones("Jindama", "El azogue", "Marea", true));
		listaCanciones.add(new Canciones("Thunderstruck", "The Razors Edge", "ACDC", false));
		listaCanciones.add(new Canciones("Back in BLack", "Back in BLack", "ACDC", false));
		listaCanciones.add(new Canciones("La flaca", "La flaca", "Jarabe de Palo", true));

		if (escribirCanciones(listaCanciones, fichero)) {

			System.out.println("Se han creado las canciones");

		} else
			System.out.println("no se han creado");
		
		Canciones cancionModificada = modificarCancinon(pedirInt("Introduce el numero de la cancion que quieres modificar"), fichero);
		
		System.out.println("El nombre de la nueva cancion es: " + cancionModificada.getNombre());
		System.out.println("El disco es: " + cancionModificada.getDisco());
		System.out.println("El autor es: " + cancionModificada.getAutor());

	}

}
