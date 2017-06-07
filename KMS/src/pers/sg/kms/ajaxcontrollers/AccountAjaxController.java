/**
 * 
 */
package pers.sg.kms.ajaxcontrollers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.sg.kms.model.Childinfo;
import pers.sg.kms.model.Family;
import pers.sg.kms.model.Userinfo;
import pers.sg.kms.services.IChildInfoService;
import pers.sg.kms.services.IFamilyService;
import pers.sg.kms.services.IUserCatalogService;
import pers.sg.kms.services.IUserInfoService;

/**
 * @Title:AccountAjaxController
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��6��4������11:55:20
 */
@Controller
@RequestMapping("/Account")
public class AccountAjaxController {
	@Autowired
	private IUserInfoService userServiceImp = null;
	@Autowired
	private IUserCatalogService userCatalogServiceImpl = null;
	@Autowired
	private IFamilyService familyServiceImpl = null;
	@Autowired
	private IChildInfoService childInfoServiceImpl = null;

	// @ResponseBody �����ݻ������Ϊ HTTP
	// ��Ӧ���ķ��أ��������ʺ�HttpMessageConverter��Adapterת������д���������
	// �첽��ȡjson���ݣ�����@responsebody�󣬻�ֱ�ӷ���json���ݡ�
	// produces=MediaType.APPLICATION_JSON_VALUE
	// ��ʾ�����󷵻���json�ĸ�ʽ
	@ResponseBody
	@RequestMapping(value = "/Identify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> Login(String userName, String password) {
		Userinfo user = userServiceImp.identifyLoginInfo(userName, password);
		Map<String, Object> map = new HashMap<String, Object>();
		if (user == null) {
			map.put("msg", "error");
			System.out.println("error");
		} else {
			map.put("msg", "success");
			System.out.println("success");
		}
		return map;
	}

	/*
	 * ע���û�
	 */
	@ResponseBody
	@RequestMapping(value = "/AddUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> Register(String userName, String password, String phoneNumber, short usercatalogID,
			long familyID) {
		Userinfo user = new Userinfo();
		user.setPhoneNumber(phoneNumber);
		user.setUserName(userName);
		user.setPassword(password);
		user.setRegisterTime(new Date());
		user.setUsercatalog(userCatalogServiceImpl.findbyid(usercatalogID));
		user.setFamily(familyServiceImpl.getFamilyByFamilyID(familyID));
		Userinfo users = userServiceImp.addUser(user);
		Map<String, Object> map = new HashMap<String, Object>();
		if (users == null) {
			map.put("msg", "error");
		} else {
			map.put("msg", "success");
		}
		return map;
	}

	// ����û����ĺϷ���,����û��Ѿ����ڣ�����false�����򷵻�true
	@ResponseBody
	@RequestMapping(value = "/CheckuNickNameIsExist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Boolean> CheckuNickNameIsExist(String uNickName) {
		boolean flag = userServiceImp.checkuNickNameIsExist(uNickName);
		Map<String, Boolean> map = new HashMap<>();
		if (flag)
			map.put("valid", false);
		else
			map.put("valid", true);
		return map;
	}

	// �����û�
	@ResponseBody
	@RequestMapping(value = "/UpdateUserInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> UpdateUserInfo(String userName, String phoneNumber, short gender, String familyName,
			Long childinfoID) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (userName == "" || childinfoID == null || familyName == null) {
			map.put("msg", "error");
			return map;
		}

		Userinfo userinfo = userServiceImp.getUserinfoByUserName(userName);
		if (!userinfo.getPhoneNumber().contains(phoneNumber)) {
			userinfo.setPhoneNumber(phoneNumber);
		}
		userinfo.setGender(gender);
		Family family = familyServiceImpl.getFamilyByFamilyName(familyName);
		if (family == null) {
			family = new Family();
			family.setFamilyName(familyName);
			family = familyServiceImpl.save(family);
			Childinfo childinfo = childInfoServiceImpl.getChildinfoByChildInfoID(childinfoID);
			childinfo.setFamily(family);
			childInfoServiceImpl.update(childinfo);
		}
		userinfo.setFamily(family);
		userServiceImp.update(userinfo);
		map.put("msg", "success");
		return map;
	}
}
