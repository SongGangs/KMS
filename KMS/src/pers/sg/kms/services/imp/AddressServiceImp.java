/**
 * 
 */
package pers.sg.kms.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sg.kms.daos.AddressinfoDAO;
import pers.sg.kms.model.Addressinfo;
import pers.sg.kms.services.IAddressInfoService;

/**
 * @Title:AddressServiceImp
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ19ÈÕ
 */
@Service
public class AddressServiceImp implements IAddressInfoService {
	@Autowired
	private AddressinfoDAO addressDAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<Addressinfo> getAdressByUserRecID(long UserRecID) {

		return addressDAO.findByProperty("userinfo.userRecId", UserRecID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pers.sg.kms.services.IAddressService#getAdressByAddressID(int)
	 */
	@Override
	public Addressinfo getAdressByAddressID(long AddressID) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pers.sg.kms.services.IAddressService#delectAdressByAddressID(int)
	 */
	@Override
	public Addressinfo delectAdressByAddressID(long AddressID) {
		Addressinfo a = addressDAO.findById(AddressID);
		return addressDAO.delete(a);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pers.sg.kms.services.IAddressService#insertAdressByUserRecID(int)
	 */
	@Override
	public Addressinfo insertAdressByAddressinfo(Addressinfo addressinfo) {
		return addressDAO.save(addressinfo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pers.sg.kms.services.IAddressService#updateAdressByAddressID(long)
	 */
	@Override
	public Addressinfo updateAdressByAddressID(long AddressID) {
		// TODO Auto-generated method stub
		return null;
	}

}
