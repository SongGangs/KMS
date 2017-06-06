/**
 * 
 */
package pers.sg.kms.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sg.kms.daos.FamilyDAO;
import pers.sg.kms.model.Family;
import pers.sg.kms.services.IFamilyService;

/**
 * @Title:FamilyServiceImp
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ19ÈÕ
 */
@Service
public class FamilyServiceImp implements IFamilyService {
	@Autowired
	private FamilyDAO FamilyDAO;

	@Override
	public Family getFamilyByFamilyID(long familyId) {
		return FamilyDAO.findById(familyId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pers.sg.kms.services.IFamilyServices#getFamilyByFamilyName(long)
	 */
	@Override
	public Family getFamilyByFamilyName(String familyName) {
		@SuppressWarnings("unchecked")
		List<Family> list = FamilyDAO.findByFamilyName(familyName);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pers.sg.kms.services.IFamilyService#save(pers.sg.kms.model.Family)
	 */
	@Override
	public Family save(Family family) {
		return FamilyDAO.save(family);
	}

}
