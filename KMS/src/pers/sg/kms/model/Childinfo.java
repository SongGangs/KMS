package pers.sg.kms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Childinfo entity. @author MyEclipse Persistence Tools
 */

public class Childinfo implements java.io.Serializable {

	// Fields

	private long childInfoId;
	private Family family;
	private String childName;
	private short gender;
	private Date birthday;
	private String headImage;
	private Set goschoolrecords = new HashSet(0);
	private Set leaveschools = new HashSet(0);

	// Constructors

	/** default constructor */
	public Childinfo() {
	}

	/** full constructor */
	public Childinfo(Family family, String childName, short gender, Date birthday, String headImage,
			Set goschoolrecords, Set leaveschools) {
		this.family = family;
		this.childName = childName;
		this.gender = gender;
		this.birthday = birthday;
		this.headImage = headImage;
		this.goschoolrecords = goschoolrecords;
		this.leaveschools = leaveschools;
	}

	// Property accessors

	public long getChildInfoId() {
		return this.childInfoId;
	}

	public void setChildInfoId(long childInfoId) {
		this.childInfoId = childInfoId;
	}

	public Family getFamily() {
		return this.family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public String getChildName() {
		return this.childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public short getGender() {
		return this.gender;
	}

	public void setGender(short gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHeadImage() {
		return this.headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public Set getGoschoolrecords() {
		return this.goschoolrecords;
	}

	public void setGoschoolrecords(Set goschoolrecords) {
		this.goschoolrecords = goschoolrecords;
	}

	public Set getLeaveschools() {
		return this.leaveschools;
	}

	public void setLeaveschools(Set leaveschools) {
		this.leaveschools = leaveschools;
	}

}