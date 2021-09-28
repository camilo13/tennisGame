package pe.novatronic.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pe.novatronic.challenge.exception.TennisException;
import pe.novatronic.challenge.model.Jugador;
import pe.novatronic.challenge.service.TennisGame;

public class MarcadorTest {

	private static final Logger logger = Logger.getLogger("MarcadorTest");  
	
	Jugador jugador1;
    Jugador jugador2;
    TennisGame tg;
	
	@BeforeEach
	void testSuma() {
	    jugador1 = new Jugador("Jorge", 1);
	    jugador2 = new Jugador("Pedro", 2);
	    tg = new TennisGame(jugador1, jugador2);
	}
	
	@Test
	void testScore() throws TennisException {
		assertEquals("LOVE - LOVE", tg.score());
		tg.actualizarScore(jugador1.getId());
		assertEquals("FIFTEEN - LOVE", tg.score());
		tg.actualizarScore(jugador2.getId());
		assertEquals("FIFTEEN - FIFTEEN", tg.score());
		tg.actualizarScore(jugador2.getId());
		assertEquals("FIFTEEN - THIRTY", tg.score());
		tg.actualizarScore(jugador2.getId());
		assertEquals("FIFTEEN - FORTY", tg.score());
		tg.actualizarScore(jugador1.getId());
		assertEquals("THIRTY - FORTY", tg.score());
		tg.actualizarScore(jugador1.getId());
		assertEquals("DEUCE", tg.score());
		tg.actualizarScore(jugador1.getId());
		assertEquals("ADVANTAGE para Jorge-1", tg.score());
		tg.actualizarScore(jugador1.getId());
		assertEquals("GANA Jorge-1", tg.score());
		logger.info("FIN - PRUEBAS: %ganador%".replace("%ganador%", tg.getGanador().toString()));
	}
	
	@Test
	void testGame() throws TennisException, InterruptedException {
		logger.info("::INICIA EL JUEGO::");
		logger.info(":: Jugador 1: " + jugador1.toString());
		logger.info(":: Jugador 2: " + jugador2.toString());
		logger.info(":: " + tg.score());
		while (Objects.isNull(tg.getGanador())) {
			tg.actualizarScore(jugadorRandom());
			logger.info(":: " + tg.score());
			Thread.sleep(2000);
		}
		assertNotEquals(null, tg.getGanador());
	}
	
	static Integer jugadorRandom() {
		return new Random().nextInt(2) + 1;
	}
	
}
