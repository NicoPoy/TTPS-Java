package modelos;

import javax.persistence.*;
import org.hibernate.annotations.Cascade;

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
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "usuario")
	private FoodTrucker foodtrucker;
	
	public Usuario() {
		super();
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
	
	
}
