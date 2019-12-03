package cliente.app.model;

import java.io.Serializable;

public class TokenValidoDTO implements Serializable {
	
	private static final long serialVersionUID = -6191279491954043846L;
	private final Boolean isValid;

	public TokenValidoDTO(Boolean v) {
		super();
		this.isValid = v;
	}
	
	public Boolean getValidity() {
		return isValid;
	}
}
