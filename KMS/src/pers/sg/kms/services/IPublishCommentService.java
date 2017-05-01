/**
 * 
 */
package pers.sg.kms.services;

import java.util.List;

import pers.sg.kms.model.Publishcomment;

/**
 * @Title:IPublishCommentService
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ31ÈÕ
 */
public interface IPublishCommentService {
	public List<Publishcomment> getAll();

	public List<Publishcomment> getAllPublishcommentByDynamicInfoID(long id);

	public Publishcomment add(Publishcomment pc);

	public Publishcomment getPublishcommentByPublishcommentID(long id);
}
