/**
 * 
 */
package pers.sg.kms.services;

import java.util.List;

import pers.sg.kms.model.Usercatalog;

/**
 * @Title:IUserCatalog
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��3��16��
 */
public interface IUserCatalogService {
	public String findUserCatalogByUserID(int userID);

	public List<Usercatalog> findAllUsercatalog();
}
