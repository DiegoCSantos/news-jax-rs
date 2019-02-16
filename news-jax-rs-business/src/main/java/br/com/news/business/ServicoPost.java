package br.com.news.business;

import java.util.List;

import br.com.news.data.ServicoPostDAO;
import br.com.news.domain.Post;

public class ServicoPost {
	
	private ServicoPostDAO dao;

	public ServicoPost() {}

	public ServicoPost(ServicoPostDAO dao) {
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
		
		return dao.select(Post.class, id);
	}
	
	public void delete(Long id) {
		
		dao.delete(Post.class, id);
	}
	
	public List<Post> list() {
		
		return dao.list(Post.class);
	}
	


}
