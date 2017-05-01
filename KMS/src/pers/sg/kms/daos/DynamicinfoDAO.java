package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Dynamicinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Dynamicinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Dynamicinfo
 * @author MyEclipse Persistence Tools
 */
@Repository
public class DynamicinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(DynamicinfoDAO.class);
	// property constants
	public static final String CONTENT = "content";
	public static final String IS_ALLOW = "isAllow";
	public static final String AUTHORITY = "authority";

	public Dynamicinfo save(Dynamicinfo transientInstance) {
		log.debug("saving Dynamicinfo instance");
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

	public void delete(Dynamicinfo persistentInstance) {
		log.debug("deleting Dynamicinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Dynamicinfo findById(Long id) {
		log.debug("getting Dynamicinfo instance with id: " + id);
		try {
			Dynamicinfo instance = (Dynamicinfo) getSession().get("pers.sg.kms.model.Dynamicinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Dynamicinfo instance) {
		log.debug("finding Dynamicinfo instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Dynamicinfo").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Dynamicinfo instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Dynamicinfo as model where model." + propertyName + "= ?";
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

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByIsAllow(Object isAllow) {
		return findByProperty(IS_ALLOW, isAllow);
	}

	public List findByAuthority(Object authority) {
		return findByProperty(AUTHORITY, authority);
	}

	public List findAll() {
		log.debug("finding all Dynamicinfo instances");
		try {
			String queryString = "from Dynamicinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Dynamicinfo merge(Dynamicinfo detachedInstance) {
		log.debug("merging Dynamicinfo instance");
		try {
			Dynamicinfo result = (Dynamicinfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Dynamicinfo instance) {
		log.debug("attaching dirty Dynamicinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dynamicinfo instance) {
		log.debug("attaching clean Dynamicinfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}