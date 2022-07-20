package com.generation.comnectar.model;

import javax.validation.constraints.NotBlank;

public class UsuarioLogin {

	private Long id;
	
	private String nomeUsuario;
	
	@NotBlank
	private String loginUsuario;
	
	@NotBlank
	private String senhaUsuario;

	private String localUsuario;

	private String foto;
	
	private String token;

	public UsuarioLogin(Long id, String nomeUsuario, String loginUsuario, String senhaUsuario, String localUsuario,
			String foto, String token) {
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.loginUsuario = loginUsuario;
		this.senhaUsuario = senhaUsuario;
		this.localUsuario = localUsuario;
		this.foto = foto;
		this.token = token;
	}

	public UsuarioLogin() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getLocalUsuario() {
		return localUsuario;
	}

	public void setLocalUsuario(String localUsuario) {
		this.localUsuario = localUsuario;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
}