/**
 * 
 */
package pers.sg.kms.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sg.kms.daos.ChildinfoDAO;
import pers.sg.kms.model.Childinfo;
import pers.sg.kms.services.IChildInfoService;

/**
 * @Title:ChildInfoServiceImpl
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��6��6������8:54:37
 */
@Service
public class ChildInfoServiceImpl implements IChildInfoService {

	@Autowired
	private ChildinfoDAO childinfoDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see pers.sg.kms.services.IChildInfoService#getChildinfoByFamilyID(long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Childinfo> getChildinfoByFamilyID(long FamilyID) {
		// ͨ�����Բ���ʱ ��������ֵ��һ���� ��.����ֵ(������Ҫ���ҵ�ֵ)
		return childinfoDao.findByProperty("family.familyId", FamilyID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pers.sg.kms.services.IChildInfoService#getChildinfoByChildInfoID(long)
	 */
	@Override
	public Childinfo getChildinfoByChildInfoID(long ChildInfoID) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pers.sg.kms.services.IChildInfoService#updateChildinfoByChildInfoID(long)
	 */
	@Override
	public Childinfo updateChildinfoByChildInfoID(long ChildInfoID) {
		// TODO Auto-generated method stub
		return null;
	}

}
