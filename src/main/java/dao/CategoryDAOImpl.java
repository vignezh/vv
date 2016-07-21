package dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;

@Repository("categoryDAO")

public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public List<Category> list()
	{
		@SuppressWarnings("unchecked")
		List<Category> listCategory=(List<Cateogry>)
		sessionFactory.getCurrentSession()
		.createCriteria(Category.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
