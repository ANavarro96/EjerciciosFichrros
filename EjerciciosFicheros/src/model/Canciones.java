package model;


public class Canciones {
	
	private String nombre;
	private String disco;
	private String autor;
	private boolean espa�ola;
	
	public Canciones(String nombre, String disco, String autor, boolean espa�ola) {
		super();
		this.nombre = nombre;
		this.disco = disco;
		this.autor = autor;
		this.espa�ola = espa�ola;
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
	public boolean isEspa�ola() {
		return espa�ola;
	}
	public void setEspa�ola(boolean espa�ola) {
		this.espa�ola = espa�ola;
	}
	
	
	

}
