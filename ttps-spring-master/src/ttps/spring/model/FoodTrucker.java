package ttps.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="foodtruckers")
public class FoodTrucker extends Usuario{

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="zona_id")
	private Zona zona;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "foodtrucker", cascade = CascadeType.ALL)
	private List<FoodTruck> foodtrucks = new ArrayList<>();
	
	public FoodTrucker() {
		super();
	}
		
	public FoodTrucker(Zona zona, Usuario usuario) {
		super();
		this.zona = zona;
	}


	public FoodTrucker(Zona zona, List<FoodTruck> foodtrucks, Usuario usuario) {
		super();
		this.zona = zona;
		this.foodtrucks = foodtrucks;
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
	
	public boolean esFoodTrucker() {
		return true;
	}
	
}
