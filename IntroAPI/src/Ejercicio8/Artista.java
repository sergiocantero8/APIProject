package Ejercicio8;

public class Artista {

	private String nombre;
	private String genero;
	private int nCanciones;
	private int nReproducciones;
	private int nSuscriptores;
	
	public Artista(String nombre, String genero, int nCanciones, int nReproducciones, int nSuscriptores) {
		this.nombre = nombre;
		this.genero = genero;
		this.nCanciones = nCanciones;
		this.nReproducciones = nReproducciones;
		this.nSuscriptores = nSuscriptores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getnCanciones() {
		return nCanciones;
	}

	public void setnCanciones(int nCanciones) {
		this.nCanciones = nCanciones;
	}

	public int getnReproducciones() {
		return nReproducciones;
	}

	public void setnReproducciones(int nReproducciones) {
		this.nReproducciones = nReproducciones;
	}

	public int getnSuscriptores() {
		return nSuscriptores;
	}

	public void setnSuscriptores(int nSuscriptores) {
		this.nSuscriptores = nSuscriptores;
	}
	
	public double calcularGananciaTotal() {
		return nReproducciones*0.02;
	}
	

}
