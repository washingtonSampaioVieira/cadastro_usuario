package cliente.app.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cliente.app.config.JwtTokenUtil;
import cliente.app.model.JwtResponse;
import cliente.app.model.TokenValidoDTO;

@RestController
@RequestMapping("/tokens")
public class JwtAuthenticationResource {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<?> createAuthenticationToken() {
		// Criando o token e retornando no body da resposta
		final String token = jwtTokenUtil.generateToken();

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<?> validateAuthenticationToken(@RequestHeader String token) {
		try {
			return ResponseEntity.ok(new TokenValidoDTO(!jwtTokenUtil.isTokenExpired(token)));
		} catch(Exception e) {
			return ResponseEntity.ok(new TokenValidoDTO(false));
		}
	}
}
