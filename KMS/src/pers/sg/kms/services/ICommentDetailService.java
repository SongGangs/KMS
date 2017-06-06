/**
 * 
 */
package pers.sg.kms.services;

import java.util.List;

import pers.sg.kms.model.Commentdetail;

/**
 * @Title:ICommentServices
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ29ÈÕ
 */
public interface ICommentDetailService {
	public List<Commentdetail> getCommentsByDynamicId(long id);

	// List<Comment>getComentsByIDAndNoYouId(long id);
	public Commentdetail add(Commentdetail c);

	public List<Commentdetail> getCommentsByPublishCommentId(long id);
}
