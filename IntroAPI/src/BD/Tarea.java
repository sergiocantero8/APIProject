package BD;

public class Tarea {

	protected int tareaId;
	protected String nombreTarea;
	protected String categoria;
	protected String fechaLimite;

	public Tarea(int tareaId, String nombreTarea, String categoria, String fechaLimite) {
		this.tareaId = tareaId;
	    this.nombreTarea = nombreTarea;
	    this.categoria = categoria;
	    this.fechaLimite = fechaLimite;
	}

	public void mostrarInformacion() {
	  System.out.println("*Información de la tarea*\n");
	  System.out.println("ID de Tarea: " + tareaId);
	  System.out.println("Nombre de Tarea: " + nombreTarea);
	  System.out.println("Descripción: " + categoria);
	  System.out.println("Fecha Límite: " + fechaLimite);
	}
	
}
