package pers.sg.kms.model;

import java.util.Date;

/**
 * Commentdetail entity. @author MyEclipse Persistence Tools
 */

public class Commentdetail implements java.io.Serializable {

	// Fields

	private long commentDetailId;
	private Userinfo userinfoByYouUserRecId;
	private Publishcomment publishcomment;
	private Userinfo userinfoByUserRecId;
	private String content;
	private Date commentDetailTime;

	// Constructors

	/** default constructor */
	public Commentdetail() {
	}

	/** full constructor */
	public Commentdetail(Userinfo userinfoByYouUserRecId, Publishcomment publishcomment, Userinfo userinfoByUserRecId,
			String content, Date commentDetailTime) {
		this.userinfoByYouUserRecId = userinfoByYouUserRecId;
		this.publishcomment = publishcomment;
		this.userinfoByUserRecId = userinfoByUserRecId;
		this.content = content;
		this.commentDetailTime = commentDetailTime;
	}

	// Property accessors

	public long getCommentDetailId() {
		return this.commentDetailId;
	}

	public void setCommentDetailId(long commentDetailId) {
		this.commentDetailId = commentDetailId;
	}

	public Userinfo getUserinfoByYouUserRecId() {
		return this.userinfoByYouUserRecId;
	}

	public void setUserinfoByYouUserRecId(Userinfo userinfoByYouUserRecId) {
		this.userinfoByYouUserRecId = userinfoByYouUserRecId;
	}

	public Publishcomment getPublishcomment() {
		return this.publishcomment;
	}

	public void setPublishcomment(Publishcomment publishcomment) {
		this.publishcomment = publishcomment;
	}

	public Userinfo getUserinfoByUserRecId() {
		return this.userinfoByUserRecId;
	}

	public void setUserinfoByUserRecId(Userinfo userinfoByUserRecId) {
		this.userinfoByUserRecId = userinfoByUserRecId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCommentDetailTime() {
		return this.commentDetailTime;
	}

	public void setCommentDetailTime(Date commentDetailTime) {
		this.commentDetailTime = commentDetailTime;
	}

}