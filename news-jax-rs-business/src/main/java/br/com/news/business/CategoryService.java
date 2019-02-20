package br.com.news.business;

import java.util.List;

import br.com.news.data.CategoryServiceDAO;
import br.com.news.domain.Category;

public class CategoryService {
	
	private CategoryServiceDAO dao;

	public CategoryService() {
		
		this.dao = new CategoryServiceDAO();
	}
	
	public CategoryService(CategoryServiceDAO dao) {
		super();
		this.dao = dao;
	}

	
	public Category insert(Category category) {
		
		return dao.insert(category);
	}
	
	public Category update(Category category) {
		
		return dao.update(category);
	}
	
	
	public Category select(Long id) {
		
		return dao.select(id);
	}
	
	public void delete(Long id) {
		dao.delete(id);
	}
	
	
	public List<Category> list(){
		return dao.list();
	}
	

}
