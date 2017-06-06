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
	private Set childinfos = new HashSet(0);
	private Set userinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Family() {
	}

	/** full constructor */
	public Family(String familyName, Set childinfos, Set userinfos) {
		this.familyName = familyName;
		this.childinfos = childinfos;
		this.userinfos = userinfos;
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

	public Set getChildinfos() {
		return this.childinfos;
	}

	public void setChildinfos(Set childinfos) {
		this.childinfos = childinfos;
	}

	public Set getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set userinfos) {
		this.userinfos = userinfos;
	}

}