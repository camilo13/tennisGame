package pe.novatronic.challenge.exception;

public class TennisException extends Exception{
	
	private int codError;
	private String msg;
	
	public TennisException(int codError, String msg) {
		super();
		this.codError = codError;
		this.msg = msg;
	}
}
