package pers.sg.kms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Dynamicinfo entity. @author MyEclipse Persistence Tools
 */

public class Dynamicinfo implements java.io.Serializable {

	// Fields

	private long dynamicId;
	private String content;
	private short isAllow;
	private Date publishTime;
	private short authority;
	private Set imageses = new HashSet(0);
	private Set collectiondynamicses = new HashSet(0);
	private Set publishcomments = new HashSet(0);
	private Set zambias = new HashSet(0);
	private Set publishdynamics = new HashSet(0);

	// Constructors

	/** default constructor */
	public Dynamicinfo() {
	}

	/** full constructor */
	public Dynamicinfo(String content, short isAllow, Date publishTime, short authority, Set imageses,
			Set collectiondynamicses, Set publishcomments, Set zambias, Set publishdynamics) {
		this.content = content;
		this.isAllow = isAllow;
		this.publishTime = publishTime;
		this.authority = authority;
		this.imageses = imageses;
		this.collectiondynamicses = collectiondynamicses;
		this.publishcomments = publishcomments;
		this.zambias = zambias;
		this.publishdynamics = publishdynamics;
	}

	// Property accessors

	public long getDynamicId() {
		return this.dynamicId;
	}

	public void setDynamicId(long dynamicId) {
		this.dynamicId = dynamicId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public short getIsAllow() {
		return this.isAllow;
	}

	public void setIsAllow(short isAllow) {
		this.isAllow = isAllow;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public short getAuthority() {
		return this.authority;
	}

	public void setAuthority(short authority) {
		this.authority = authority;
	}

	public Set getImageses() {
		return this.imageses;
	}

	public void setImageses(Set imageses) {
		this.imageses = imageses;
	}

	public Set getCollectiondynamicses() {
		return this.collectiondynamicses;
	}

	public void setCollectiondynamicses(Set collectiondynamicses) {
		this.collectiondynamicses = collectiondynamicses;
	}

	public Set getPublishcomments() {
		return this.publishcomments;
	}

	public void setPublishcomments(Set publishcomments) {
		this.publishcomments = publishcomments;
	}

	public Set getZambias() {
		return this.zambias;
	}

	public void setZambias(Set zambias) {
		this.zambias = zambias;
	}

	public Set getPublishdynamics() {
		return this.publishdynamics;
	}

	public void setPublishdynamics(Set publishdynamics) {
		this.publishdynamics = publishdynamics;
	}

}