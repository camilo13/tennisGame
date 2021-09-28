package pe.novatronic.challenge.service;

import java.util.logging.Logger;

import pe.novatronic.challenge.enums.EventosEnum;
import pe.novatronic.challenge.enums.PuntosEnum;
import pe.novatronic.challenge.exception.TennisException;
import pe.novatronic.challenge.model.Jugador;

public class TennisGame {
	
	private static final Logger logger = Logger.getLogger("TennisGame");  

	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador ganador;
	
	public TennisGame(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
	
	public void actualizarScore(Integer id) throws TennisException {
		if (jugador1.getId() == id) {
			jugador1.nuevoPunto();
		} else if (jugador2.getId() == id) {
			jugador2.nuevoPunto();
		} else {
			throw new TennisException(1, "ID de jugador incorrecto");
		}
	}
	
	public String score() {
		
		Integer diferencia = Math.abs(jugador1.getPuntos() - jugador2.getPuntos());
		
		if (diferencia == 0 && jugador1.getPuntos() >= 3) {
			return EventosEnum.DEUCE.getDescripcion();
		}
		
		if (jugador1.getPuntos() > 3 || jugador2.getPuntos() > 3) {
			if (diferencia >= 2) {
				ganador = jugador1.getPuntos() > jugador2.getPuntos() ? jugador1 : jugador2;
				return EventosEnum.GANADOR.getDescripcion().replace("%nombre%", ganador.getNombre())
						.replace("%id%", ganador.getId().toString());
			} else {
				Jugador temp = jugador1.getPuntos() > jugador2.getPuntos() ? jugador1 : jugador2;
				return EventosEnum.ADVANTAGE.getDescripcion().replace("%nombre%", temp.getNombre())
						.replace("%id%", temp.getId().toString());
			}
		}
		
		return PuntosEnum.getByValor(jugador1.getPuntos()).name() + " - " + PuntosEnum.getByValor(jugador2.getPuntos()).name();
	}
	
	public String simpleScore(Integer puntos1, Integer puntos2) {
		return PuntosEnum.getByValor(puntos1).name() + " - " + PuntosEnum.getByValor(puntos2).name();
	}
	
	public String getJugadores() {
		return jugador1.getNombre() + " VS " + jugador2.getNombre();
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public Jugador getGanador() {
		return ganador;
	}

	public void setGanador(Jugador ganador) {
		this.ganador = ganador;
	}
	
}
