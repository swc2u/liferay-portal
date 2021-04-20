package com.cscl.appointment.booking.admin.portlet.action;

import com.cscl.appointment.booking.admin.portlet.util.EmailRequestUtil;
import com.cscl.appointment.booking.admin.portlet.util.RequestInfoUtil;

public class EmailWrapper {

	RequestInfoUtil requestInfoUtil;
	EmailRequestUtil email;
	
	public EmailRequestUtil getEmail() {
		return email;
	}
	
	public void setEmail(EmailRequestUtil email) {
		this.email = email;
	}
	
	
	
}
