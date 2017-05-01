package pers.sg.kms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Classroom entity. @author MyEclipse Persistence Tools
 */

public class Classroom implements java.io.Serializable {

	// Fields

	private long classId;
	private String className;
	private String classQrcode;
	private Set manageclassrooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classroom() {
	}

	/** full constructor */
	public Classroom(String className, String classQrcode, Set manageclassrooms) {
		this.className = className;
		this.classQrcode = classQrcode;
		this.manageclassrooms = manageclassrooms;
	}

	// Property accessors

	public long getClassId() {
		return this.classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassQrcode() {
		return this.classQrcode;
	}

	public void setClassQrcode(String classQrcode) {
		this.classQrcode = classQrcode;
	}

	public Set getManageclassrooms() {
		return this.manageclassrooms;
	}

	public void setManageclassrooms(Set manageclassrooms) {
		this.manageclassrooms = manageclassrooms;
	}

}