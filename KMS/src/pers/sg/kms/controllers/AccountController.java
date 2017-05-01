/**
 * 
 */
package pers.sg.kms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pers.sg.kms.model.Addressinfo;
import pers.sg.kms.model.Userinfo;
import pers.sg.kms.services.IAddressInfoService;
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

	@RequestMapping("/Login")
	public String login() {
		return "account/login";
	}

	@RequestMapping("/Register")
	public String register() {
		return "account/register";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String log0n(@RequestParam("username") String userName, @RequestParam("password") String pwd) {
		if (userInfoService.loginInfoCheck(userName, pwd)) {
			System.out.println("��½�ɹ�");
			return "account/login";
		} else {
			System.out.println("��½ʧ��");
			return "redirect:Login";// �ض���ֻ�ı�����ҳ��ֵ
		}

	}

	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public ModelAndView registers() {

		return new ModelAndView("redirect:account/login");
	}

	@RequestMapping(value = "/UserInfoCenter")
	public ModelAndView UserInfoCenter(long UserRecID) {
		UserInfoCenterViewModel ucvm = new UserInfoCenterViewModel();
		Userinfo userinfo = userInfoService.getUserinfoByUserRecID(UserRecID);
		List<Addressinfo> addressinfos = addressInfoService.getAdressByUserRecID(UserRecID);
		ucvm.setUserinfo(userinfo);
		ucvm.setAddressinfos(addressinfos);
		// userinfo.getUsercatalog().getUserCatalogName()
		List<Userinfo> userinfolist = userInfoService.getUserinfoByFamilyID(userinfo.getFamily().getFamilyId());
		ucvm.setUserinfolist(userinfolist);
		return new ModelAndView("account/userinfocenter", "viewmodel", ucvm);
	}

	@RequestMapping(value = "/RemoveAddress", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String RemoveAddress(long id) {
		Addressinfo addressinfo = addressInfoService.delectAdressByAddressID(id);
		if (addressinfo.getAddressRecId() > 0) {
			return "success";
		} else {
			return "failed";
		}
	}

	@RequestMapping(value = "/AddAddress", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String AddAddress(String addressTxt, long userid) {
		Addressinfo addressinfo = new Addressinfo();
		addressinfo.setUserinfo(userInfoService.getUserinfoByUserRecID(userid));
		addressinfo.setAddressName(addressTxt);
		Addressinfo a = addressInfoService.insertAdressByAddressinfo(addressinfo);
		if (a.getAddressRecId() > 0) {
			return a.getAddressRecId() + "^" + a.getAddressName();
		} else {
			return "";
		}
	}
}
