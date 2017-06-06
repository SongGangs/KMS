/**
 * 
 */
package pers.sg.kms.services;

import pers.sg.kms.model.Family;

/**
 * @Title:IFamilyServices
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��3��19��
 */
public interface IFamilyService {
	public Family getFamilyByFamilyID(long familyId);

	public Family getFamilyByFamilyName(String familyName);

	public Family save(Family family);
}
