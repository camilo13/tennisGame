package pe.novatronic.challenge.enums;

public enum EventosEnum {

	DEUCE("DEUCE"),
	ADVANTAGE("ADVANTAGE para %nombre%-%id%"),
	GANADOR("GANA %nombre%-%id%");
	
	private String descripcion;

	EventosEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
