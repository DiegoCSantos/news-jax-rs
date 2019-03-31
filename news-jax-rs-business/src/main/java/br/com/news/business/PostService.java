package br.com.news.business;

import java.util.List;

import br.com.news.data.AuthorServiceDAO;
import br.com.news.data.CategoryServiceDAO;
import br.com.news.data.PostServiceDAO;
import br.com.news.domain.Post;
import br.com.news.exception.Error;
import br.com.news.exception.NewsException;
import br.com.news.utils.ValidatorsUtils;

public class PostService {
	
	private PostServiceDAO dao;
	private AuthorServiceDAO authorDao;
	private CategoryServiceDAO categoryDao;
	private ValidatorsUtils validatorsUtils;

	public PostService() {
		this.dao = new PostServiceDAO();
		this.authorDao = new AuthorServiceDAO();
		this.categoryDao = new CategoryServiceDAO();
		this.validatorsUtils=new ValidatorsUtils();
	}

	public PostService(PostServiceDAO dao) {
		super();
		this.dao = dao;
		this.authorDao = new AuthorServiceDAO();
		this.categoryDao = new CategoryServiceDAO();
		this.validatorsUtils=new ValidatorsUtils();
	}
	
	
	public Post insert(Post post) {
		validateInsertAndUpdate(post, false);
		return dao.insert(post);
	}
	
	public Post update(Post post) {
		validateInsertAndUpdate(post, true);
		return dao.update(post);
	}
	
	
	public Post select(Long id) {
		Post post=dao.select(id); 
		if(validatorsUtils.isNullOrEmpty(post)) {
			throw new NewsException(new Error().addErrorNotFound("Post not found"));
		}
		return post;
	}
	
	public void delete(Long id) {
		dao.delete(id);
	}
	
	public List<Post> list() {
		
		return 	dao.list();
	}
	
	public List<Post> listByAuthor(Long idAuthor, int pageSize, int pageNum) {
		Error error  = new Error();
		
		if(validatorsUtils.isNullOrEmpty(idAuthor)) {
			error.addErrorBadRequest(" Id Author is required");
		}else if(validatorsUtils.isNullOrEmpty(authorDao.select(idAuthor))){
			error.addErrorBadRequest(" Id Author not found");
		}
		
		if(error.hasErrors()) {
			throw new NewsException(error);
		}		
		
		return dao.listByAuthor(idAuthor, pageSize, pageNum);
	}
	
	public List<Post> listByCategory(Long idCategory, int pageSize, int pageNum) {
		Error error  = new Error();
		
		if(validatorsUtils.isNullOrEmpty(idCategory)) {
			error.addErrorBadRequest(" Id Category is required");
			
		}else if(validatorsUtils.isNullOrEmpty(categoryDao.select(idCategory))){
			error.addErrorBadRequest(" Id Category not found");
		}
		
		if(error.hasErrors()) {
			throw new NewsException(error);
		}		
		
		
		return dao.listByCategory(idCategory, pageSize, pageNum);
	}
	
	
	
	private void validateInsertAndUpdate(Post post, boolean idRequired) {
		
		Error error = new Error();
		
		if(idRequired && validatorsUtils.isNullOrEmpty(post.getId())) {
			throw new NewsException(new Error()
					.addErrorBadRequest( "Post id is required"));
		
		}else if(idRequired && validatorsUtils.isNullOrEmpty(dao.select(post.getId()))) {
			throw new NewsException(new Error()
					.addErrorBadRequest( "Post not Found"));
		}
		
		if(!idRequired && !validatorsUtils.isNullOrEmpty(post.getId())) {
			throw new NewsException(new Error()
					.addErrorBadRequest( "Post id is not required"));
		}
			
		if(validatorsUtils.isNullOrEmpty(post.getTitle())) {
			error.addErrorBadRequest("Title is required");
		}
		
		if(validatorsUtils.isNullOrEmpty(post.getContent())) {
			error.addErrorBadRequest("Content is required");
		}
		
		if(validatorsUtils.isNullOrEmpty(post.getSummary())) {
			error.addErrorBadRequest("Summary is required");
		}
		
		if(validatorsUtils.isNullOrEmpty(post.getAuthor())) {
			error.addErrorMessage("Author is required");
		}
		
		if(!validatorsUtils.isNullOrEmpty(post.getAuthor()) && 
				validatorsUtils.isNullOrEmpty(authorDao.select(post.getAuthor().getId()))) {
			error.addErrorBadRequest("Author not found");
		}
		
		
		if(!validatorsUtils.isNullOrEmpty(post.getCategory())) {
			post.getCategory().forEach(c->{
				if(!validatorsUtils.isNullOrEmpty(c.getId())) {
					if(!validatorsUtils.isNullOrEmpty(categoryDao.select(c.getId())))
						error.addErrorBadRequest("Category not found");
					
				}else {
					error.addErrorBadRequest("Category is required");
				}
			});
		}
		
		if(error.hasErrors()) {
			throw new NewsException(error);
		}
		
	}
	

}
