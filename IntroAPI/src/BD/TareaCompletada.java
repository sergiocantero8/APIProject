package BD;

//Clase para las tareas completadas
public class TareaCompletada extends Tarea {
 private String comentario;

 public TareaCompletada(int tareaId, String nombreTarea, String descripcion, String fechaLimite, String comentario) {
     super(tareaId, nombreTarea, descripcion, fechaLimite);
     this.comentario = comentario;
 }

 @Override
 public void mostrarInformacion() {
     super.mostrarInformacion();
     System.out.println("Comentario: " + comentario);
 }
}