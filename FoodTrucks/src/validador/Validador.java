package validador;

public class Validador {
	
	public boolean validarLogin(String usuario, String contraseņa, String uForm, String cForm) {
		return ( usuario.equals(uForm) && contraseņa.equals(cForm) );
	}
	
	
}
