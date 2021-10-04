package model;


public class Canciones {
	
	private String nombre;
	private String disco;
	private String autor;
	private boolean española;
	
	public Canciones(String nombre, String disco, String autor, boolean española) {
		super();
		this.nombre = nombre;
		this.disco = disco;
		this.autor = autor;
		this.española = española;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDisco() {
		return disco;
	}
	public void setDisco(String disco) {
		this.disco = disco;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public boolean isEspañola() {
		return española;
	}
	public void setEspañola(boolean española) {
		this.española = española;
	}
	
	
	

}
