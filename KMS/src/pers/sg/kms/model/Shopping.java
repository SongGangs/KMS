package pers.sg.kms.model;

import java.util.Date;

/**
 * Shopping entity. @author MyEclipse Persistence Tools
 */

public class Shopping implements java.io.Serializable {

	// Fields

	private long shoppingId;
	private Userinfo userinfo;
	private Product product;
	private Date shoppingTime;

	// Constructors

	/** default constructor */
	public Shopping() {
	}

	/** minimal constructor */
	public Shopping(Date shoppingTime) {
		this.shoppingTime = shoppingTime;
	}

	/** full constructor */
	public Shopping(Userinfo userinfo, Product product, Date shoppingTime) {
		this.userinfo = userinfo;
		this.product = product;
		this.shoppingTime = shoppingTime;
	}

	// Property accessors

	public long getShoppingId() {
		return this.shoppingId;
	}

	public void setShoppingId(long shoppingId) {
		this.shoppingId = shoppingId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getShoppingTime() {
		return this.shoppingTime;
	}

	public void setShoppingTime(Date shoppingTime) {
		this.shoppingTime = shoppingTime;
	}

}