/**
 * 
 */
package pers.sg.kms.services;

import java.util.List;

import pers.sg.kms.model.Dynamicinfo;

/**
 * @Title:IDynamicServices
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��3��29��
 */

public interface IDynamicInfoServices {
	public Dynamicinfo getDynamicByDynamicId(long id);

	public List<Dynamicinfo> getAllDynamic();

	public Dynamicinfo add(Dynamicinfo d);
}
