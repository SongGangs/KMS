package pers.sg.kms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Publishcomment entity. @author MyEclipse Persistence Tools
 */

public class Publishcomment implements java.io.Serializable {

	// Fields

	private long publishCommentId;
	private Dynamicinfo dynamicinfo;
	private Date time;
	private Set commentdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Publishcomment() {
	}

	/** full constructor */
	public Publishcomment(Dynamicinfo dynamicinfo, Date time, Set commentdetails) {
		this.dynamicinfo = dynamicinfo;
		this.time = time;
		this.commentdetails = commentdetails;
	}

	// Property accessors

	public long getPublishCommentId() {
		return this.publishCommentId;
	}

	public void setPublishCommentId(long publishCommentId) {
		this.publishCommentId = publishCommentId;
	}

	public Dynamicinfo getDynamicinfo() {
		return this.dynamicinfo;
	}

	public void setDynamicinfo(Dynamicinfo dynamicinfo) {
		this.dynamicinfo = dynamicinfo;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Set getCommentdetails() {
		return this.commentdetails;
	}

	public void setCommentdetails(Set commentdetails) {
		this.commentdetails = commentdetails;
	}

}