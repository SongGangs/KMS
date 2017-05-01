package pers.sg.kms.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pers.sg.kms.model.Childinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Childinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pers.sg.kms.model.Childinfo
 * @author MyEclipse Persistence Tools
 */
@Repository
public class ChildinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ChildinfoDAO.class);
	// property constants
	public static final String CHILD_NAME = "childName";
	public static final String GENDER = "gender";
	public static final String HEAD_IMAGE = "headImage";

	public void save(Childinfo transientInstance) {
		log.debug("saving Childinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Childinfo persistentInstance) {
		log.debug("deleting Childinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Childinfo findById(Long id) {
		log.debug("getting Childinfo instance with id: " + id);
		try {
			Childinfo instance = (Childinfo) getSession().get("pers.sg.kms.model.Childinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Childinfo instance) {
		log.debug("finding Childinfo instance by example");
		try {
			List results = getSession().createCriteria("pers.sg.kms.model.Childinfo").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Childinfo instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Childinfo as model where model." + propertyName + "= ?";
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

	public List findByChildName(Object childName) {
		return findByProperty(CHILD_NAME, childName);
	}

	public List findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List findByHeadImage(Object headImage) {
		return findByProperty(HEAD_IMAGE, headImage);
	}

	public List findAll() {
		log.debug("finding all Childinfo instances");
		try {
			String queryString = "from Childinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Childinfo merge(Childinfo detachedInstance) {
		log.debug("merging Childinfo instance");
		try {
			Childinfo result = (Childinfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Childinfo instance) {
		log.debug("attaching dirty Childinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Childinfo instance) {
		log.debug("attaching clean Childinfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}