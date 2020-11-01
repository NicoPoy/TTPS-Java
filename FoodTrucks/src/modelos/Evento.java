package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="eventos")

public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "nombre", nullable = false)
	private String nombre;
	@Column (name = "direccion", nullable = false)
	private String direccion; 
	@Column (name = "provincia", nullable = false)
	private String provincia;
	@Column (name = "geolocalizacion", nullable = false)
	private String geolocalizacion;
	@Column (name = "email", nullable = false)
	private String email; 
	@Column (name = "telefono", nullable = false)
	private String telefono; 
	@Column (name = "descripcion", nullable = false)
	private String descripcion;
	@Column (name = "codigopostar", nullable = false)
	private int codigoPostal;
	@Column (name = "fechayhora", nullable = false)
	private Date fechayHora;
	@Column (name = "paganorganizadores", nullable = false)
	private boolean paganOrganizadores;
	
	// Relacion Evento---<>---TipoEvento
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_id", nullable = false)
	private TipoDeEvento tipo;
	
	// Relacion Evento---<>---Contratacion
	@OneToMany(mappedBy="evemto")
	private List <Contratacion> contrataciones =  new ArrayList<Contratacion>();
	
	// Relacion Evento---<>---Organizador
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_id", nullable = false)
	private Organizador organizador;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String aux) {
		this.nombre = aux;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String aux) {
		this.direccion = aux;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String aux) {
		this.provincia = aux;
	}
	public String getGeolocalizacion() {
		return geolocalizacion;
	}
	public void setGeolocalizacion(String aux) {
		this.geolocalizacion = aux;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String aux) {
		this.email = aux;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String aux) {
		this.telefono = aux;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String aux) {
		this.descripcion = aux;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int aux) {
		this.codigoPostal = aux;
	}
	public Date getFechayHora() {
		return fechayHora;
	}
	public void setFechayHora(Date aux) {
		this.fechayHora = aux;
	}
	public boolean paganOrganizadores() {
		return paganOrganizadores;
	}
	public void paganOrganizadores(boolean aux) {
		this.paganOrganizadores = aux;
	}
	public TipoDeEvento getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeEvento aux) {
		this.tipo = aux;
	}
	public List<Contratacion> getContrataciones() {
		return contrataciones;
	}
	public void addContrataciones(Contratacion aux) {
		contrataciones.add(aux);
	}
	public void removeContrataciones(Contratacion aux) {
		contrataciones.remove(aux);
	}

	
}
