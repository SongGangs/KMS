/**
 * 
 */
package pers.sg.kms.component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @Title:SaveFileImpl
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017年5月23日
 */
@Component
public class Base64ImageImpl implements IBase64Image {

	@Override
	// base64字符串转化成图片
	// 对字节数组字符串进行Base64解码并生成图片
	public boolean GenerateImage(String filePath, String content, String imgType) {
		if (content == null) // 图像数据为空
			return false;
		if (imgType.contentEquals("jpg"))
			imgType = "jpeg";
		String oldStr = "data:image/" + imgType + ";base64,";
		content = content.replace(oldStr, "");
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(content);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(filePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	@Override
	public String GetImageStr(String imgFilePath) {
		byte[] data = null;

		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

}
