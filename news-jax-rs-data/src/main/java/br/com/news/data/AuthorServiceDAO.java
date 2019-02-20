package br.com.news.data;

import java.util.List;

import br.com.news.domain.Author;

public class AuthorServiceDAO extends AbstraticDAO<Author>{

	public Author select(Long id) {
		return super.select(Author.class, id);
	}

	public void delete(Long id) {
		super.delete(Author.class, id);
	}

	public List<Author> list() {
		return super.list(Author.class);
	}
	
	

}
