package modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="foodtruckers")
public class FoodTrucker{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="zona_id", nullable = false)
	private Zona zona;	
	@OneToMany(mappedBy = "foodtrucker", cascade = CascadeType.ALL)
	private List<FoodTruck> foodtrucks = new ArrayList<>();
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Usuario usuario;
	
	public FoodTrucker() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<FoodTruck> getFoodtrucks() {
		return foodtrucks;
	}

	public void setFoodtrucks(List<FoodTruck> foodtrucks) {
		this.foodtrucks = foodtrucks;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
	
}
