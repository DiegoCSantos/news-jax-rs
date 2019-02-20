package br.com.news.data;

import java.util.List;

import br.com.news.domain.Post;

public class PostServiceDAO extends AbstraticDAO<Post>{

	public Post select(Long id) {
		return super.select(Post.class, id);
	}

	public void delete(Long id) {
		super.delete(Post.class, id);
	}

	public List<Post> list() {
		return super.list(Post.class);
	}
	
	

}
