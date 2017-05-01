package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Images;

/**
 * A data access object (DAO) providing persistence and search support for
 * Images entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Images
 * @author MyEclipse Persistence Tools
 */
@Repository
public class ImagesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ImagesDAO.class);
	// property constants
	public static final String IMAGES_ADDRESS = "imagesAddress";

	public void save(Images transientInstance) {
		log.debug("saving Images instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Images persistentInstance) {
		log.debug("deleting Images instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Images findById(Long id) {
		log.debug("getting Images instance with id: " + id);
		try {
			Images instance = (Images) getSession().get("pers.sg.kms.model.Images", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Images instance) {
		log.debug("finding Images instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Images").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Images instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Images as model where model." + propertyName + "= ?";
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

	public List findByImagesAddress(Object imagesAddress) {
		return findByProperty(IMAGES_ADDRESS, imagesAddress);
	}

	public List findAll() {
		log.debug("finding all Images instances");
		try {
			String queryString = "from Images";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Images merge(Images detachedInstance) {
		log.debug("merging Images instance");
		try {
			Images result = (Images) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Images instance) {
		log.debug("attaching dirty Images instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Images instance) {
		log.debug("attaching clean Images instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}