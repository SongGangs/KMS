package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Usercatalog;

/**
 * A data access object (DAO) providing persistence and search support for
 * Usercatalog entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Usercatalog
 * @author MyEclipse Persistence Tools
 */
@Repository
public class UsercatalogDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(UsercatalogDAO.class);
	// property constants
	public static final String USER_CATALOG_NAME = "userCatalogName";

	public void save(Usercatalog transientInstance) {
		log.debug("saving Usercatalog instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Usercatalog persistentInstance) {
		log.debug("deleting Usercatalog instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Usercatalog findById(Short id) {
		log.debug("getting Usercatalog instance with id: " + id);
		try {
			Usercatalog instance = (Usercatalog) getSession().get("pers.sg.kms.model.Usercatalog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Usercatalog instance) {
		log.debug("finding Usercatalog instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Usercatalog").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Usercatalog instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Usercatalog as model where model." + propertyName + "= ?";
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

	public List findByUserCatalogName(Object userCatalogName) {
		return findByProperty(USER_CATALOG_NAME, userCatalogName);
	}

	public List findAll() {
		log.debug("finding all Usercatalog instances");
		try {
			String queryString = "from Usercatalog";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Usercatalog merge(Usercatalog detachedInstance) {
		log.debug("merging Usercatalog instance");
		try {
			Usercatalog result = (Usercatalog) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Usercatalog instance) {
		log.debug("attaching dirty Usercatalog instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Usercatalog instance) {
		log.debug("attaching clean Usercatalog instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}