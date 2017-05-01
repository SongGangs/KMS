/**
 * 
 */
package pers.sg.kms.viewmodel;

import java.util.List;
import java.util.Map;

import pers.sg.kms.model.Commentdetail;
import pers.sg.kms.model.Dynamicinfo;
import pers.sg.kms.model.Userinfo;
import pers.sg.kms.model.Zambia;

/**
 * @Title:SingleDynamicModel
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ29ÈÕ
 */
public class SingleDynamicModel {
	private Userinfo userinfo;
	private List<Zambia> zambialist;
	private Map<Commentdetail, List<Commentdetail>> commentmapMap;
	private Dynamicinfo dynamicinfo;

	/**
	 * @return the userinfo
	 */
	public Userinfo getUserinfo() {
		return userinfo;
	}

	/**
	 * @param userinfo
	 *            the userinfo to set
	 */
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	/**
	 * @return the zambialist
	 */
	public List<Zambia> getZambialist() {
		return zambialist;
	}

	/**
	 * @param zambialist
	 *            the zambialist to set
	 */
	public void setZambialist(List<Zambia> zambialist) {
		this.zambialist = zambialist;
	}

	/**
	 * @return the dynamicinfo
	 */
	public Dynamicinfo getDynamicinfo() {
		return dynamicinfo;
	}

	/**
	 * @param dynamicinfo
	 *            the dynamicinfo to set
	 */
	public void setDynamicinfo(Dynamicinfo dynamicinfo) {
		this.dynamicinfo = dynamicinfo;
	}

	/**
	 * @return the commentmapMap //
	 */
	public Map<Commentdetail, List<Commentdetail>> getCommentmapMap() {
		return commentmapMap;
	}

	/**
	 * @param commentmapMap
	 *            the commentmapMap to set
	 */
	public void setCommentmapMap(Map<Commentdetail, List<Commentdetail>> commentmapMap) {
		this.commentmapMap = commentmapMap;
	}

}
