package br.com.news.business;

import java.util.List;

import br.com.news.data.ServicoCommentDAO;
import br.com.news.domain.Comment;

public class ServicoComment {
	
	private ServicoCommentDAO dao;

	public ServicoComment() {}

	public ServicoCommentDAO getDao() {
		return dao;
	}

	public void setDao(ServicoCommentDAO dao) {
		this.dao = dao;
	}
	
	
	public Comment insert(Comment comment) {
		
		return dao.insert(comment);
	}
	
	public Comment update(Comment comment) {
		
		return dao.update(comment);
	}
	
	public Comment select(Long id) {
		
		return dao.select(Comment.class,id);
	}
	
	public void delete(Long id) {
		dao.delete(Comment.class,id);
	}
	
	public List<Comment> list() {
		
		return dao.list(Comment.class);
	}

	
}
