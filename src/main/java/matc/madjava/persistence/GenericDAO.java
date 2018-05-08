package matc.madjava.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenericDAO<T> {
    private Class<T> type;
    private final Logger log = LogManager.getLogger(this.getClass());

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    /**
     * gets sessionfactoryprovider session
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * This generic method gets object by ID
     * @param id id of object
     * @param <T> type
     * @return T
     */
    public <T>T getByID(int id) {
        Session session = getSession();
        T entity = (T)session.get( type, id );
        session.close();
        return entity;
    }

    /**
     * * This generic method deletes object by its parameter
     * @param entity passed object
     */
    public void delete( T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * * This generic method gets all of the desired object
     * @return List<T>
     */
    public List<T> getAll() {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        List<T> entity = session.createQuery( query ).getResultList();

        log.debug("The list of entity type " + entity);
        session.close();

        return entity;
    }

    /**
     * This generic method inserts a new object
     *
     * @param entity object
     * @return id
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (Integer)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * This generic method updates an existing object
     *
     * @param entity passed object
     */
    public void update(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * This generic method gets all objects with equal property name and value
     * @param propertyName entity property name
     * @param value value to search by
     * @return List<T>
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {
        Session session = getSession();

        log.debug("Searching for " + type + " with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entities = session.createQuery( query ).getResultList();

        session.close();
        return entities;
    }

    /**
     * Generic method that gets entities that are like a passed string based on a property name
     *
     * @param propertyName entity property name
     * @param value value to query by
     * @return List<T>
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        log.debug("Searching for user with {} = {}, " + propertyName + ", " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> entities = session.createQuery( query ).getResultList();
        session.close();
        return entities;
    }

    /**
     * This generic method That gets a single object by property name and a value
     * @param propertyName entity property name
     * @param value value to query by
     * @return entity
     */
    public T getByPropertyEqualUnique(String propertyName, String value) {
        Session session = getSession();

        log.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        T entity = session.createQuery( query ).getSingleResult();

        session.close();
        return entity;
    }

    /**
     * This generic method that returns all but specified entity with specified property name
     * @param propertyName entity property name
     * @param value value to query by
     * @return entities
     */
    public List<T> getAllExceptEntity(String propertyName, String value) {
        Session session = getSession();

        log.debug("Searching for " + type + " with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        query.select(root).where(builder.notEqual(root.get(propertyName), value));
        List<T> entities = session.createQuery( query ).getResultList();

        session.close();
        return entities;
    }

    public List<T> getByPropertyEqualObject(String propertyName, T value) {
        Session session = getSession();

        log.debug("Searching for Object: " + type + " with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entities = session.createQuery( query ).getResultList();

        session.close();
        return entities;
    }

}
