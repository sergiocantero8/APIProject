package BD;

//Clase para los usuarios
public class Usuario {
	private int usuarioId;
	private String username;
	private String password;
	private String email;

	public Usuario(int usuarioId, String username, String password, String email) {
		this.usuarioId = usuarioId;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public String getUsername() {
		return username;
	}
}