package com.generation.comnectar.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String nomeUsuario;
	
	@Schema(example = "email@email.com.br")
	@NotNull(message = "O campo Usuário é obrigatório!")
	@NotBlank
	@Email(message = "O campo Usuário deve ser um e-mail válido!")
	private String loginUsuario;
	
	@NotNull
	@Size(min = 8,max = 64)
	private String senhaUsuario;
	
	@NotNull
	private String localUsuario;
	
	private String fotoUsuario;

	public Usuario(Long id, String nomeUsuario, String loginUsuario,
			String senhaUsuario, String localUsuario,
			String fotoUsuario) {
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.loginUsuario = loginUsuario;
		this.senhaUsuario = senhaUsuario;
		this.localUsuario = localUsuario;
		this.fotoUsuario = fotoUsuario;
	}

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produtos;

	public Usuario(Long id,String nomeUsuario,String loginUsuario,
		String senhaUsuario, String localUsuario, String fotoUsuario,
			List<Produto> produtos) {
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.loginUsuario = loginUsuario;
		this.senhaUsuario = senhaUsuario;
		this.localUsuario = localUsuario;
		this.fotoUsuario = fotoUsuario;
		this.produtos = produtos;
	}

	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getLocalUsuario() {
		return localUsuario;
	}

	public void setLocalUsuario(String localUsuario) {
		this.localUsuario = localUsuario;
	}

	public String getFotoUsuario() {
		return fotoUsuario;
	}

	public void setFotoUsuario(String fotoUsuario) {
		this.fotoUsuario = fotoUsuario;
	}	
}