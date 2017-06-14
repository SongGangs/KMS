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
 * @date : 2017��3��16��
 */
@Service
public class UserInfoServiceImp implements IUserInfoService {

	@Autowired
	private UserinfoDAO userinfoDAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<Userinfo> getUserinfoByFamilyID(long FamilyID) {
		// ͨ�����Բ���ʱ ��������ֵ��һ���� ��.����ֵ(������Ҫ���ҵ�ֵ)
		return userinfoDAO.findByProperty("family.familyId", FamilyID);
	}

	@Override
	public Userinfo getUserinfoByUserRecID(long UserRecID) {
		Userinfo userinfo = new Userinfo();
		userinfo = userinfoDAO.findById(UserRecID);
		return userinfo;
	}

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
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pers.sg.kms.services.IUserInfoService#checkuNickNameIsExist(java.lang.
	 * String) ����û����Ƿ����
	 */
	@Override
	public boolean checkuNickNameIsExist(String userName) {
		int result = userinfoDAO.findByUserName(userName).size();
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pers.sg.kms.services.IUserInfoService#addUser(pers.sg.kms.model.Userinfo)
	 * ����û�
	 */
	@Override
	public Userinfo addUser(Userinfo userinfo) {
		if (!checkuNickNameIsExist(userinfo.getUserName())) {
			return userinfoDAO.save(userinfo);
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pers.sg.kms.services.IUserInfoService#identifyLoginInfo(java.lang.String,
	 * java.lang.String) ����˺���Ϣ�Ǹ���ȷ
	 */
	@Override
	public Userinfo identifyLoginInfo(String userName, String password) {
		if (checkuNickNameIsExist(userName)) {
			Userinfo user = (Userinfo) userinfoDAO.findByUserName(userName).get(0);
			if (user.getPassword().equals(password)) {
				return user;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pers.sg.kms.services.IUserInfoService#updateUserinfoByUserRecID(long)
	 */
	@Override
	public void update(Userinfo userinfo) {
		userinfoDAO.attachDirty(userinfo);
	}

}
