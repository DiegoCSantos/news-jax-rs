package br.com.news.business;

import java.util.List;

import br.com.news.data.ServicoCategoryDAO;
import br.com.news.domain.Category;

public class ServicoCategory {
	
	private ServicoCategoryDAO dao;

	public ServicoCategory() {}
	
	public ServicoCategory(ServicoCategoryDAO dao) {
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
		
		return dao.select(Category.class,id);
	}
	
	public void delete(Long id) {
		dao.delete(Category.class, id);
	}
	
	
	public List<Category> list(){
		return dao.list(Category.class);
	}
	

}
