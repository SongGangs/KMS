package pers.sg.kms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Leavecatalog entity. @author MyEclipse Persistence Tools
 */

public class Leavecatalog implements java.io.Serializable {

	// Fields

	private short leaveCatalogId;
	private String leaveCatalogName;
	private Set leaveschools = new HashSet(0);

	// Constructors

	/** default constructor */
	public Leavecatalog() {
	}

	/** full constructor */
	public Leavecatalog(String leaveCatalogName, Set leaveschools) {
		this.leaveCatalogName = leaveCatalogName;
		this.leaveschools = leaveschools;
	}

	// Property accessors

	public short getLeaveCatalogId() {
		return this.leaveCatalogId;
	}

	public void setLeaveCatalogId(short leaveCatalogId) {
		this.leaveCatalogId = leaveCatalogId;
	}

	public String getLeaveCatalogName() {
		return this.leaveCatalogName;
	}

	public void setLeaveCatalogName(String leaveCatalogName) {
		this.leaveCatalogName = leaveCatalogName;
	}

	public Set getLeaveschools() {
		return this.leaveschools;
	}

	public void setLeaveschools(Set leaveschools) {
		this.leaveschools = leaveschools;
	}

}