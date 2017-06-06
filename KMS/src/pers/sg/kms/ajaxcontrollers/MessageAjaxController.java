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

import pers.sg.kms.message.services.IMessageUtilityService;

/**
 * @Title:MessageAjaxController
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017年6月4日下午12:31:47
 */
@Controller
@RequestMapping("/Message")
public class MessageAjaxController {

	@Autowired
	private IMessageUtilityService messageUtilityImpl = null;
	private String m_securityCode = "";

	/*
	 * 发送短信验证码
	 */
	@ResponseBody
	@RequestMapping(value = "/SendSecurityCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> SendSecurityCode(String phoneNumber) {
		Map<String, Object> map = new HashMap<String, Object>();
		String code = messageUtilityImpl.SendSecurityCode(phoneNumber, "注册验证");
		m_securityCode = code;
		if (code == null) {
			map.put("msg", "error");
		} else {
			map.put("msg", "success");
			map.put("code", code);
		}
		return map;
	}

	/*
	 * 检查验证码是否正确
	 */
	@ResponseBody
	@RequestMapping(value = "/CheckSecurityCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Boolean> CheckSecurityCode(String securityCode) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (securityCode.equals(m_securityCode)) {
			map.put("valid", true);
		} else {
			map.put("valid", false);
		}
		return map;
	}

}
