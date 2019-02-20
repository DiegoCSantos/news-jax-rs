package br.com.news.data;

import java.util.List;

import br.com.news.domain.Category;

public class CategoryServiceDAO extends AbstraticDAO<Category>{

	public Category select(Long id) {
		return super.select(Category.class, id);
	}

	public void delete(Long id) {
		super.delete(Category.class, id);
	}

	
	public List<Category> list() {
		return super.list(Category.class);
	}
	
	

}
