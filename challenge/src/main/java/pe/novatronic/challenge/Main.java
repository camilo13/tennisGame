package pe.novatronic.challenge;

import java.util.Objects;
import  java.util.Scanner;

import pe.novatronic.challenge.model.Jugador;
import pe.novatronic.challenge.service.TennisGame;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("::::: TENNIS GAME :::::");
		Jugador jugador1 = new Jugador(1);
		Jugador jugador2 = new Jugador(2);
		TennisGame tennisGame;
		Scanner in = new Scanner(System.in);		
		
		System.out.println("Nombre del Jugador 1 (ID: 1): ");
		jugador1.setNombre(in.nextLine());
		
		System.out.println("Nombre del jugador 2 (ID: 2): ");
		jugador2.setNombre(in.nextLine());
		
		tennisGame = new TennisGame(jugador1, jugador2);
		System.out.println(tennisGame.getJugadores());
		
		while (Objects.isNull(tennisGame.getGanador())) {
			System.out.println("1. Nuevo punto para jugador 1 (%nombre%)".replace("%nombre%", tennisGame.getJugador1().getNombre()));
			System.out.println("2. Nuevo punto para jugador 2 (%nombre%)".replace("%nombre%", tennisGame.getJugador2().getNombre()));
			System.out.println("3. Score");
			System.out.println("Escribe un numero del menu:");
			Integer opc = in.nextInt();
			
			switch (opc) {
			case 1:
			case 2:
				tennisGame.actualizarScore(opc);
				System.out.println(tennisGame.score());
				break;
			case 3:
				System.out.println(tennisGame.score());
				break;
			default:
				System.out.println("Seleccione otra opcion del menu");
				break;
			}
		}
		
		in.close();
	}

	
}
