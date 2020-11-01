package modelos;
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
	// Relacion Evento---<>---Contratacion
	@ManyToOne
    @JoinColumn(name="evento_id", nullable=false)
    private Evento evento;
	// Relacion Foodtruck---<>---Contratacion
	@ManyToOne
    @JoinColumn(name="evento_id", nullable=false)
    private FoodTruck foodtruck;	
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int aux) {
		this.estado = aux;
	}

	public int getLimpieza() {
		return limpieza;
	}

	public void setLimpieza(int aux) {
		this.limpieza = aux;
	}

	public int getSimpatia() {
		return simpatia;
	}

	public void setSimpatia(int aux) {
		this.simpatia = aux;
	}

	public int getCalidadPrecio() {
		return calidadPrecio;
	}

	public void setCalidadPrecio(int aux) {
		this.calidadPrecio = aux;
	}

	public int getSabor() {
		return sabor;
	}

	public void setSabor(int aux) {
		this.sabor = aux;
	}

	public int getDisenio() {
		return disenio;
	}

	public void setDisenio(int aux) {
		this.disenio = aux;
	}
	
}
