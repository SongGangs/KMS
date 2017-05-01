package pers.sg.kms.model;

/**
 * Collectiondynamics entity. @author MyEclipse Persistence Tools
 */

public class Collectiondynamics implements java.io.Serializable {

	// Fields

	private long collectionId;
	private Userinfo userinfo;
	private Dynamicinfo dynamicinfo;

	// Constructors

	/** default constructor */
	public Collectiondynamics() {
	}

	/** full constructor */
	public Collectiondynamics(Userinfo userinfo, Dynamicinfo dynamicinfo) {
		this.userinfo = userinfo;
		this.dynamicinfo = dynamicinfo;
	}

	// Property accessors

	public long getCollectionId() {
		return this.collectionId;
	}

	public void setCollectionId(long collectionId) {
		this.collectionId = collectionId;
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

}