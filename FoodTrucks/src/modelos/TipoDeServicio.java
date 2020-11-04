package modelos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="tipo_servicio")
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

	public List<FoodTruck> getFoodtrucks() {
		return foodtrucks;
	}

	public void setFoodtrucks(List<FoodTruck> foodtrucks) {
		this.foodtrucks = foodtrucks;
	}

	

}
