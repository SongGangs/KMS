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
 * @date : 2017��5��23��
 */
@Component
public class Base64ImageImpl implements IBase64Image {

	@Override
	// base64�ַ���ת����ͼƬ
	// ���ֽ������ַ�������Base64���벢����ͼƬ
	public boolean GenerateImage(String filePath, String content, String imgType) {
		if (content == null) // ͼ������Ϊ��
			return false;
		if (imgType.contentEquals("jpg"))
			imgType = "jpeg";
		String oldStr = "data:image/" + imgType + ";base64,";
		content = content.replace(oldStr, "");
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64����
			byte[] bytes = decoder.decodeBuffer(content);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// �����쳣����
					bytes[i] += 256;
				}
			}
			// ����jpegͼƬ
			OutputStream out = new FileOutputStream(filePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
	@Override
	public String GetImageStr(String imgFilePath) {
		byte[] data = null;

		// ��ȡͼƬ�ֽ�����
		try {
			InputStream in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ���ֽ�����Base64����
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// ����Base64��������ֽ������ַ���
	}

}
