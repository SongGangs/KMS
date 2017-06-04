/**
 * 
 */
package pers.sg.kms.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sg.kms.daos.UsercatalogDAO;
import pers.sg.kms.model.Usercatalog;
import pers.sg.kms.services.IUserCatalogService;

/**
 * @Title:UserCatalogServiceImpl
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017年6月4日下午12:22:17
 */
@Service
public class UserCatalogServiceImpl implements IUserCatalogService {
	@Autowired
	private UsercatalogDAO usercatalogDAO = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pers.sg.kms.services.IUserCatalogService#findUserCatalogByUserID(int)
	 */
	@Override
	public String findUserCatalogByUserID(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pers.sg.kms.services.IUserCatalogService#findAllUsercatalog()
	 */
	@Override
	public List<Usercatalog> findAllUsercatalog() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pers.sg.kms.services.IUserCatalogService#findbyuserCatalogName(java.lang.
	 * String)
	 */
	@Override
	public Usercatalog findbyid(Short id) {
		return usercatalogDAO.findById(id);
	}

}
