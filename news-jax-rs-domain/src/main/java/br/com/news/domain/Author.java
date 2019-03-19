package br.com.news.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="AUTHOR")
public class Author {
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="BIO_SUMMARY")
	private String bioSummary;
	
	@Column(name="BIO", columnDefinition="VARCHAR(MAX)")
	private String bio;
	
	@Fetch(FetchMode.SELECT)
	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToMany(mappedBy="author", fetch = FetchType.LAZY)
	private List<Post> post;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}
	
	
	

}
