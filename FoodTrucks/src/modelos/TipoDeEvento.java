package modelos;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="tiposdeevento")
public class TipoDeEvento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
 
	@Column (name = "nombre", nullable = false)
	private String nombre;
	
    @OneToMany
    @JoinColumn(name = "tipo_id")
    private List<Evento> eventos;
    
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String aux) {
		this.nombre = aux;
	}
	
}
