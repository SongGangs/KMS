package pers.sg.kms.model;

import java.util.Date;

/**
 * Publishdynamic entity. @author MyEclipse Persistence Tools
 */

public class Publishdynamic implements java.io.Serializable {

	// Fields

	private long publishDynamicId;
	private Userinfo userinfo;
	private Dynamicinfo dynamicinfo;
	private Date publishTime;

	// Constructors

	/** default constructor */
	public Publishdynamic() {
	}

	/** full constructor */
	public Publishdynamic(Userinfo userinfo, Dynamicinfo dynamicinfo, Date publishTime) {
		this.userinfo = userinfo;
		this.dynamicinfo = dynamicinfo;
		this.publishTime = publishTime;
	}

	// Property accessors

	public long getPublishDynamicId() {
		return this.publishDynamicId;
	}

	public void setPublishDynamicId(long publishDynamicId) {
		this.publishDynamicId = publishDynamicId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Dynamicinfo getDynamicinfo() {
		return this.dynamicinfo;
	}

	public void setDynamicinfo(Dynamicinfo dynamicinfo) {
		this.dynamicinfo = dynamicinfo;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

}