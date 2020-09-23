package ttps.clasificados;
import java.util.ArrayList;
import java.util.Iterator;

public class ValidadorUsuarios {

	private ArrayList <Usuario> lista = new ArrayList<Usuario>();
	private Iterator<Usuario> it = lista.iterator();
	
	public ValidadorUsuarios() {
		Usuario u1 = new Usuario("Bruce","batman","admin");
		lista.add(u1);
		Usuario u2 = new Usuario("Diana","ww","admin");
		lista.add(u2);
		Usuario u3 = new Usuario("Clark","superman","admin");
		lista.add(u3);
		Usuario u4 = new Usuario("Barry","flash","user");
		lista.add(u4);
		Usuario u5 = new Usuario("Hal","linterna","user");
		lista.add(u5);
		Usuario u6 = new Usuario("Athur","aquaman","user");
		lista.add(u6);
	}
	
	public String validar(String username, String password) {
		for( Usuario u : lista ) {
			if (u.getUsername().equals(username)) {
				if (u.getPassword().equals(password)) {
					return u.getTipo();
				}
			}
		}
		return null;
	}
	
	
	
}
