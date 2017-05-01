/**
 * 
 */
package pers.sg.kms.controllers.ajax;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pers.sg.kms.viewmodel.UserInfoCenterViewModel;

/**
 * @Title:AddressAjaxController
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017年3月21日
 */
@Controller
@RequestMapping("/Account")
public class AddressAjaxController {
	// produces=MediaType.APPLICATION_JSON_VALUE
	// 表示将请求返回以json的格式
	@RequestMapping(value = "UserInfoCenter", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserInfoCenterViewModel removeAddress() {

		return null;
	}
}
