package br.com.news.data;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

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
	
	public List<T> list(Class<T> clazz){
		
		EntityManager em = factory.getEntityManager();
		return em.createQuery("select e from "+clazz.getName()+" e " , clazz).getResultList();
	}
	
	

}
