/**
 * 
 */
package pers.sg.kms.services;

import java.util.List;

import pers.sg.kms.model.Addressinfo;

/**
 * @Title:IAddressService
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ14ÈÕ
 */
public interface IAddressInfoService {
	public List<Addressinfo> getAdressByUserRecID(long UserRecID);

	public Addressinfo getAdressByAddressID(long AddressID);

	public Addressinfo delectAdressByAddressID(long AddressID);

	public Addressinfo insertAdressByAddressinfo(Addressinfo addressinfo);

	public Addressinfo updateAdressByAddressID(long AddressID);
}
