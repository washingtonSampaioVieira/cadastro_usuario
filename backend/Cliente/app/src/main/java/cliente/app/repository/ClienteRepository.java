package cliente.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cliente.app.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
