/**
 * 
 */
package pers.sg.kms.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pers.sg.kms.model.Userinfo;
import pers.sg.kms.services.IUserInfoService;

/**
 * @Title:UserInfoSeriveImplTest
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��6��6������10:34:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserInfoSeriveImplTest {
	@Autowired
	private IUserInfoService userInfoService;

	/**
	 * Test method for
	 * {@link pers.sg.kms.services.imp.UserInfoServiceImp#getUserinfoByUserName(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetUserinfoByUserName() {
		Userinfo userinfo = userInfoService.getUserinfoByUserName("���ǲ��Ի�");
		Assert.assertNotNull(userinfo);
	}

	/**
	 * Test method for
	 * {@link pers.sg.kms.services.imp.UserInfoServiceImp#update(pers.sg.kms.model.Userinfo)}
	 * .
	 */
	@Test
	public void testUpdate() {

	}

}
