package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Privateletter;

/**
 * A data access object (DAO) providing persistence and search support for
 * Privateletter entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Privateletter
 * @author MyEclipse Persistence Tools
 */
@Repository
public class PrivateletterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PrivateletterDAO.class);
	// property constants
	public static final String SENDER = "sender";
	public static final String ACCEPTER = "accepter";
	public static final String CONTENT = "content";
	public static final String IS_READ = "isRead";

	public void save(Privateletter transientInstance) {
		log.debug("saving Privateletter instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Privateletter persistentInstance) {
		log.debug("deleting Privateletter instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Privateletter findById(Long id) {
		log.debug("getting Privateletter instance with id: " + id);
		try {
			Privateletter instance = (Privateletter) getSession().get("pers.sg.kms.model.Privateletter", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Privateletter instance) {
		log.debug("finding Privateletter instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Privateletter").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Privateletter instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Privateletter as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySender(Object sender) {
		return findByProperty(SENDER, sender);
	}

	public List findByAccepter(Object accepter) {
		return findByProperty(ACCEPTER, accepter);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByIsRead(Object isRead) {
		return findByProperty(IS_READ, isRead);
	}

	public List findAll() {
		log.debug("finding all Privateletter instances");
		try {
			String queryString = "from Privateletter";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Privateletter merge(Privateletter detachedInstance) {
		log.debug("merging Privateletter instance");
		try {
			Privateletter result = (Privateletter) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Privateletter instance) {
		log.debug("attaching dirty Privateletter instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Privateletter instance) {
		log.debug("attaching clean Privateletter instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}