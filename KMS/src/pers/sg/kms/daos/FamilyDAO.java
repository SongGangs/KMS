package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Family;

/**
 * A data access object (DAO) providing persistence and search support for
 * Family entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Family
 * @author MyEclipse Persistence Tools
 */
@Repository
public class FamilyDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(FamilyDAO.class);
	// property constants
	public static final String FAMILY_NAME = "familyName";

	public Family save(Family transientInstance) {
		log.debug("saving Family instance");
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

	public void delete(Family persistentInstance) {
		log.debug("deleting Family instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Family findById(Long id) {
		log.debug("getting Family instance with id: " + id);
		try {
			Family instance = (Family) getSession().get("pers.sg.kms.model.Family", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Family instance) {
		log.debug("finding Family instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Family").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Family instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Family as model where model." + propertyName + "= ?";
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

	public List findByFamilyName(Object familyName) {
		return findByProperty(FAMILY_NAME, familyName);
	}

	public List findAll() {
		log.debug("finding all Family instances");
		try {
			String queryString = "from Family";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Family merge(Family detachedInstance) {
		log.debug("merging Family instance");
		try {
			Family result = (Family) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Family instance) {
		log.debug("attaching dirty Family instance");
		try {
			Transaction transaction = getSession().beginTransaction();
			getSession().saveOrUpdate(instance);
			transaction.commit();
			log.debug("attach successful");
			getSession().close();
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Family instance) {
		log.debug("attaching clean Family instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}