package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Classroom;

/**
 * A data access object (DAO) providing persistence and search support for
 * Classroom entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Classroom
 * @author MyEclipse Persistence Tools
 */
@Repository
public class ClassroomDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ClassroomDAO.class);
	// property constants
	public static final String CLASS_NAME = "className";
	public static final String CLASS_QRCODE = "classQrcode";

	public void save(Classroom transientInstance) {
		log.debug("saving Classroom instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Classroom persistentInstance) {
		log.debug("deleting Classroom instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Classroom findById(Long id) {
		log.debug("getting Classroom instance with id: " + id);
		try {
			Classroom instance = (Classroom) getSession().get("pers.sg.kms.model.Classroom", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Classroom instance) {
		log.debug("finding Classroom instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Classroom").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Classroom instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Classroom as model where model." + propertyName + "= ?";
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

	public List findByClassName(Object className) {
		return findByProperty(CLASS_NAME, className);
	}

	public List findByClassQrcode(Object classQrcode) {
		return findByProperty(CLASS_QRCODE, classQrcode);
	}

	public List findAll() {
		log.debug("finding all Classroom instances");
		try {
			String queryString = "from Classroom";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Classroom merge(Classroom detachedInstance) {
		log.debug("merging Classroom instance");
		try {
			Classroom result = (Classroom) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Classroom instance) {
		log.debug("attaching dirty Classroom instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Classroom instance) {
		log.debug("attaching clean Classroom instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}