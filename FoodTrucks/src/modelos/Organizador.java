package modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="organizadores")
public class Organizador extends Usuario{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@OneToMany(mappedBy="organizador")
	private List <Evento> eventos =  new ArrayList<Evento>();
	@OneToOne
    @MapsId
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioORG_id;
	
	public List<Evento> getEventos() {
		return eventos;
	}
	
	public void addEvento(Evento aux) {
		eventos.add(aux);
	}

	public void removeEvento(Evento aux) {
		eventos.remove(aux);
	}

}
