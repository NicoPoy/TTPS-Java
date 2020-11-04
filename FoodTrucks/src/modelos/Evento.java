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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_id", nullable = false)
	private TipoDeEvento tipo;
	@ManyToOne
	@JoinColumn(name="organizador_id", nullable = false)
	private Organizador organizador;
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	private List<Contratacion> contrataciones = new ArrayList<>();
	
	public Evento() {
		super();
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getGeolocalizacion() {
		return geolocalizacion;
	}

	public void setGeolocalizacion(String geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Date getFechayHora() {
		return fechayHora;
	}

	public void setFechayHora(Date fechayHora) {
		this.fechayHora = fechayHora;
	}

	public boolean isPaganOrganizadores() {
		return paganOrganizadores;
	}

	public void setPaganOrganizadores(boolean paganOrganizadores) {
		this.paganOrganizadores = paganOrganizadores;
	}

	public TipoDeEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeEvento tipo) {
		this.tipo = tipo;
	}

	public Organizador getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Organizador organizador) {
		this.organizador = organizador;
	}

	
}
