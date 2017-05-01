/**
 * 
 */
package pers.sg.kms.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sg.kms.daos.FamilyDAO;
import pers.sg.kms.model.Family;
import pers.sg.kms.services.IFamilyServices;

/**
 * @Title:FamilyServiceImp
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ19ÈÕ
 */
@Service
public class FamilyServiceImp implements IFamilyServices {
	@Autowired
	private FamilyDAO FamilyDAO;

	@Override
	public Family getFamilyByFamilyID(long familyId) {
		return FamilyDAO.findById(familyId);
	}

}
