package modelos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table (name="foodtrucks")
public class FoodTruck {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column (name = "nombre", nullable = false)
	private String nombre;
	@Column (name = "descripcion", nullable = false)
	private String descripcion;
	@Column (name = "url", nullable = false)
	private String url;
	@Column (name = "whatsapp", nullable = false)
	private String whatsapp;
	@Column (name = "instagram", nullable = false)
	private String instagram;
	@Column (name = "twitter", nullable = false)
	private String twitter;
	
	@ManyToOne
	@JoinColumn(name="foodtrucker_id", nullable = false)
	private FoodTrucker foodtrucker;
	
	@ManyToMany(cascade = { CascadeType.ALL })
		@JoinTable(
	        name = "FoodTruck_TipoServicio", 
	        joinColumns = { @JoinColumn(name = "foodtruck_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "tiposervicio_id") }
	    )
	private List <TipoDeServicio> tipos = new ArrayList<TipoDeServicio>(); 
		
	@OneToMany(mappedBy = "foodtrucker", cascade = CascadeType.ALL)
	private List<Contratacion> contrataciones = new ArrayList<>();
	
	public FoodTruck() {
		super();
	}

	public FoodTruck(String nombre, String descripcion, String url, String whatsapp, String instagram, String twitter) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.whatsapp = whatsapp;
		this.instagram = instagram;
		this.twitter = twitter;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public FoodTrucker getFoodtrucker() {
		return foodtrucker;
	}

	public void setFoodtrucker(FoodTrucker foodtrucker) {
		this.foodtrucker = foodtrucker;
	}

	public List<TipoDeServicio> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoDeServicio> tipos) {
		this.tipos = tipos;
	}

	
	
	
	
	
}