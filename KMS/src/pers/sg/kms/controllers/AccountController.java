/**
 * 
 */
package pers.sg.kms.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pers.sg.kms.model.Addressinfo;
import pers.sg.kms.model.Childinfo;
import pers.sg.kms.model.Userinfo;
import pers.sg.kms.services.IAddressInfoService;
import pers.sg.kms.services.IChildInfoService;
import pers.sg.kms.services.IUserInfoService;
import pers.sg.kms.viewmodel.UserInfoCenterViewModel;

/**
 * @Title:AccountController
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��3��16��
 */

/**
 * �ͱ���@Controller ����@RequestMapping�ĵ�ַӳ��
 * 
 * @RequestMapping��valueֵ����ӳ������ĵ�ַ������ֵ����ʵ�ʵ�ַ
 */
@Controller
@RequestMapping("/Account")
public class AccountController {

	@Autowired
	private IUserInfoService userInfoService = null;// �Զ�װ��һ���յ��û�
	@Autowired
	private IAddressInfoService addressInfoService = null;// �Զ�װ��һ���յ��û�
	@Autowired
	private IChildInfoService childInfoService = null;// �Զ�װ��һ���յ��û�

	@RequestMapping("/Login")
	public String login() {
		return "account/login";
	}

	@RequestMapping("/Register")
	public String register() {
		return "account/register";
	}

	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public ModelAndView registers() {

		return new ModelAndView("redirect:account/login");
	}

	@RequestMapping(value = "/UserInfoCenter")
	public ModelAndView UserInfoCenter(long UserRecID, HttpServletRequest request) {
		String rootPath = request.getServletContext().getRealPath("") + "Upload" + File.separator;
		UserInfoCenterViewModel ucvm = new UserInfoCenterViewModel();
		Userinfo userinfo = userInfoService.getUserinfoByUserRecID(UserRecID);
		List<Addressinfo> addressinfos = addressInfoService.getAdressByUserRecID(UserRecID);
		ucvm.setUserinfo(userinfo);
		ucvm.setAddressinfos(addressinfos);
		// userinfo.getUsercatalog().getUserCatalogName()
		List<Userinfo> userinfolist = new ArrayList<Userinfo>();
		List<Childinfo> childinfolist = new ArrayList<Childinfo>();
		if (userinfo.getFamily() != null) {
			userinfolist = userInfoService.getUserinfoByFamilyID(userinfo.getFamily().getFamilyId());
			childinfolist = childInfoService.getChildinfoByFamilyID(userinfo.getFamily().getFamilyId());
		}
		ucvm.setUserinfolist(userinfolist);
		ucvm.setChildinfolist(childinfolist);
		ucvm.setRootPath(rootPath);
		return new ModelAndView("account/userinfocenter", "viewmodel", ucvm);
	}

}
