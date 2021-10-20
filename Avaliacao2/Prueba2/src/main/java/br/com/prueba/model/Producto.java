package br.com.prueba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String descricao;
	private String desconto;
	private String data_inicio;
	private String data_fim;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getData_fim() {
		return data_fim;
	}

	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}

	@Override
	public String toString() {
		return "Registro Producto \n[id= " + id + ",\n nome= " + nome + ",\n descricao= " + descricao + ",\n desconto= " + desconto
				+ ",\n data_inicio= " + data_inicio + ",\n data_fim= " + data_fim + "]\n------------------";
	}

}
