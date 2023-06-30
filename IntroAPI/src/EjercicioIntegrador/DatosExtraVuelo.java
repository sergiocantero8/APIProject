package EjercicioIntegrador;

//Clase para los datos extra del vuelo
public class DatosExtraVuelo extends Vuelo {
	private int valorFinalPorVuelo;
	private String segmentacion;

	public DatosExtraVuelo(String nombreVuelo, int nPasajeros, String rentabilidad, int valorUnitarioPasaje, int valorFinalPorVuelo, String segmentacion) {
		super(nombreVuelo, nPasajeros, rentabilidad, valorUnitarioPasaje);
		this.valorFinalPorVuelo = valorFinalPorVuelo;
		this.segmentacion = segmentacion;
	}

	@Override
	public String toString() {
		return (super.toString() + valorFinalPorVuelo + "\t" + segmentacion);
	}

	public int getValorFinalPorVuelo() {
		return valorFinalPorVuelo;
	}

	public void setValorFinalPorVuelo(int valorFinalPorVuelo) {
		this.valorFinalPorVuelo = valorFinalPorVuelo;
	}

	public String getSegmentacion() {
		return segmentacion;
	}

	public void setSegmentacion(String segmentacion) {
		this.segmentacion = segmentacion;
	}
	
	
}