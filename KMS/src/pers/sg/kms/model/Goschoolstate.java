package pers.sg.kms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Goschoolstate entity. @author MyEclipse Persistence Tools
 */

public class Goschoolstate implements java.io.Serializable {

	// Fields

	private short goSchoolStateId;
	private String goSchoolStateName;
	private Set goschoolrecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Goschoolstate() {
	}

	/** full constructor */
	public Goschoolstate(String goSchoolStateName, Set goschoolrecords) {
		this.goSchoolStateName = goSchoolStateName;
		this.goschoolrecords = goschoolrecords;
	}

	// Property accessors

	public short getGoSchoolStateId() {
		return this.goSchoolStateId;
	}

	public void setGoSchoolStateId(short goSchoolStateId) {
		this.goSchoolStateId = goSchoolStateId;
	}

	public String getGoSchoolStateName() {
		return this.goSchoolStateName;
	}

	public void setGoSchoolStateName(String goSchoolStateName) {
		this.goSchoolStateName = goSchoolStateName;
	}

	public Set getGoschoolrecords() {
		return this.goschoolrecords;
	}

	public void setGoschoolrecords(Set goschoolrecords) {
		this.goschoolrecords = goschoolrecords;
	}

}