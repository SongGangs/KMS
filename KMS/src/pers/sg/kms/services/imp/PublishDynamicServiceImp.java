/**
 * 
 */
package pers.sg.kms.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sg.kms.daos.PublishdynamicDAO;
import pers.sg.kms.model.Publishdynamic;
import pers.sg.kms.model.Userinfo;
import pers.sg.kms.services.IPublishDynamicServices;

/**
 * @Title:PublishDynamicServiceImp
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ29ÈÕ
 */
@Service
public class PublishDynamicServiceImp implements IPublishDynamicServices {

	@Autowired
	private PublishdynamicDAO PublishdynamicDAO;

	@SuppressWarnings("unchecked")
	@Override
	public Userinfo getUserinfoByDynamicId(long id) {
		List<Publishdynamic> list = PublishdynamicDAO.findByProperty("dynamicinfo.dynamicId", id);
		if (list.size() > 0) {
			return list.get(0).getUserinfo();
		} else {
			return new Publishdynamic().getUserinfo();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publishdynamic> getAllPublishdynamics() {

		return PublishdynamicDAO.findAll();
	}

	@Override
	public Publishdynamic add(Publishdynamic p) {
		try {
			return PublishdynamicDAO.save(p);
		} catch (Exception e) {
			return new Publishdynamic();
		}
	}

}
