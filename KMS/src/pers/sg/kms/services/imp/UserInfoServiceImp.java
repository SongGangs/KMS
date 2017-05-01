/**
 * 
 */
package pers.sg.kms.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sg.kms.daos.UserinfoDAO;
import pers.sg.kms.model.Userinfo;
import pers.sg.kms.services.IUserInfoService;

/**
 * @Title:UserInfoServiceImp
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017年3月16日
 */
@Service
public class UserInfoServiceImp implements IUserInfoService {

	@Autowired
	private UserinfoDAO userinfoDAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<Userinfo> getUserinfoByFamilyID(long FamilyID) {
		// 通过属性查找时 根据属性值（一个表 ）.属性值(即你需要查找的值)
		return userinfoDAO.findByProperty("family.familyId", FamilyID);
	}

	@Override
	public Userinfo getUserinfoByUserRecID(long UserRecID) {
		Userinfo userinfo = new Userinfo();
		userinfo = userinfoDAO.findById(UserRecID);
		return userinfo;
	}

	@Override
	public boolean delectUserinfoByUserRecID(long UserRecID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertUserinfoByUserRecID(long UserRecID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserinfoByUserRecID(long UserRecID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loginInfoCheck(String userName, String pwd) {
		// return userinfoDAO.findByUserNameAndPassword(userName, pwd);
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pers.sg.kms.services.IUserInfoService#getUserIdByDynamicId(long)
	 */
	@Override
	public long getUserIdByDynamicId(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Userinfo getUserinfoByUserName(String username) {
		List<Userinfo> list = userinfoDAO.findByUserName(username);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new Userinfo();
		}
	}

}
