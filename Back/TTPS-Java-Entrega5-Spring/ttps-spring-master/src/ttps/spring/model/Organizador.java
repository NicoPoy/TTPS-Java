package ttps.spring.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="organizadores")
public class Organizador extends Usuario{	
	
	@JsonIgnore
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
	
	public boolean esOrganizador() {
		return true;
	}
	

	
}
