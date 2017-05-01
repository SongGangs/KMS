/**
 * 
 */
package pers.sg.kms.services;

import java.util.List;

import pers.sg.kms.model.Childinfo;

/**
 * @Title:IChildInfoService
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ14ÈÕ
 */
public interface IChildInfoService {
	public List<Childinfo> getChildinfoByFamilyID(int FamilyID);

	public Childinfo getChildinfoByChildInfoID(int ChildInfoID);

	public Childinfo delectChildinfoByChildInfoID(int ChildInfoID);

	public Childinfo insertChildinfoByFamilyID(int FamilyID);

	public Childinfo updateChildinfoByChildInfoID(int ChildInfoID);
}
