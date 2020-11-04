package validador;

public class Validador {
	
	public boolean validarLogin(String usuario, String contraseña, String uForm, String cForm) {
		return ( usuario.equals(uForm) && contraseña.equals(cForm) );
	}
	
	
}
