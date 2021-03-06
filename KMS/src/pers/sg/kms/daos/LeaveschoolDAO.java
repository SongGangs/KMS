package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Leaveschool;

/**
 * A data access object (DAO) providing persistence and search support for
 * Leaveschool entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Leaveschool
 * @author MyEclipse Persistence Tools
 */
@Repository
public class LeaveschoolDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(LeaveschoolDAO.class);
	// property constants
	public static final String LEAVE_CONTENT = "leaveContent";

	public void save(Leaveschool transientInstance) {
		log.debug("saving Leaveschool instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Leaveschool persistentInstance) {
		log.debug("deleting Leaveschool instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Leaveschool findById(Long id) {
		log.debug("getting Leaveschool instance with id: " + id);
		try {
			Leaveschool instance = (Leaveschool) getSession().get("pers.sg.kms.model.Leaveschool", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Leaveschool instance) {
		log.debug("finding Leaveschool instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Leaveschool").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Leaveschool instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Leaveschool as model where model." + propertyName + "= ?";
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

	public List findByLeaveContent(Object leaveContent) {
		return findByProperty(LEAVE_CONTENT, leaveContent);
	}

	public List findAll() {
		log.debug("finding all Leaveschool instances");
		try {
			String queryString = "from Leaveschool";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Leaveschool merge(Leaveschool detachedInstance) {
		log.debug("merging Leaveschool instance");
		try {
			Leaveschool result = (Leaveschool) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Leaveschool instance) {
		log.debug("attaching dirty Leaveschool instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Leaveschool instance) {
		log.debug("attaching clean Leaveschool instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}