/**
 * 
 */
package pers.sg.kms.ajaxcontrollers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.sg.kms.model.Addressinfo;
import pers.sg.kms.services.IAddressInfoService;
import pers.sg.kms.services.IUserInfoService;

/**
 * @Title:AddressAjaxController
 * @Description: ����������AJAX�������Spring MVC��ܵ��첽����
 * @Personal
 * @author : SGang
 * @date : 2017��3��21��
 */
@Controller
@RequestMapping("/Account")
public class AddressAjaxController {
	@Autowired
	private IAddressInfoService addressInfoService = null;// �Զ�װ��һ���յ��û�
	@Autowired
	private IUserInfoService userInfoService = null;// �Զ�װ��һ���յ��û�

	@ResponseBody
	@RequestMapping(value = "/RemoveAddress", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> RemoveAddress(long id) {
		Addressinfo addressinfo = addressInfoService.delectAdressByAddressID(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if (addressinfo.getAddressRecId() > 0) {
			map.put("msg", "success");
		} else {
			map.put("msg", "error");
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/AddAddress", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> AddAddress(String addressTxt, long userid) {
		Map<String, Object> map = new HashMap<String, Object>();
		Addressinfo addressinfo = new Addressinfo();
		addressinfo.setUserinfo(userInfoService.getUserinfoByUserRecID(userid));
		addressinfo.setAddressName(addressTxt);
		Addressinfo a = addressInfoService.insertAdressByAddressinfo(addressinfo);
		if (a.getAddressRecId() > 0) {
			map.put("msg", "success");
			map.put("id", a.getAddressRecId());
			map.put("name", a.getAddressName());

		} else {
			map.put("msg", "error");
		}
		return map;
	}
}
