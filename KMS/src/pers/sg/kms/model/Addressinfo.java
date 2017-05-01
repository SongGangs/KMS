package pers.sg.kms.model;

/**
 * Addressinfo entity. @author MyEclipse Persistence Tools
 */

public class Addressinfo implements java.io.Serializable {

	// Fields

	private long addressRecId;
	private Userinfo userinfo;
	private String addressName;
	private short isUsuallyAddress;

	// Constructors

	/** default constructor */
	public Addressinfo() {
	}

	/** full constructor */
	public Addressinfo(Userinfo userinfo, String addressName, short isUsuallyAddress) {
		this.userinfo = userinfo;
		this.addressName = addressName;
		this.isUsuallyAddress = isUsuallyAddress;
	}

	// Property accessors

	public long getAddressRecId() {
		return this.addressRecId;
	}

	public void setAddressRecId(long addressRecId) {
		this.addressRecId = addressRecId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getAddressName() {
		return this.addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public short getIsUsuallyAddress() {
		return this.isUsuallyAddress;
	}

	public void setIsUsuallyAddress(short isUsuallyAddress) {
		this.isUsuallyAddress = isUsuallyAddress;
	}

}