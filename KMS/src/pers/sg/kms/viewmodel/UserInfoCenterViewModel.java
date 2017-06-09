/**
 * 
 */
package pers.sg.kms.viewmodel;

import java.util.List;

import pers.sg.kms.model.Addressinfo;
import pers.sg.kms.model.Childinfo;
import pers.sg.kms.model.Userinfo;

/**
 * @Title:AddressRemoveViewModel
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ21ÈÕ
 */
public class UserInfoCenterViewModel {
	private Userinfo userinfo;
	private List<Userinfo> userinfolist;
	private List<Addressinfo> addressinfos;
	private List<Childinfo> childinfolist;
	private String rootPath;

	public UserInfoCenterViewModel() {
	}

	public UserInfoCenterViewModel(Userinfo user, List<Userinfo> list, List<Addressinfo> addressinfos,
			List<Childinfo> childinfos) {
		this.userinfo = user;
		this.userinfolist = list;
		this.addressinfos = addressinfos;
		this.childinfolist = childinfos;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo Userinfo) {
		this.userinfo = Userinfo;
	}

	public List<Userinfo> getUserinfolist() {
		return userinfolist;
	}

	public void setUserinfolist(List<Userinfo> userinfolist) {
		this.userinfolist = userinfolist;
	}

	/**
	 * @return the addressinfos
	 */
	public List<Addressinfo> getAddressinfos() {
		return addressinfos;
	}

	/**
	 * @param addressinfos
	 *            the addressinfos to set
	 */
	public void setAddressinfos(List<Addressinfo> addressinfos) {
		this.addressinfos = addressinfos;
	}

	/**
	 * @return the childinfolist
	 */
	public List<Childinfo> getChildinfolist() {
		return childinfolist;
	}

	/**
	 * @param childinfolist
	 *            the childinfolist to set
	 */
	public void setChildinfolist(List<Childinfo> childinfolist) {
		this.childinfolist = childinfolist;
	}

	/**
	 * @return the rootPath
	 */
	public String getRootPath() {
		return rootPath;
	}

	/**
	 * @param rootPath
	 *            the rootPath to set
	 */
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

}
