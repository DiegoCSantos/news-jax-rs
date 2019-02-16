package br.com.news.business;

import java.util.List;

import br.com.news.data.ServicoAuthorDAO;
import br.com.news.domain.Author;

public class ServicoAuthor {
	
	private ServicoAuthorDAO dao;

	public ServicoAuthor() {}

	public ServicoAuthor(ServicoAuthorDAO dao) {
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
		
		return dao.select(Author.class, id);
	}
	
	public void delete(Long id) {
		 dao.delete(Author.class, id);
	}
	
	
	public List<Author> list() {
		 return dao.list(Author.class);
	}

}
