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
	public List<Childinfo> getChildinfoByFamilyID(long FamilyID);

	public Childinfo getChildinfoByChildInfoID(long ChildInfoID);

	public Childinfo updateChildinfoByChildInfoID(long ChildInfoID);
}
