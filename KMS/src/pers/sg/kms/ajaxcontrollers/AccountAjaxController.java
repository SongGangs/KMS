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

import pers.sg.kms.model.Userinfo;
import pers.sg.kms.services.IFamilyServices;
import pers.sg.kms.services.IUserCatalogService;
import pers.sg.kms.services.IUserInfoService;

/**
 * @Title:AccountAjaxController
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017年6月4日上午11:55:20
 */
@Controller
@RequestMapping("/Account")
public class AccountAjaxController {
	@Autowired
	private IUserInfoService userServiceImp = null;
	@Autowired
	private IUserCatalogService userCatalogServiceImpl = null;
	@Autowired
	private IFamilyServices familyServiceImpl = null;

	// @ResponseBody 将内容或对象作为 HTTP
	// 响应正文返回，并调用适合HttpMessageConverter的Adapter转换对象，写入输出流。
	// 异步获取json数据，加上@responsebody后，会直接返回json数据。
	// produces=MediaType.APPLICATION_JSON_VALUE
	// 表示将请求返回以json的格式
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
	 * 注册用户
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

	// 检查用户名的合法性,如果用户已经存在，返回false，否则返回true
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

	// 更新用户
	@ResponseBody
	@RequestMapping(value = "/UpdateUserInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Boolean> UpdateUserInfo(String phoneNumber, short gender, String family) {

		Map<String, Boolean> map = new HashMap<>();

		return map;
	}
}
