package validador;

public class Validador {
	
	public boolean validarLogin(String usuario, String contrase�a, String uForm, String cForm) {
		return ( usuario.equals(uForm) && contrase�a.equals(cForm) );
	}
	
	
}
