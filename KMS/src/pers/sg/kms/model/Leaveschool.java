package pers.sg.kms.model;

import java.util.Date;

/**
 * Leaveschool entity. @author MyEclipse Persistence Tools
 */

public class Leaveschool implements java.io.Serializable {

	// Fields

	private long leaveId;
	private Leavecatalog leavecatalog;
	private Childinfo childinfo;
	private Date leaveData;
	private String leaveContent;

	// Constructors

	/** default constructor */
	public Leaveschool() {
	}

	/** full constructor */
	public Leaveschool(Leavecatalog leavecatalog, Childinfo childinfo, Date leaveData, String leaveContent) {
		this.leavecatalog = leavecatalog;
		this.childinfo = childinfo;
		this.leaveData = leaveData;
		this.leaveContent = leaveContent;
	}

	// Property accessors

	public long getLeaveId() {
		return this.leaveId;
	}

	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
	}

	public Leavecatalog getLeavecatalog() {
		return this.leavecatalog;
	}

	public void setLeavecatalog(Leavecatalog leavecatalog) {
		this.leavecatalog = leavecatalog;
	}

	public Childinfo getChildinfo() {
		return this.childinfo;
	}

	public void setChildinfo(Childinfo childinfo) {
		this.childinfo = childinfo;
	}

	public Date getLeaveData() {
		return this.leaveData;
	}

	public void setLeaveData(Date leaveData) {
		this.leaveData = leaveData;
	}

	public String getLeaveContent() {
		return this.leaveContent;
	}

	public void setLeaveContent(String leaveContent) {
		this.leaveContent = leaveContent;
	}

}