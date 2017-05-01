package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Manageclassroom;

/**
 * A data access object (DAO) providing persistence and search support for
 * Manageclassroom entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Manageclassroom
 * @author MyEclipse Persistence Tools
 */
@Repository
public class ManageclassroomDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ManageclassroomDAO.class);
	// property constants

	public void save(Manageclassroom transientInstance) {
		log.debug("saving Manageclassroom instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Manageclassroom persistentInstance) {
		log.debug("deleting Manageclassroom instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Manageclassroom findById(Long id) {
		log.debug("getting Manageclassroom instance with id: " + id);
		try {
			Manageclassroom instance = (Manageclassroom) getSession().get("pers.sg.kms.model.Manageclassroom", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Manageclassroom instance) {
		log.debug("finding Manageclassroom instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Manageclassroom")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Manageclassroom instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Manageclassroom as model where model." + propertyName + "= ?";
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
		log.debug("finding all Manageclassroom instances");
		try {
			String queryString = "from Manageclassroom";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Manageclassroom merge(Manageclassroom detachedInstance) {
		log.debug("merging Manageclassroom instance");
		try {
			Manageclassroom result = (Manageclassroom) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Manageclassroom instance) {
		log.debug("attaching dirty Manageclassroom instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Manageclassroom instance) {
		log.debug("attaching clean Manageclassroom instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}