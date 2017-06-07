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
 * @date : 2017��6��7������2:10:25
 */
@Controller
@RequestMapping("/File")
public class FileUploadAjaxController {

	// @ResponseBody �����ݻ������Ϊ HTTP
	// ��Ӧ���ķ��أ��������ʺ�HttpMessageConverter��Adapterת������д���������
	// �첽��ȡjson���ݣ�����@responsebody�󣬻�ֱ�ӷ���json���ݡ�
	// produces=MediaType.APPLICATION_JSON_VALUE
	// ��ʾ�����󷵻���json�ĸ�ʽ
	@ResponseBody
	@RequestMapping(value = "/Upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String Upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		if (!file.isEmpty()) {
			try {
				if (request.getCharacterEncoding() == null) {
					request.setCharacterEncoding("UTF-8");
				}
				// �ļ���ŷ���˵�λ��
				long startTime = System.currentTimeMillis();
				String rootPath = request.getServletContext().getRealPath("") + File.separator + "Upload";
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();
				// д�ļ���������
				// �����ַ���ת��
				String temp[] = file.getOriginalFilename().replaceAll("\\\\", "/").split("/");
				File serverFile = new File(dir.getAbsolutePath() + File.separator + temp[temp.length - 1]);
				file.transferTo(serverFile);
				// ��¼ʱ��
				long endTime = System.currentTimeMillis();
				System.out.println("�ļ��Ĵ�С��" + file.getSize() / 1024 + "KB");
				System.out.println("������������ʱ�䣺" + String.valueOf(endTime - startTime) + "ms");
				return "You successfully uploaded file=" + file.getOriginalFilename();
			} catch (Exception e) {
				return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
		}
	}
}
