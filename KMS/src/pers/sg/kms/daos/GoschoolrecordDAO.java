package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Goschoolrecord;

/**
 * A data access object (DAO) providing persistence and search support for
 * Goschoolrecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Goschoolrecord
 * @author MyEclipse Persistence Tools
 */
@Repository
public class GoschoolrecordDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(GoschoolrecordDAO.class);
	// property constants

	public void save(Goschoolrecord transientInstance) {
		log.debug("saving Goschoolrecord instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Goschoolrecord persistentInstance) {
		log.debug("deleting Goschoolrecord instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Goschoolrecord findById(Long id) {
		log.debug("getting Goschoolrecord instance with id: " + id);
		try {
			Goschoolrecord instance = (Goschoolrecord) getSession().get("pers.sg.kms.model.Goschoolrecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Goschoolrecord instance) {
		log.debug("finding Goschoolrecord instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Goschoolrecord").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Goschoolrecord instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Goschoolrecord as model where model." + propertyName + "= ?";
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
		log.debug("finding all Goschoolrecord instances");
		try {
			String queryString = "from Goschoolrecord";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Goschoolrecord merge(Goschoolrecord detachedInstance) {
		log.debug("merging Goschoolrecord instance");
		try {
			Goschoolrecord result = (Goschoolrecord) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Goschoolrecord instance) {
		log.debug("attaching dirty Goschoolrecord instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Goschoolrecord instance) {
		log.debug("attaching clean Goschoolrecord instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}