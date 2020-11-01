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
	
    @OneToOne(mappedBy = "zona")
    private FoodTrucker foodtrucker;

	public Zona() {
		super();
	}

	public Zona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
