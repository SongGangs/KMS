/**
 * 
 */
package pers.sg.kms.viewmodel;

import java.util.List;

import pers.sg.kms.model.Userinfo;

/**
 * @Title:DynamicViewModel
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ29ÈÕ
 */
public class DynamicIndexViewModel {
	private Userinfo userinfo;
	private List<SingleDynamicModel> dynamicModelslist;

	public DynamicIndexViewModel() {
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo Userinfo) {
		this.userinfo = Userinfo;
	}

	/**
	 * @return the dynamicModelslist
	 */
	public List<SingleDynamicModel> getDynamicModelslist() {
		return dynamicModelslist;
	}

	/**
	 * @param dynamicModelslist
	 *            the dynamicModelslist to set
	 */
	public void setDynamicModelslist(List<SingleDynamicModel> dynamicModelslist) {
		this.dynamicModelslist = dynamicModelslist;
	}

}
