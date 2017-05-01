package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Collectiondynamics;

/**
 * A data access object (DAO) providing persistence and search support for
 * Collectiondynamics entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Collectiondynamics
 * @author MyEclipse Persistence Tools
 */
@Repository
public class CollectiondynamicsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CollectiondynamicsDAO.class);
	// property constants

	public void save(Collectiondynamics transientInstance) {
		log.debug("saving Collectiondynamics instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Collectiondynamics persistentInstance) {
		log.debug("deleting Collectiondynamics instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Collectiondynamics findById(Long id) {
		log.debug("getting Collectiondynamics instance with id: " + id);
		try {
			Collectiondynamics instance = (Collectiondynamics) getSession().get("pers.sg.kms.model.Collectiondynamics",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Collectiondynamics instance) {
		log.debug("finding Collectiondynamics instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Collectiondynamics")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Collectiondynamics instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Collectiondynamics as model where model." + propertyName + "= ?";
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

	public List findAll() {
		log.debug("finding all Collectiondynamics instances");
		try {
			String queryString = "from Collectiondynamics";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Collectiondynamics merge(Collectiondynamics detachedInstance) {
		log.debug("merging Collectiondynamics instance");
		try {
			Collectiondynamics result = (Collectiondynamics) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Collectiondynamics instance) {
		log.debug("attaching dirty Collectiondynamics instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Collectiondynamics instance) {
		log.debug("attaching clean Collectiondynamics instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}