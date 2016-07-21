package dao;

import java.util.*; 

public interface CategoryDAO {

	public List<Category> list();
	public Category get(String id);
	public void saveOrUpdate(Category category);
	public void delete(String id);
	
}
