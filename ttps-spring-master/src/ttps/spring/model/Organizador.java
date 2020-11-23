package ttps.spring.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="organizadores")
public class Organizador extends Usuario{	
	
	@OneToMany(mappedBy = "organizador")
	private List<Evento> eventos = new ArrayList<>();

	public Organizador() {
		super();
	}
	
	public Organizador(Usuario usuario) {
		super();
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}


	
}
