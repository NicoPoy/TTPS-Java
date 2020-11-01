package modelos;

import javax.persistence.*;

@Entity
@Table (name="usuarios")
public class Usuario {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column (name = "nombre", nullable = false)
	private String nombre;
	@Column (name = "apellido", nullable = false)
	private String apellido;
	@Column (name = "usuarname", nullable = false)
	private String username;
	@Column (name = "password", nullable = false)
	private String password;
		
	// DUDOSO
	@OneToOne(mappedBy = "usuarioFT_id", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private FoodTrucker foodtrucker;
	// DUDOSO
	@OneToOne(mappedBy = "usuarioORG_id", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Organizador organizador;
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String aux) {
		this.nombre = aux;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String aux) {
		this.apellido = aux;
	}

	public String getUsername() {
		return username;
	}

	public void setUsuario(String aux) {
		this.username = aux;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String aux) {
		this.password = aux;
	}

}
