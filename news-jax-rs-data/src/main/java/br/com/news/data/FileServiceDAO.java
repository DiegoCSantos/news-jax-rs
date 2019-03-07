package br.com.news.data;

import br.com.news.domain.File;

public class FileServiceDAO extends AbstraticDAO<File>{
	
	public File select(Long id) {
		return super.select(File.class, id);
	}

	public void delete(Long id) {
		super.delete(File.class, id);
	}

}
