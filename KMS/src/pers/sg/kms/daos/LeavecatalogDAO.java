package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Leavecatalog;

/**
 * A data access object (DAO) providing persistence and search support for
 * Leavecatalog entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Leavecatalog
 * @author MyEclipse Persistence Tools
 */
@Repository
public class LeavecatalogDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(LeavecatalogDAO.class);
	// property constants
	public static final String LEAVE_CATALOG_NAME = "leaveCatalogName";

	public void save(Leavecatalog transientInstance) {
		log.debug("saving Leavecatalog instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Leavecatalog persistentInstance) {
		log.debug("deleting Leavecatalog instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Leavecatalog findById(Short id) {
		log.debug("getting Leavecatalog instance with id: " + id);
		try {
			Leavecatalog instance = (Leavecatalog) getSession().get("pers.sg.kms.model.Leavecatalog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Leavecatalog instance) {
		log.debug("finding Leavecatalog instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Leavecatalog").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Leavecatalog instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Leavecatalog as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			List results = queryObject.list();
			getSession().close();
			return results;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLeaveCatalogName(Object leaveCatalogName) {
		return findByProperty(LEAVE_CATALOG_NAME, leaveCatalogName);
	}

	public List findAll() {
		log.debug("finding all Leavecatalog instances");
		try {
			String queryString = "from Leavecatalog";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Leavecatalog merge(Leavecatalog detachedInstance) {
		log.debug("merging Leavecatalog instance");
		try {
			Leavecatalog result = (Leavecatalog) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Leavecatalog instance) {
		log.debug("attaching dirty Leavecatalog instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Leavecatalog instance) {
		log.debug("attaching clean Leavecatalog instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}