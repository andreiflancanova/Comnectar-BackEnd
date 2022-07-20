package com.generation.comnectar.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nomeProduto;
	
	@Size(max = 5000)
	private String fotoProduto;
	
	@Size(max = 1000)
	private String infoProduto;
	
	@NotNull
	@Positive
	@Digits(integer = 8, fraction = 2)
	private BigDecimal precoProduto;
	
	private String unidadeProduto;
	
	@Positive
	@Digits(integer = 7, fraction = 3)
	private BigDecimal estoqueProduto;
	
	private String chegadaProduto;
	
	private String shelfProduto;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Usuario usuario;

	public Produto() {
	}
	public Produto(Long id,String nomeProduto,String fotoProduto,
		String infoProduto,
		BigDecimal precoProduto,String unidadeProduto,
		BigDecimal estoqueProduto,  String chegadaProduto,
	String shelfProduto, Categoria categoria, Usuario usuario) {
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.fotoProduto = fotoProduto;
		this.infoProduto = infoProduto;
		this.precoProduto = precoProduto;
		this.unidadeProduto = unidadeProduto;
		this.estoqueProduto = estoqueProduto;
		this.chegadaProduto = chegadaProduto;
		this.shelfProduto = shelfProduto;
		this.categoria = categoria;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getFotoProduto() {
		return fotoProduto;
	}

	public void setFotoProduto(String fotoProduto) {
		this.fotoProduto = fotoProduto;
	}

	public String getInfoProduto() {
		return infoProduto;
	}

	public void setInfoProduto(String infoProduto) {
		this.infoProduto = infoProduto;
	}

	public BigDecimal getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(BigDecimal precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getUnidadeProduto() {
		return unidadeProduto;
	}

	public void setUnidadeProduto(String unidadeProduto) {
		this.unidadeProduto = unidadeProduto;
	}

	public BigDecimal getEstoqueProduto() {
		return estoqueProduto;
	}

	public void setEstoqueProduto(BigDecimal estoqueProduto) {
		this.estoqueProduto = estoqueProduto;
	}

	public String getChegadaProduto() {
		return chegadaProduto;
	}

	public void setChegadaProduto(String chegadaProduto) {
		this.chegadaProduto = chegadaProduto;
	}

	public String getShelfProduto() {
		return shelfProduto;
	}

	public void setShelfProduto(String shelfProduto) {
		this.shelfProduto = shelfProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}