package pers.sg.kms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Usercatalog entity. @author MyEclipse Persistence Tools
 */

public class Usercatalog implements java.io.Serializable {

	// Fields

	private short userCatalogId;
	private String userCatalogName;
	private Set userinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Usercatalog() {
	}

	/** full constructor */
	public Usercatalog(String userCatalogName, Set userinfos) {
		this.userCatalogName = userCatalogName;
		this.userinfos = userinfos;
	}

	// Property accessors

	public short getUserCatalogId() {
		return this.userCatalogId;
	}

	public void setUserCatalogId(short userCatalogId) {
		this.userCatalogId = userCatalogId;
	}

	public String getUserCatalogName() {
		return this.userCatalogName;
	}

	public void setUserCatalogName(String userCatalogName) {
		this.userCatalogName = userCatalogName;
	}

	public Set getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set userinfos) {
		this.userinfos = userinfos;
	}

}