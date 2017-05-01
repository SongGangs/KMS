/**
 * 
 */
package pers.sg.kms.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sg.kms.daos.ZambiaDAO;
import pers.sg.kms.model.Zambia;
import pers.sg.kms.services.IZambiaServices;

/**
 * @Title:ZambiaServiceImp
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ29ÈÕ
 */
@Service
public class ZambiaServiceImp implements IZambiaServices {

	@Autowired
	private ZambiaDAO ZambiaDAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<Zambia> getZambiasByDynamicId(long id) {
		return ZambiaDAO.findByProperty("dynamicinfo.dynamicId", id);
	}

}
