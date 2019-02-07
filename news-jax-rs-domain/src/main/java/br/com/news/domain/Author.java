package br.com.news.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Author {
	
	@Id
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String bioSummary;
	
	@Column
	private String bio;
	
	@OneToMany
	private List<Post> posts;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getBioSummary() {
		return bioSummary;
	}
	public void setBioSummary(String bioSummary) {
		this.bioSummary = bioSummary;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	
	

}
