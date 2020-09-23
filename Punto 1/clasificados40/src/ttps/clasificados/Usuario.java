package ttps.clasificados;

public class Usuario {
	private String username, password, tipo;
	
	public Usuario (String username, String password, String tipo) {
		this.setUsername(username);
		this.setPassword(password);
		this.setTipo(tipo);
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
