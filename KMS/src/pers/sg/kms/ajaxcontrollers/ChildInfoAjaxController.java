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
 * @date : 2017年6月6日下午7:03:49
 */

@Controller
@RequestMapping("/ChildInfo")
public class ChildInfoAjaxController {
	@Autowired
	private IChildInfoService childInfoServiceImpl;

	// @ResponseBody 将内容或对象作为 HTTP
	// 响应正文返回，并调用适合HttpMessageConverter的Adapter转换对象，写入输出流。
	// 异步获取json数据，加上@responsebody后，会直接返回json数据。
	// produces=MediaType.APPLICATION_JSON_VALUE
	// 表示将请求返回以json的格式
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
