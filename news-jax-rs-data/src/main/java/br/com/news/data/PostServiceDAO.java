package br.com.news.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public List<Post> listByAuthor(Long idAuthor, int pageSize ,int pageNum) {
		
		
		Map<String, Object> param = new HashMap<String,Object>();
		
		param.put("idAuthor",idAuthor);
		
		return super.listJPQL("SELECT P FROM Post P JOIN P.author A WHERE A.id=:idAuthor ", param, Post.class, pageSize, pageNum);
	}
	
	
	public List<Post> listByCategory(Long idCategory, int pageSize ,int pageNum) {
		
		Map<String, Object> param = new HashMap<String,Object>();
		
		param.put("idCategory",idCategory);
		
		return super.listJPQL("SELECT P FROM Post P JOIN P.category C WHERE C.id=:idCategory ", param, Post.class, pageSize, pageNum);
	}
	
	

}
