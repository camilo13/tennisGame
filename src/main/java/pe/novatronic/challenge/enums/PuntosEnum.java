package pe.novatronic.challenge.enums;

public enum PuntosEnum {
	
	LOVE(0,"Love"),
	FIFTEEN(1,"Fifteen"),
	THIRTY(2,"Thirty"),
	FORTY(3,"Forty"),
	UNKNOWN(-1,"Error");
	
	private Integer valor;
	private String descripcion;

	PuntosEnum(Integer valor, String descripcion) {
		this.valor = valor;
		this.descripcion = descripcion;
	}

	public Integer getValor() {
		return valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static PuntosEnum getByValor(Integer valor) {
	    for(PuntosEnum e : values()) {
	        if(e.valor.equals(valor)) return e;
	    }
	    return UNKNOWN;
	}
}
