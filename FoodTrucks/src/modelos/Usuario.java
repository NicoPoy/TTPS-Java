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
	@Column (name = "username", nullable = false)
	private String username;
	@Column (name = "password", nullable = false)
	private String password;
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "usuario")
	private FoodTrucker foodtrucker;
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "usuario")
	private Organizador organizador;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nombre, String apellido, String username, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public FoodTrucker getFoodtrucker() {
		return foodtrucker;
	}

	public void setFoodtrucker(FoodTrucker foodtrucker) {
		this.foodtrucker = foodtrucker;
	}
	
	public Organizador getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Organizador organizador) {
		this.organizador = organizador;
	}
	
}
