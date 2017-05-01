/**
 * 
 */
package pers.sg.kms.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sg.kms.daos.DynamicinfoDAO;
import pers.sg.kms.model.Dynamicinfo;
import pers.sg.kms.services.IDynamicInfoServices;

/**
 * @Title:DynamicServiceImp
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ29ÈÕ
 */
@Service
public class DynamicInfoServiceImp implements IDynamicInfoServices {

	@Autowired
	private DynamicinfoDAO dynamicDao;

	@Override
	public Dynamicinfo getDynamicByDynamicId(long id) {
		return dynamicDao.findById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dynamicinfo> getAllDynamic() {
		return dynamicDao.findAll();
	}

	@Override
	public Dynamicinfo add(Dynamicinfo d) {
		try {
			return dynamicDao.save(d);
		} catch (Exception e) {
			return new Dynamicinfo();
		}
	}

}
