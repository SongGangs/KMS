package pers.sg.kms.model;

/**
 * Zambia entity. @author MyEclipse Persistence Tools
 */

public class Zambia implements java.io.Serializable {

	// Fields

	private long zambiaId;
	private Userinfo userinfo;
	private Dynamicinfo dynamicinfo;

	// Constructors

	/** default constructor */
	public Zambia() {
	}

	/** full constructor */
	public Zambia(Userinfo userinfo, Dynamicinfo dynamicinfo) {
		this.userinfo = userinfo;
		this.dynamicinfo = dynamicinfo;
	}

	// Property accessors

	public long getZambiaId() {
		return this.zambiaId;
	}

	public void setZambiaId(long zambiaId) {
		this.zambiaId = zambiaId;
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