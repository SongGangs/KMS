package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Commentdetail;

/**
 * A data access object (DAO) providing persistence and search support for
 * Commentdetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Commentdetail
 * @author MyEclipse Persistence Tools
 */
@Repository
public class CommentdetailDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CommentdetailDAO.class);
	// property constants
	public static final String CONTENT = "content";

	public Commentdetail save(Commentdetail transientInstance) {
		log.debug("saving Commentdetail instance");
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

	public void delete(Commentdetail persistentInstance) {
		log.debug("deleting Commentdetail instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Commentdetail findById(Long id) {
		log.debug("getting Commentdetail instance with id: " + id);
		try {
			Commentdetail instance = (Commentdetail) getSession().get("pers.sg.kms.model.Commentdetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Commentdetail instance) {
		log.debug("finding Commentdetail instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Commentdetail").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Commentdetail instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Commentdetail as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			List resList = queryObject.list();
			getSession().close();
			return resList;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all Commentdetail instances");
		try {
			String queryString = "from Commentdetail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Commentdetail merge(Commentdetail detachedInstance) {
		log.debug("merging Commentdetail instance");
		try {
			Commentdetail result = (Commentdetail) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Commentdetail instance) {
		log.debug("attaching dirty Commentdetail instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Commentdetail instance) {
		log.debug("attaching clean Commentdetail instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}