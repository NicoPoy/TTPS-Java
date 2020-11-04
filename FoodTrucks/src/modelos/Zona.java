package modelos;
import javax.persistence.*;

@Entity
@Table (name="zonas")

public class Zona {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "nombre", nullable = false)
	private String nombre;


	public Zona() {
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


}
