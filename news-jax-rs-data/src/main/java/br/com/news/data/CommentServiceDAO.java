package br.com.news.data;

import java.util.List;

import br.com.news.domain.Comment;

public class CommentServiceDAO extends AbstraticDAO<Comment> {

	public Comment select(Long id) {
		return super.select(Comment.class, id);
	}

	public void delete(Long id) {
		super.delete(Comment.class, id);
	}

	public List<Comment> list() {
		return super.list(Comment.class);
	}
	
	

}
