package modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="foodtrucker")
public class FoodTrucker extends Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@OneToMany(mappedBy = "foodtrucker", cascade = CascadeType.ALL)
	private List <FoodTruck> foodtrucks =  new ArrayList<FoodTruck>();
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zona_id", referencedColumnName = "id")
	private Zona zona;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioFT_id;
	
	
	public List<FoodTruck> getFoodtrucks() {
		return foodtrucks;
	}
	
	public void addFoodTruck(FoodTruck aux) {
		foodtrucks.add(aux);
	}

	public void removeFoodTruck(FoodTruck aux) {
		foodtrucks.remove(aux);
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona aux) {
		this.zona = aux;
	}
	
	
}
