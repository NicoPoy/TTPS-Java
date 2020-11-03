package modelos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
@Table (name="foodtruck")
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="foodtrucker_id", nullable = false)
	private FoodTrucker foodtrucker ;
	
	//private List <Image> imagenes =  new ArrayList<Image>();
	
	@ManyToMany(cascade = { CascadeType.ALL })
		@JoinTable(
	        name = "FoodTruck_TipoServicio", 
	        joinColumns = { @JoinColumn(name = "foodtruck_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "tiposervicio_id") }
	    )
	private List <TipoDeServicio> tipos = new ArrayList<TipoDeServicio>(); 
	
	@OneToMany(mappedBy="evemto")
	private List <Contratacion> contrataciones =  new ArrayList<Contratacion>();
	
	
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String aux) {
		this.nombre = aux;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String aux) {
		this.descripcion = aux;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String aux) {
		this.url = aux;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String aux) {
		this.whatsapp = aux;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String aux) {
		this.instagram = aux;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String aux) {
		this.twitter = aux;
	}

	/*
	public List<Image> getImagenes() {
		return imagenes;
	}
	
	public void addImagen(Image aux) {
		imagenes.add(aux);
	}
	
	public void removeImagen(Image aux) {
		imagenes.remove(aux);
	}
	*/
	
	public List<TipoDeServicio> getTipos() {
		return tipos;
	}

	public void addTipo(TipoDeServicio aux) {
		tipos.add(aux);
	}

	public void removeTipo(TipoDeServicio aux) {
		tipos.remove(aux);
	}
	
	public List <Contratacion> getContrataciones() {
		return contrataciones;
	}
	
	public void addContrataciones(Contratacion aux) {
		contrataciones.add(aux);
	}
	
	public void removeContrataciones(Contratacion aux) {
		contrataciones.remove(aux);
	}
	
}