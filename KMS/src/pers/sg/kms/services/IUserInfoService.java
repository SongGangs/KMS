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

	public boolean delectUserinfoByUserRecID(long UserRecID);

	public boolean insertUserinfoByUserRecID(long UserRecID);

	public boolean updateUserinfoByUserRecID(long UserRecID);

	public boolean loginInfoCheck(String userName, String pwd);

	public long getUserIdByDynamicId(long id);
}
