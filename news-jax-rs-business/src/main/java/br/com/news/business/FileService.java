package br.com.news.business;

import br.com.news.data.FileServiceDAO;
import br.com.news.domain.File;

public class FileService {
	
	private FileServiceDAO dao;

	public FileService(FileServiceDAO dao) {
		super();
		this.dao = dao;
	}

	public FileService() {
		super();
		this.dao = new FileServiceDAO();
	}
	
	public File insert(File file) {
		
		return dao.insert(file);
	}

	public File select(Long id) {
		
		return dao.select(id);
	}
	
	public void delete(Long id) {
		
		dao.delete(id);
	}
	

}
