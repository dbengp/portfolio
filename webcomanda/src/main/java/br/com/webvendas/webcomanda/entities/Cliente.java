package br.com.webvendas.webcomanda.entities;

import br.com.webvendas.webcomanda.entities.Pedido;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String contato;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Cliente(){

	}
	
	public Cliente( Long id,String nome,String email,String contato){
		
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.contato = contato;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email; 
	}
	
	public String getContato(){
		return contato;
	}
	
	public void setContato(String contato){
		this.contato = contato;
	}

	public List<Pedido> getPedidos(){
		return pedidos;
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Cliente cliente)) return false;

        return getId().equals(cliente.getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}
}