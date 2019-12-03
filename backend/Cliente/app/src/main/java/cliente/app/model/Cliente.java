package cliente.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	Integer id;

	@Size(min = 3, max = 50, message = "O nome deve ter no minimo 3 caracteres e no maximo 50")
	@NotNull(message = "Nome não pode ser nulo.")
	@Column(name = "nome")
	String nome;

	@NotNull
	@Size(min = 15, max = 100, message = "E-mail invalido")
	@Column(name = "email")
	String email;

	@NotNull
	@Size(min = 9, max = 15, message = "Telefone invalido")
	@Column(name = "telefone")
	String telefone;

	@JsonIgnore
	@Column(name = "dt_criacao")
	String tbCriacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTbCriacao() {
		return tbCriacao;
	}

	public void setTbCriacao(String tbCriacao) {
		this.tbCriacao = tbCriacao;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", tbCriacao="
				+ tbCriacao + "]";
	}

}
