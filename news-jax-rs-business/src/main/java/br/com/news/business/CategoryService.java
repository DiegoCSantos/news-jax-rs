package br.com.news.business;

import java.util.List;

import br.com.news.data.CategoryServiceDAO;
import br.com.news.domain.Category;
import br.com.news.exception.Error;
import br.com.news.exception.NewsException;
import br.com.news.utils.ValidatorsUtils;

public class CategoryService {
	
	private CategoryServiceDAO dao;
	private ValidatorsUtils validatorsUtils;

	public CategoryService() {
		this.validatorsUtils=new ValidatorsUtils();
		this.dao = new CategoryServiceDAO();
	}
	
	public CategoryService(CategoryServiceDAO dao) {
		super();
		this.dao = dao;
	}

	
	public Category insert(Category category) {
		validateInsertAndUpdate(category, false);
		return dao.insert(category);
	}
	
	public Category update(Category category) {
		validateInsertAndUpdate(category, true);
		return dao.update(category);
	}
	
	
	public Category select(Long id) {
		Category category =dao.select(id);
		if(validatorsUtils.isNullOrEmpty(category)) {
			throw new NewsException(new Error().addErrorNotFound("Category not found"));
		}
		return category;
	}
	
	public void delete(Long id) {
		dao.delete(id);
	}
	
	
	public List<Category> list(){
		return dao.list();
	}
	
	private void validateInsertAndUpdate(Category category, boolean idRequired) {
		Error error = new Error();
		
		if(idRequired && validatorsUtils.isNullOrEmpty(category.getId())) {
			error.addErrorBadRequest("Id is required");
		}else if(!idRequired && !validatorsUtils.isNullOrEmpty(category.getId())) {
			error.addErrorBadRequest("Id is not required");
		}
		
		if(idRequired && validatorsUtils.isNullOrEmpty(category.getName())) {
			error.addErrorBadRequest("Name is required");
		}
		
		if(idRequired && validatorsUtils.isNullOrEmpty(category.getSummary())) {
			error.addErrorBadRequest("Summary is required");
		}
		
		if(error.hasErrors())
			throw new NewsException(error);
	}
	

}
