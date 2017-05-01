/**
 * 
 */
package pers.sg.kms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pers.sg.kms.model.Userinfo;

/**
 * @Title:UserInfoMapper
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ17ÈÕ
 */
public class UserInfoMapper implements RowMapper<Userinfo> {

	@Override
	public Userinfo mapRow(ResultSet rs, int arg1) throws SQLException {
		if (rs.wasNull()) {
			return null;
		} else {
			Userinfo userInfo = new Userinfo();
			userInfo.setUserRecId(rs.getInt("UserID"));
			userInfo.setUserName(rs.getString("UserName"));
			userInfo.setRegisterTime(rs.getDate("RegisterTime"));
			userInfo.setImage(rs.getString("Image"));
			userInfo.setGender(rs.getShort("Gender"));
			userInfo.setActiveValue(rs.getInt("ActiveValue"));
			userInfo.setIdentity(rs.getString("Identity"));
			userInfo.setPhoneNumber(rs.getString("PhoneNumber"));
			// userInfo.setFamily("");
			// userInfo.setUsercatalog(usercatalog);
			return userInfo;
		}
	}

}
