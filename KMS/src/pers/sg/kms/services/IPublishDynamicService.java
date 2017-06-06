/**
 * 
 */
package pers.sg.kms.services;

import java.util.List;

import pers.sg.kms.model.Publishdynamic;
import pers.sg.kms.model.Userinfo;

/**
 * @Title:IPublishDynamicServices
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ29ÈÕ
 */
public interface IPublishDynamicService {
	public Userinfo getUserinfoByDynamicId(long id);

	public List<Publishdynamic> getAllPublishdynamics();

	public Publishdynamic add(Publishdynamic p);
}
