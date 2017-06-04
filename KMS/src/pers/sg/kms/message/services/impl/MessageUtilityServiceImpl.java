
package pers.sg.kms.message.services.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import pers.sg.kms.message.services.IMessageUtilityService;

/**
 * 
 * @Title:MessageUtilityServiceImpl
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��6��4������12:05:09
 */
@Service
public class MessageUtilityServiceImpl implements IMessageUtilityService {

	private String url = "http://gw.api.taobao.com/router/rest"; // ���������ַ
	private String AppKey = "23401777";
	private String Security = "413bccbc7a9964b957c2e04940cc2369";

	/**
	 * ��½�ֻ�����11λ���� ƥ���ʽ��ǰ��λ�̶���ʽ+��8λ������ �˷�����ǰ��λ��ʽ�У� 13+������ 15+��4�������� 18+��1��4��������
	 * 17+��9�������� 147
	 */
	@Override
	public boolean CheckPhoneNumberIsExist(String phoneNumber) {
		String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(phoneNumber);
		return m.matches();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * �û�ע��ʱ
	 * 
	 * ���Ͷ�����֤�� SecurityType
	 * 
	 * Ϊ�û�������� ֻ����
	 * 
	 * ע����֤
	 * 
	 * �����֤
	 * 
	 * @see
	 * ourmarket.componet.IMessageUtility#SendSecurityCode(java.lang.String)
	 */
	@Override
	public String SendSecurityCode(String phoneNumber, String SecurityType) {
		if (CheckPhoneNumberIsExist(phoneNumber)) {
			String product = "���Ի���";// ��Ʒ����
			String m_SecurityCode = generateRandomArray(6);// ��֤��
			// ����ģ�������
			String content = "{\"code\":\"" + m_SecurityCode + "\",\"product\":\"" + product + "\"}";
			TaobaoClient client = new DefaultTaobaoClient(url, AppKey, Security);
			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
			req.setExtend("123456");
			req.setSmsType("normal");
			req.setSmsFreeSignName(SecurityType);
			req.setSmsParamString(content);
			req.setRecNum(phoneNumber);
			req.setSmsTemplateCode("SMS_11350208");
			try {
				AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
				System.out.println(rsp.getBody());
				if (rsp.getBody().contains("\"success\":true"))
					return m_SecurityCode;
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}
		return null;
	}

	/**
	 * ������� numλ�����ַ�����
	 * 
	 * @param num
	 * @return
	 */
	private String generateRandomArray(int num) {
		String chars = "0123456789";
		char[] rands = new char[num];
		for (int i = 0; i < num; i++) {
			int rand = (int) (Math.random() * 10);
			rands[i] = chars.charAt(rand);
		}
		return String.valueOf(rands);
	}

}
