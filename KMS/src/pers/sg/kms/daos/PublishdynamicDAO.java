package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Publishdynamic;

/**
 * A data access object (DAO) providing persistence and search support for
 * Publishdynamic entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Publishdynamic
 * @author MyEclipse Persistence Tools
 */
@Repository
public class PublishdynamicDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PublishdynamicDAO.class);
	// property constants

	public Publishdynamic save(Publishdynamic transientInstance) {
		log.debug("saving Publishdynamic instance");
		try {
			Transaction transaction = getSession().beginTransaction();
			getSession().save(transientInstance);
			transaction.commit();
			log.debug("save successful");
			getSession().close();
			return transientInstance;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Publishdynamic persistentInstance) {
		log.debug("deleting Publishdynamic instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Publishdynamic findById(Long id) {
		log.debug("getting Publishdynamic instance with id: " + id);
		try {
			Publishdynamic instance = (Publishdynamic) getSession().get("pers.sg.kms.model.Publishdynamic", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Publishdynamic instance) {
		log.debug("finding Publishdynamic instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Publishdynamic").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Publishdynamic instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Publishdynamic as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			List result = queryObject.list();
			getSession().close();
			return result;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Publishdynamic instances");
		try {
			String queryString = "from Publishdynamic";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Publishdynamic merge(Publishdynamic detachedInstance) {
		log.debug("merging Publishdynamic instance");
		try {
			Publishdynamic result = (Publishdynamic) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Publishdynamic instance) {
		log.debug("attaching dirty Publishdynamic instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Publishdynamic instance) {
		log.debug("attaching clean Publishdynamic instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}