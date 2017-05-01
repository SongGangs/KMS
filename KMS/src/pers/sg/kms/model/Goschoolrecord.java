package pers.sg.kms.model;

import java.util.Date;

/**
 * Goschoolrecord entity. @author MyEclipse Persistence Tools
 */

public class Goschoolrecord implements java.io.Serializable {

	// Fields

	private long recordId;
	private Childinfo childinfo;
	private Goschoolstate goschoolstate;
	private Date recordTime;

	// Constructors

	/** default constructor */
	public Goschoolrecord() {
	}

	/** full constructor */
	public Goschoolrecord(Childinfo childinfo, Goschoolstate goschoolstate, Date recordTime) {
		this.childinfo = childinfo;
		this.goschoolstate = goschoolstate;
		this.recordTime = recordTime;
	}

	// Property accessors

	public long getRecordId() {
		return this.recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}

	public Childinfo getChildinfo() {
		return this.childinfo;
	}

	public void setChildinfo(Childinfo childinfo) {
		this.childinfo = childinfo;
	}

	public Goschoolstate getGoschoolstate() {
		return this.goschoolstate;
	}

	public void setGoschoolstate(Goschoolstate goschoolstate) {
		this.goschoolstate = goschoolstate;
	}

	public Date getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

}