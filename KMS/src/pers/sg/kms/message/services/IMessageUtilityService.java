/**
 * 
 */
package pers.sg.kms.message.services;

/**
 * 
 * @Title:IMessageUtilityService
 * @Description:短信公共类
 * @Personal
 * @author : SGang
 * @date : 2017年6月4日下午12:04:45
 */
public interface IMessageUtilityService {
	public boolean CheckPhoneNumberIsExist(String phoneNumber);

	public String SendSecurityCode(String phoneNumber, String SecurityType);

}
