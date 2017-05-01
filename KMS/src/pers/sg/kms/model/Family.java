package pers.sg.kms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Family entity. @author MyEclipse Persistence Tools
 */

public class Family implements java.io.Serializable {

	// Fields

	private long familyId;
	private String familyName;
	private Set userinfos = new HashSet(0);
	private Set childinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Family() {
	}

	/** full constructor */
	public Family(String familyName, Set userinfos, Set childinfos) {
		this.familyName = familyName;
		this.userinfos = userinfos;
		this.childinfos = childinfos;
	}

	// Property accessors

	public long getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(long familyId) {
		this.familyId = familyId;
	}

	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Set getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set userinfos) {
		this.userinfos = userinfos;
	}

	public Set getChildinfos() {
		return this.childinfos;
	}

	public void setChildinfos(Set childinfos) {
		this.childinfos = childinfos;
	}

}