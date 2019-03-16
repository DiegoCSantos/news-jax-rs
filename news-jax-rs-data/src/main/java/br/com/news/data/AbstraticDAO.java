package br.com.news.data;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class AbstraticDAO <T> {
	
	private EntityManagerFactory factory;
	
	AbstraticDAO(){
		this.factory = new EntityManagerFactory();
	}
	
	public T insert(T entity) {
		
		EntityManager em = factory.getEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.flush();
		em.getTransaction().commit();
		
		return entity;
	}
	
	public T update(T entity) {
		
		EntityManager em = factory.getEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.flush();
		em.getTransaction().commit();
		
		return entity;
	}
	
	public T select(Class<T> clazz, Long id) {
		EntityManager em = factory.getEntityManager();
		return em.find(clazz, id);
	}
	
	public void delete(Class<T> clazz, Long id) {
		
		EntityManager em = factory.getEntityManager();
		em.getTransaction().begin();
		T entity = em.find(clazz, id);
		em.remove(entity);
		em.flush();
		em.getTransaction().commit();
	}
	
	protected List<T> list(Class<T> clazz){
		
		EntityManager em = factory.getEntityManager();
		return em.createQuery("select e from "+clazz.getName()+" e " , clazz).getResultList();
	}
	
	protected List<T> listJPql(String  query, Class<T> clazz){
		return listJPQL(query, null, clazz,null, null);
	}
	
	
	protected List<T> listJPQL(String  query, Map<String,?> params, Class<T> clazz){
		return listJPQL(query, params, clazz,null, null);
	}
	
	
	protected List<T> listJPQL(String  query, Map<String,?> params, Class<T> clazz,Integer  pageSize, Integer pageNum){
		EntityManager em = factory.getEntityManager();
		
		  Query q = em.createQuery(query, clazz);
		  
		  if(params!=null)
			  params.keySet().forEach(k-> {
				  q.setParameter(k, params.get(k));
			  });
		  
		  if(pageSize !=null)
			  q.setMaxResults(pageSize);
		  
		  if(pageNum !=null && pageSize != null)
			  q.setFirstResult(pageNum * pageSize);
		  
		return  q.getResultList();
	}
	
	

}
