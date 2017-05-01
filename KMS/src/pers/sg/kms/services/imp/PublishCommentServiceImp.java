/**
 * 
 */
package pers.sg.kms.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sg.kms.daos.PublishcommentDAO;
import pers.sg.kms.model.Publishcomment;
import pers.sg.kms.services.IPublishCommentService;

/**
 * @Title:PublishCommentServiceImp
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ31ÈÕ
 */
@Service
public class PublishCommentServiceImp implements IPublishCommentService {

	@Autowired
	private PublishcommentDAO publishcommentDAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<Publishcomment> getAll() {

		return publishcommentDAO.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publishcomment> getAllPublishcommentByDynamicInfoID(long id) {

		return publishcommentDAO.findByProperty("dynamicinfo.dynamicId", id);
	}

	@Override
	public Publishcomment add(Publishcomment pc) {

		return publishcommentDAO.save(pc);
	}

	@Override
	public Publishcomment getPublishcommentByPublishcommentID(long id) {

		return publishcommentDAO.findById(id);
	}

}
