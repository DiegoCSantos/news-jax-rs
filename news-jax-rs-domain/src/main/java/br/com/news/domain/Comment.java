package br.com.news.domain;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Comment {
	
	private Long id;
	private String author;
	private String email;
	private String content;
	
	@ManyToOne
	private Post post;
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
       
	
	

}
