package pers.sg.kms.model;

/**
 * Images entity. @author MyEclipse Persistence Tools
 */

public class Images implements java.io.Serializable {

	// Fields

	private long imagesId;
	private Dynamicinfo dynamicinfo;
	private String imagesAddress;

	// Constructors

	/** default constructor */
	public Images() {
	}

	/** full constructor */
	public Images(Dynamicinfo dynamicinfo, String imagesAddress) {
		this.dynamicinfo = dynamicinfo;
		this.imagesAddress = imagesAddress;
	}

	// Property accessors

	public long getImagesId() {
		return this.imagesId;
	}

	public void setImagesId(long imagesId) {
		this.imagesId = imagesId;
	}

	public Dynamicinfo getDynamicinfo() {
		return this.dynamicinfo;
	}

	public void setDynamicinfo(Dynamicinfo dynamicinfo) {
		this.dynamicinfo = dynamicinfo;
	}

	public String getImagesAddress() {
		return this.imagesAddress;
	}

	public void setImagesAddress(String imagesAddress) {
		this.imagesAddress = imagesAddress;
	}

}