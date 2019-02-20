package br.com.news.business;

import java.util.List;

import br.com.news.data.CommentServiceDAO;
import br.com.news.domain.Comment;

public class CommentService {
	
	private CommentServiceDAO dao;

	public CommentService() {
		this.dao = new CommentServiceDAO();
	}

    
	
	
	public CommentService(CommentServiceDAO dao) {
		super();
		this.dao = dao;
	}


	public Comment insert(Comment comment) {
		
		return dao.insert(comment);
	}
	
	public Comment update(Comment comment) {
		
		return dao.update(comment);
	}
	
	public Comment select(Long id) {
		
		return dao.select(id);
	}
	
	public void delete(Long id) {
		dao.delete(id);
	}
	
	public List<Comment> list() {
		
		return dao.list();
	}

	
}
