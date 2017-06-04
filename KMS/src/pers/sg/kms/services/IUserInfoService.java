/**
 * 
 */
package pers.sg.kms.services;

import java.util.List;

import pers.sg.kms.model.Userinfo;

/**
 * @Title:IUserInfo
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ14ÈÕ
 */

public interface IUserInfoService {
	public List<Userinfo> getUserinfoByFamilyID(long FamilyID);

	public Userinfo getUserinfoByUserRecID(long UserRecID);

	public Userinfo getUserinfoByUserName(String username);

	public boolean updateUserinfoByUserRecID(long UserRecID);

	public long getUserIdByDynamicId(long id);

	public boolean checkuNickNameIsExist(String userName);

	public Userinfo addUser(Userinfo userinfo);

	public Userinfo identifyLoginInfo(String userName, String password);
}
