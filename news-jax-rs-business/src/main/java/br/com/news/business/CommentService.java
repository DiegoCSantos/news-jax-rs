package br.com.news.business;

import java.util.List;

import br.com.news.data.CommentServiceDAO;
import br.com.news.data.PostServiceDAO;
import br.com.news.domain.Comment;
import br.com.news.exception.Error;
import br.com.news.exception.NewsException;
import br.com.news.utils.ValidatorsUtils;

public class CommentService {
	
	private CommentServiceDAO dao;
	private PostServiceDAO postDao;
	
	private ValidatorsUtils validatorsUtils;
	

	public CommentService() {
		this.dao = new CommentServiceDAO();
		this.validatorsUtils=new ValidatorsUtils();
		this.postDao=new PostServiceDAO();
	}

    
	
	
	public CommentService(CommentServiceDAO dao) {
		super();
		this.validatorsUtils=new ValidatorsUtils();
		this.dao = dao;
	}


	public Comment insert(Comment comment) {
		validateInsertAndUpdate(comment, false) ;
		return dao.insert(comment);
	}
	
	public Comment update(Comment comment) {
		validateInsertAndUpdate(comment, true) ;
		return dao.update(comment);
	}
	
	public Comment select(Long id) {
		Comment comment =dao.select(id);
		if(validatorsUtils.isNullOrEmpty(comment)) {
			throw new NewsException(new Error().addErrorNotFound("Comment not found"));
		}
		return comment;
	}
	
	public void delete(Long id) {
		dao.delete(id);
	}
	
	public List<Comment> list() {
		
		return dao.list();
	}
	
	private void validateInsertAndUpdate(Comment comment, boolean idRequired) {
		Error error = new Error();
		
		if(idRequired && validatorsUtils.isNullOrEmpty(comment.getId())) {
			error.addErrorBadRequest("Comment id is required");
		}else if(!idRequired && !validatorsUtils.isNullOrEmpty(comment.getId())) {
			error.addErrorBadRequest("Comment id is required");
		}
		
		if(idRequired && validatorsUtils.isNullOrEmpty(dao.select(comment.getId()))) {
			error.addErrorBadRequest("Comment id is not found");
		}
		
		
		if(validatorsUtils.isNullOrEmpty(comment.getAuthor())) {
			error.addErrorBadRequest("Author is required");
		}
		
		if(validatorsUtils.isNullOrEmpty(comment.getContent())) {
			error.addErrorBadRequest("Content is required");
		}
		
		if(validatorsUtils.isNullOrEmpty(comment.getPost()) || 
				validatorsUtils.isNullOrEmpty(comment.getPost().getId())) {
			
			error.addErrorBadRequest("Post is required");
			
		}else if((!validatorsUtils.isNullOrEmpty(comment.getPost()) || 
				!validatorsUtils.isNullOrEmpty(comment.getPost().getId())) &&
				validatorsUtils.isNullOrEmpty(postDao.select(comment.getPost().getId()))) {
			
			error.addErrorBadRequest("Post is not found");
			
		}
		
		if(error.hasErrors())
			throw new NewsException(error);
	}
	
}
