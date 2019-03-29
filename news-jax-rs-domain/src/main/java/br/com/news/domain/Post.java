package br.com.news.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="POST")
public class Post {
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Long id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="SUMMARY")
	private String summary;
	
	@Column(name="CONTENT", columnDefinition="VARCHAR(MAX)")
	
	private String content;
	
	@ManyToOne()
	@JoinColumn(name="AUTHOR_ID")
	private Author author;
	
	@Column(name="DATE")
	private Date date;
	
	@OneToMany(mappedBy="post", fetch = FetchType.LAZY)
	private List<Comment> comment;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="POST_CATEGORY", joinColumns= {@JoinColumn(name="POST_ID")}, inverseJoinColumns= {@JoinColumn(name="CATEGORY_ID")})
	private List<Category> category;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comments) {
		this.comment = comments;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	
	
	

}
