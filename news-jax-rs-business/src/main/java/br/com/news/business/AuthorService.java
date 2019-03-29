package br.com.news.business;

import java.util.List;

import br.com.news.data.AuthorServiceDAO;
import br.com.news.domain.Author;
import br.com.news.exception.Error;
import br.com.news.exception.NewsException;
import br.com.news.utils.ValidatorsUtils;

public class AuthorService {
	
	private AuthorServiceDAO dao;
	private ValidatorsUtils validatorsUtils;

	public AuthorService() {
		this.validatorsUtils=new ValidatorsUtils();
		this.dao =new AuthorServiceDAO();
	}

	public AuthorService(AuthorServiceDAO dao) {
		super();
		this.validatorsUtils=new ValidatorsUtils();
		this.dao = dao;
	}
	
	
	public Author insert(Author author) {
		validateInsertAndUpdate(author, false);
		return dao.insert(author);
	}
	
	
	public Author update(Author author) {
		validateInsertAndUpdate(author, true);
		return dao.update(author);
	}
	
	
	public Author select(Long id) {
		Author author = dao.select(id);
		if(validatorsUtils.isNullOrEmpty(author)) {
			throw new NewsException(new Error().addErrorNotFound("Author not found"));
		}
		return author;
	}
	
	public void delete(Long id) {
		 dao.delete(id);
	}
	
	
	public List<Author> list() {
		 return dao.list();
	}

	
	private void validateInsertAndUpdate(Author author, boolean idRequired) {
		Error error = new Error();
		
		if(idRequired && validatorsUtils.isNullOrEmpty(author.getId())) {
			error.addErrorBadRequest("Author id is required");
		}else if(idRequired && validatorsUtils.isNullOrEmpty(dao.select(author.getId()))) {
			error.addErrorBadRequest("Author id not Found");
		}	
		
		
		if(!idRequired && !validatorsUtils.isNullOrEmpty(author.getId())) {
			error.addErrorBadRequest("Author id is not required");
		}
		
		if(validatorsUtils.isNullOrEmpty(author.getName())) {
			error.addErrorBadRequest("Name is required");
		}
		if(validatorsUtils.isNullOrEmpty(author.getEmail())) {
			error.addErrorBadRequest("Email is required");
		}
		
		if(error.hasErrors())
			throw new NewsException(error);
	}
	
	
}
