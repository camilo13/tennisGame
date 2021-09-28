package pe.novatronic.challenge.model;

public class Jugador extends Persona{

	private Integer puntos;
	private Integer id;
	
	public Jugador(String nombre) {
		super(nombre);
		this.puntos = 0;
	}
	
	public Jugador(Integer id) {
		this.id = id;
		this.puntos = 0;
	}
	
	public Jugador(String nombre, Integer id) {
		super(nombre);
		this.id = id;
		this.puntos = 0;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void nuevoPunto() {
		this.puntos++;
	}

	@Override
	public String toString() {
		return "Jugador [puntos=" + puntos + ", id=" + id + ", getNombre()=" + getNombre() + "]";
	}
	
}
