/**
 * 
 */
package pers.sg.kms.services;

import java.util.List;

import pers.sg.kms.model.Zambia;

/**
 * @Title:IZambiaServices
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��3��29��
 */
public interface IZambiaServices {
	List<Zambia> getZambiasByDynamicId(long id);
}
