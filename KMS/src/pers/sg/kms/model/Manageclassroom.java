package pers.sg.kms.model;

/**
 * Manageclassroom entity. @author MyEclipse Persistence Tools
 */

public class Manageclassroom implements java.io.Serializable {

	// Fields

	private long manageClassId;
	private Classroom classroom;
	private Userinfo userinfo;

	// Constructors

	/** default constructor */
	public Manageclassroom() {
	}

	/** full constructor */
	public Manageclassroom(Classroom classroom, Userinfo userinfo) {
		this.classroom = classroom;
		this.userinfo = userinfo;
	}

	// Property accessors

	public long getManageClassId() {
		return this.manageClassId;
	}

	public void setManageClassId(long manageClassId) {
		this.manageClassId = manageClassId;
	}

	public Classroom getClassroom() {
		return this.classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

}