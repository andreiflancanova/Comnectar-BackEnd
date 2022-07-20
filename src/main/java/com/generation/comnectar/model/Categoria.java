package com.generation.comnectar.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//Opções: Frutas,Verduras,Legumes;
	@NotNull
	//@Column(name="classe_categoria") - Para modificar o nome no banco de dados
	private String classeCategoria;
	
	//Opções: Familiar,Agroecológica,Orgânica,Sintrópica;
	@NotNull
	private String modProdCategoria;
	
	@NotNull
	private boolean frescorCategoria;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produtos;

	

	public Categoria() {
	}

	
	public Categoria(Long id, String classeCategoria, String modProdCategoria,
		boolean frescorCategoria, List<Produto> produtos) {
		this.id = id;
		this.classeCategoria = classeCategoria;
		this.modProdCategoria = modProdCategoria;
		this.frescorCategoria = frescorCategoria;
		this.produtos = produtos;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClasseCategoria() {
		return classeCategoria;
	}

	public void setClasseCategoria(String classeCategoria) {
		this.classeCategoria = classeCategoria;
	}

	public String getModProdCategoria() {
		return modProdCategoria;
	}

	public void setModProdCategoria(String modprodCategoria) {
		this.modProdCategoria = modprodCategoria;
	}

	public boolean getFrescorCategoria() {
		return frescorCategoria;
	}

	public void setFrescorCategoria(boolean frescorCategoria) {
		this.frescorCategoria = frescorCategoria;
	}

}
