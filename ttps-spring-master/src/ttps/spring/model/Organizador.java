package ttps.spring.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="organizadores")
public class Organizador{	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(mappedBy = "organizador")
	private List<Evento> eventos = new ArrayList<>();
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Usuario usuario;
	
	public Organizador() {
		super();
	}
	
	public Organizador(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
