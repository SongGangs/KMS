package pers.sg.kms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private long productId;
	private String productName;
	private String productPicture;
	private String introduce;
	private float productVaule;
	private Set shoppings = new HashSet(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(String productName, String productPicture, String introduce, float productVaule, Set shoppings) {
		this.productName = productName;
		this.productPicture = productPicture;
		this.introduce = introduce;
		this.productVaule = productVaule;
		this.shoppings = shoppings;
	}

	// Property accessors

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPicture() {
		return this.productPicture;
	}

	public void setProductPicture(String productPicture) {
		this.productPicture = productPicture;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public float getProductVaule() {
		return this.productVaule;
	}

	public void setProductVaule(float productVaule) {
		this.productVaule = productVaule;
	}

	public Set getShoppings() {
		return this.shoppings;
	}

	public void setShoppings(Set shoppings) {
		this.shoppings = shoppings;
	}

}