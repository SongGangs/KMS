/**
 * 
 */
package pers.sg.kms.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sg.kms.daos.CommentdetailDAO;
import pers.sg.kms.model.Commentdetail;
import pers.sg.kms.services.ICommentDetailService;

/**
 * @Title:CommentServiceImp
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ29ÈÕ
 */
@Service
public class CommentDetailServiceImp implements ICommentDetailService {

	@Autowired
	private CommentdetailDAO CommentDAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<Commentdetail> getCommentsByDynamicId(long id) {
		// TODO Auto-generated method stub
		return CommentDAO.findByProperty("dynamicinfo.dynamicId", id);
	}

	@Override
	public Commentdetail add(Commentdetail c) {
		try {
			return CommentDAO.save(c);
		} catch (Exception e) {
			return new Commentdetail();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commentdetail> getCommentsByPublishCommentId(long id) {

		return CommentDAO.findByProperty("publishcomment.publishCommentId", id);
	}

}
