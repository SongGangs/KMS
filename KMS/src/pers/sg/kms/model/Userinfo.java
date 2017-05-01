package pers.sg.kms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private long userRecId;
	private Family family;
	private Usercatalog usercatalog;
	private String userName;
	private String password;
	private Date registerTime;
	private String image;
	private String phoneNumber;
	private short gender;
	private Integer activeValue;
	private String identity;
	private Set publishdynamics = new HashSet(0);
	private Set collectiondynamicses = new HashSet(0);
	private Set addressinfos = new HashSet(0);
	private Set commentdetailsForYouUserRecId = new HashSet(0);
	private Set commentdetailsForUserRecId = new HashSet(0);
	private Set shoppings = new HashSet(0);
	private Set zambias = new HashSet(0);
	private Set manageclassrooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** full constructor */
	public Userinfo(Family family, Usercatalog usercatalog, String userName, String password, Date registerTime,
			String image, String phoneNumber, short gender, Integer activeValue, String identity, Set publishdynamics,
			Set collectiondynamicses, Set addressinfos, Set commentdetailsForYouUserRecId,
			Set commentdetailsForUserRecId, Set shoppings, Set zambias, Set manageclassrooms) {
		this.family = family;
		this.usercatalog = usercatalog;
		this.userName = userName;
		this.password = password;
		this.registerTime = registerTime;
		this.image = image;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.activeValue = activeValue;
		this.identity = identity;
		this.publishdynamics = publishdynamics;
		this.collectiondynamicses = collectiondynamicses;
		this.addressinfos = addressinfos;
		this.commentdetailsForYouUserRecId = commentdetailsForYouUserRecId;
		this.commentdetailsForUserRecId = commentdetailsForUserRecId;
		this.shoppings = shoppings;
		this.zambias = zambias;
		this.manageclassrooms = manageclassrooms;
	}

	// Property accessors

	public long getUserRecId() {
		return this.userRecId;
	}

	public void setUserRecId(long userRecId) {
		this.userRecId = userRecId;
	}

	public Family getFamily() {
		return this.family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Usercatalog getUsercatalog() {
		return this.usercatalog;
	}

	public void setUsercatalog(Usercatalog usercatalog) {
		this.usercatalog = usercatalog;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public short getGender() {
		return this.gender;
	}

	public void setGender(short gender) {
		this.gender = gender;
	}

	public Integer getActiveValue() {
		return this.activeValue;
	}

	public void setActiveValue(Integer activeValue) {
		this.activeValue = activeValue;
	}

	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Set getPublishdynamics() {
		return this.publishdynamics;
	}

	public void setPublishdynamics(Set publishdynamics) {
		this.publishdynamics = publishdynamics;
	}

	public Set getCollectiondynamicses() {
		return this.collectiondynamicses;
	}

	public void setCollectiondynamicses(Set collectiondynamicses) {
		this.collectiondynamicses = collectiondynamicses;
	}

	public Set getAddressinfos() {
		return this.addressinfos;
	}

	public void setAddressinfos(Set addressinfos) {
		this.addressinfos = addressinfos;
	}

	public Set getCommentdetailsForYouUserRecId() {
		return this.commentdetailsForYouUserRecId;
	}

	public void setCommentdetailsForYouUserRecId(Set commentdetailsForYouUserRecId) {
		this.commentdetailsForYouUserRecId = commentdetailsForYouUserRecId;
	}

	public Set getCommentdetailsForUserRecId() {
		return this.commentdetailsForUserRecId;
	}

	public void setCommentdetailsForUserRecId(Set commentdetailsForUserRecId) {
		this.commentdetailsForUserRecId = commentdetailsForUserRecId;
	}

	public Set getShoppings() {
		return this.shoppings;
	}

	public void setShoppings(Set shoppings) {
		this.shoppings = shoppings;
	}

	public Set getZambias() {
		return this.zambias;
	}

	public void setZambias(Set zambias) {
		this.zambias = zambias;
	}

	public Set getManageclassrooms() {
		return this.manageclassrooms;
	}

	public void setManageclassrooms(Set manageclassrooms) {
		this.manageclassrooms = manageclassrooms;
	}

}