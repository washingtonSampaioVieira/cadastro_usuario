package cliente.app.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cliente.app.model.Cliente;
import cliente.app.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteRepository clienteRepository;

	@CrossOrigin
	@GetMapping
	public List<Cliente> getCliente() {
		System.out.println("teste");
		return clienteRepository.findAll();
	}

	@CrossOrigin
	@PostMapping
	public Cliente setCliente(@Validated @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
