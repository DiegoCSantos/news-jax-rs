package br.com.news.business;

import java.util.List;

import br.com.news.data.AuthorServiceDAO;
import br.com.news.domain.Author;

public class AuthorService {
	
	private AuthorServiceDAO dao;

	public AuthorService() {
		this.dao =new AuthorServiceDAO();
	}

	public AuthorService(AuthorServiceDAO dao) {
		super();
		this.dao = dao;
	}
	
	
	public Author insert(Author author) {
		
		return dao.insert(author);
	}
	
	
	public Author update(Author author) {
		
		return dao.update(author);
	}
	
	
	public Author select(Long id) {
		
		return dao.select(id);
	}
	
	public void delete(Long id) {
		 dao.delete(id);
	}
	
	
	public List<Author> list() {
		 return dao.list();
	}

}
