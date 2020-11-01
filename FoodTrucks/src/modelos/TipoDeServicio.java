package modelos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="tipodeservicio")
public class TipoDeServicio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column (name = "nombre", nullable = false)
	private String nombre;	
	@ManyToMany(mappedBy = "tipos")
	private List <FoodTruck> foodtrucks = new ArrayList<FoodTruck>(); 
	
	public TipoDeServicio() {
		super();
	}

	public TipoDeServicio(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String aux) {
		this.nombre = aux;
	}

}
