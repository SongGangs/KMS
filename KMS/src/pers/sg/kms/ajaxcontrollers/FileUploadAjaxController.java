/**
 * 
 */
package pers.sg.kms.ajaxcontrollers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.sg.kms.component.IBase64Image;

/**
 * @Title:FileUploadAjaxController
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017年6月7日下午2:10:25
 */
@Controller
@RequestMapping("/File")
public class FileUploadAjaxController {

	@Autowired
	private IBase64Image SaveFileImpl;

	// @ResponseBody 将内容或对象作为 HTTP
	// 响应正文返回，并调用适合HttpMessageConverter的Adapter转换对象，写入输出流。
	// 异步获取json数据，加上@responsebody后，会直接返回json数据。
	// produces=MediaType.APPLICATION_JSON_VALUE
	// 表示将请求返回以json的格式
	@ResponseBody
	@RequestMapping(value = "/Upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> Upload(String message, String filename, String imgType, HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		String filePath = request.getServletContext().getRealPath("") + "Upload" + File.separator + filename + "."
				+ imgType;
		if (!SaveFileImpl.GenerateImage(filePath, message, imgType)) {
			map.put("msg", "error");
		} else {
			map.put("msg", "success");
		}
		return map;
	}
}
