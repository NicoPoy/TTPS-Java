package ttps.spring.model;
import javax.persistence.*;


@Entity
@Table (name="contrataciones")

public class Contratacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column (name = "estado", nullable = false)
	private int estado; 
	@Column (name = "limpieza", nullable = false)
	private int limpieza;
	@Column (name = "simpatia", nullable = false)
	private int simpatia;
	@Column (name = "calidadprecio", nullable = false)
	private int calidadPrecio;
	@Column (name = "sabor", nullable = false)
	private int sabor;
	@Column (name = "disenio", nullable = false)
	private int disenio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="evento_id", nullable = false)
	private Evento evento;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="foodtruck_id", nullable = false)
	private FoodTruck foodtruck;
	
	public Contratacion() {
		super();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	public int getLimpieza() {
		return limpieza;
	}


	public void setLimpieza(int limpieza) {
		this.limpieza = limpieza;
	}


	public int getSimpatia() {
		return simpatia;
	}


	public void setSimpatia(int simpatia) {
		this.simpatia = simpatia;
	}


	public int getCalidadPrecio() {
		return calidadPrecio;
	}


	public void setCalidadPrecio(int calidadPrecio) {
		this.calidadPrecio = calidadPrecio;
	}


	public int getSabor() {
		return sabor;
	}


	public void setSabor(int sabor) {
		this.sabor = sabor;
	}


	public int getDisenio() {
		return disenio;
	}


	public void setDisenio(int disenio) {
		this.disenio = disenio;
	}


	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}


	public FoodTruck getFoodtruck() {
		return foodtruck;
	}


	public void setFoodtruck(FoodTruck foodtruck) {
		this.foodtruck = foodtruck;
	}
	
	
	
	
	
	
	
	
}
