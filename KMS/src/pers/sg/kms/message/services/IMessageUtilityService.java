/**
 * 
 */
package pers.sg.kms.message.services;

/**
 * 
 * @Title:IMessageUtilityService
 * @Description:���Ź�����
 * @Personal
 * @author : SGang
 * @date : 2017��6��4������12:04:45
 */
public interface IMessageUtilityService {
	public boolean CheckPhoneNumberIsExist(String phoneNumber);

	public String SendSecurityCode(String phoneNumber, String SecurityType);

}
