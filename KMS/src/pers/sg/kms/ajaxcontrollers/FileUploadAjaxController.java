/**
 * 
 */
package pers.sg.kms.ajaxcontrollers;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

	// @ResponseBody 将内容或对象作为 HTTP
	// 响应正文返回，并调用适合HttpMessageConverter的Adapter转换对象，写入输出流。
	// 异步获取json数据，加上@responsebody后，会直接返回json数据。
	// produces=MediaType.APPLICATION_JSON_VALUE
	// 表示将请求返回以json的格式
	@ResponseBody
	@RequestMapping(value = "/Upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String Upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		if (!file.isEmpty()) {
			try {
				if (request.getCharacterEncoding() == null) {
					request.setCharacterEncoding("UTF-8");
				}
				// 文件存放服务端的位置
				long startTime = System.currentTimeMillis();
				String rootPath = request.getServletContext().getRealPath("") + File.separator + "Upload";
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();
				// 写文件到服务器
				// 特殊字符的转换
				String temp[] = file.getOriginalFilename().replaceAll("\\\\", "/").split("/");
				File serverFile = new File(dir.getAbsolutePath() + File.separator + temp[temp.length - 1]);
				file.transferTo(serverFile);
				// 记录时间
				long endTime = System.currentTimeMillis();
				System.out.println("文件的大小：" + file.getSize() / 1024 + "KB");
				System.out.println("方法二的运行时间：" + String.valueOf(endTime - startTime) + "ms");
				return "You successfully uploaded file=" + file.getOriginalFilename();
			} catch (Exception e) {
				return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
		}
	}
}
