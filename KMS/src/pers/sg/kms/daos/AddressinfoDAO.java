package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Addressinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Addressinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Addressinfo
 * @author MyEclipse Persistence Tools
 */
@Repository
public class AddressinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AddressinfoDAO.class);
	// property constants
	public static final String ADDRESS_NAME = "addressName";
	public static final String IS_USUALLY_ADDRESS = "isUsuallyAddress";

	public Addressinfo save(Addressinfo transientInstance) {
		log.debug("saving Addressinfo instance");
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

	public Addressinfo delete(Addressinfo persistentInstance) {
		log.debug("deleting Addressinfo instance");
		try {
			Transaction transaction = getSession().beginTransaction();
			getSession().delete(persistentInstance);
			transaction.commit();
			log.debug("delete successful");
			getSession().close();
			return persistentInstance;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Addressinfo findById(Long id) {
		log.debug("getting Addressinfo instance with id: " + id);
		try {
			Addressinfo instance = (Addressinfo) getSession().get("pers.sg.kms.model.Addressinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Addressinfo instance) {
		log.debug("finding Addressinfo instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Addressinfo").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Addressinfo instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Addressinfo as model where model." + propertyName + "= ?";
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

	public List findByAddressName(Object addressName) {
		return findByProperty(ADDRESS_NAME, addressName);
	}

	public List findByIsUsuallyAddress(Object isUsuallyAddress) {
		return findByProperty(IS_USUALLY_ADDRESS, isUsuallyAddress);
	}

	public List findAll() {
		log.debug("finding all Addressinfo instances");
		try {
			String queryString = "from Addressinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Addressinfo merge(Addressinfo detachedInstance) {
		log.debug("merging Addressinfo instance");
		try {
			Addressinfo result = (Addressinfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Addressinfo instance) {
		log.debug("attaching dirty Addressinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Addressinfo instance) {
		log.debug("attaching clean Addressinfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}