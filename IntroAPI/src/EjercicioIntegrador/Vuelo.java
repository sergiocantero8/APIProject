package EjercicioIntegrador;

// Clase vuelo
public class Vuelo {
	private String nombreVuelo;
	private int nPasajeros;
	private String tipoPasaje;
	private int valorUnitarioPasaje;

	public Vuelo(String nombreVuelo, int nPasajeros, String tipoPasaje, int valorUnitarioPasaje) {
		this.nombreVuelo = nombreVuelo;
		this.nPasajeros = nPasajeros;
		this.tipoPasaje = tipoPasaje;
		this.valorUnitarioPasaje = valorUnitarioPasaje;
	}

	public String getNombreVuelo() {
		return nombreVuelo;
	}

	public void setNombreVuelo(String nombreVuelo) {
		this.nombreVuelo = nombreVuelo;
	}

	public int getnPasajeros() {
		return nPasajeros;
	}

	public void setnPasajeros(int nPasajeros) {
		this.nPasajeros = nPasajeros;
	}

	public String getRentabilidad() {
		return tipoPasaje;
	}

	public void setRentabilidad(String rentabilidad) {
		this.tipoPasaje = rentabilidad;
	}

	public int getValorUnitarioPasaje() {
		return valorUnitarioPasaje;
	}

	public void setValorUnitarioPasaje(int valorUnitarioPasaje) {
		this.valorUnitarioPasaje = valorUnitarioPasaje;
	}

	public int getValorFinalPorVuelo() {
		return valorUnitarioPasaje * nPasajeros;
	}

	public String toString() {
		return (nombreVuelo + "\t" + nPasajeros + "\t" + tipoPasaje + "\t" + valorUnitarioPasaje + "\t");
	}

}
