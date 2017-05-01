package pers.sg.kms.model;

import java.util.Date;

/**
 * Privateletter entity. @author MyEclipse Persistence Tools
 */

public class Privateletter implements java.io.Serializable {

	// Fields

	private long privateLetterId;
	private long sender;
	private long accepter;
	private String content;
	private Date time;
	private short isRead;

	// Constructors

	/** default constructor */
	public Privateletter() {
	}

	/** full constructor */
	public Privateletter(long sender, long accepter, String content, Date time, short isRead) {
		this.sender = sender;
		this.accepter = accepter;
		this.content = content;
		this.time = time;
		this.isRead = isRead;
	}

	// Property accessors

	public long getPrivateLetterId() {
		return this.privateLetterId;
	}

	public void setPrivateLetterId(long privateLetterId) {
		this.privateLetterId = privateLetterId;
	}

	public long getSender() {
		return this.sender;
	}

	public void setSender(long sender) {
		this.sender = sender;
	}

	public long getAccepter() {
		return this.accepter;
	}

	public void setAccepter(long accepter) {
		this.accepter = accepter;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public short getIsRead() {
		return this.isRead;
	}

	public void setIsRead(short isRead) {
		this.isRead = isRead;
	}

}