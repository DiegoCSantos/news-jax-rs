package br.com.news.business;

import java.util.List;

import br.com.news.data.PostServiceDAO;
import br.com.news.domain.Post;

public class PostService {
	
	private PostServiceDAO dao;
	

	public PostService() {
		this.dao = new PostServiceDAO();
	}

	public PostService(PostServiceDAO dao) {
		super();
		this.dao = dao;
	}
	
	
	public Post insert(Post post) {
		
		return dao.insert(post);
	}
	
	public Post update(Post post) {
		
		return dao.update(post);
	}
	
	
	public Post select(Long id) {
		
		return dao.select(id);
	}
	
	public void delete(Long id) {
		
		dao.delete(id);
	}
	
	public List<Post> list() {
		
		return dao.list();
	}
	


}
