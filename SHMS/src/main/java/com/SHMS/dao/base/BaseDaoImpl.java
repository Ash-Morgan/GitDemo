package com.SHMS.dao.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {
  
    private Class<T> clazz;

    public BaseDaoImpl() {  
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
    }  

    @Resource
    private SessionFactory sessionFactory;


    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
  
    public void save(T entity) {  
        this.getSession().save(entity);  
    }  
  
    public void update(T entity) {  
        this.getSession().update(entity);  
    }  
  
    public void delete(Serializable id) {
        this.getSession().delete(this.findById(id));  
    }  
  
    public T findById(Serializable id) {
        return (T) this.getSession().get(this.clazz, id);  
    }  
  
    public List<T> findByHQL(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);  
        for (int i = 0; params != null && i < params.length; i++) {  
            query.setParameter(i, params);  
        }  
        return query.list();  
    }  
    public List<T> findAllByHQL(String hql) {
        Query query = this.getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<T> listPage(String hql,int offset, int rows) {
        Query query = this.getSession().createQuery(hql);
        query.setFirstResult(offset);
        query.setMaxResults(rows);
        return query.list();
    }


}  
