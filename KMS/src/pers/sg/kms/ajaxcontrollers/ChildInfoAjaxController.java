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

import pers.sg.kms.model.Childinfo;
import pers.sg.kms.services.IChildInfoService;

/**
 * @Title:ChildInfoAjaxController
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��6��6������7:03:49
 */

@Controller
@RequestMapping("/ChildInfo")
public class ChildInfoAjaxController {
	@Autowired
	private IChildInfoService childInfoServiceImpl;

	// @ResponseBody �����ݻ������Ϊ HTTP
	// ��Ӧ���ķ��أ��������ʺ�HttpMessageConverter��Adapterת������д���������
	// �첽��ȡjson���ݣ�����@responsebody�󣬻�ֱ�ӷ���json���ݡ�
	// produces=MediaType.APPLICATION_JSON_VALUE
	// ��ʾ�����󷵻���json�ĸ�ʽ
	@ResponseBody
	@RequestMapping(value = "/HasFamily", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> HasFamily(long childinfoID) {
		Childinfo childinfo = childInfoServiceImpl.getChildinfoByChildInfoID(childinfoID);
		Map<String, Object> map = new HashMap<String, Object>();
		if (childinfo.getFamily() == null) {
			map.put("msg", "error");
			System.out.println("error");
		} else {
			map.put("msg", "success");
			System.out.println("success");
		}
		return map;
	}
}
