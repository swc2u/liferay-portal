package com.cscl.appointment.booking.admin.portlet.util;

public class EmailRequestUtil {

	public EmailRequestUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String email;
	private String subject;
	private String body;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "EmailRequestUtil [email=" + email + ", subject=" + subject + ", body=" + body + ", getEmail()="
				+ getEmail() + ", getSubject()=" + getSubject() + ", getBody()=" + getBody() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
