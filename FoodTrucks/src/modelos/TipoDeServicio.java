package modelos;

import javax.persistence.*;

@Entity
@Table (name="tipo_servicio")
public class TipoDeServicio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column (name = "nombre", nullable = false)
	private String nombre;	

	public TipoDeServicio() {
		super();
	}
	
	public TipoDeServicio(String nombre) {
		super();
		this.nombre = nombre;
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

	

}
