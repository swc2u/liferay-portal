<%@page import="cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil"%>
<%@page import="cscl.appointment.booking.service.CsclAppointmentMasterLocalService"%>
<%@ include file="../init.jsp" %>

<%@page import="cscl.appointment.booking.model.CsclAppointeeMaster" %>
<%@page import="cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil" %>
<%@page import="cscl.appointment.booking.model.CsclAppointmentMaster" %>
<%@page import="cscl.appointment.booking.web.constants.CsclAppointmentBookingWebPortletKeys" %>
<%@page import="cscl.appointment.admin.table.model.csclAppointmentAdmin" %>
<%@page import="cscl.appointment.admin.table.service.csclAppointmentAdminLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaUtil" %>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@page import="java.io.OutputStream" %>
<%@page import="javax.portlet.PortletSession" %>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="java.util.Date"%>

<%
long ID=((Long)(portletSession.getAttribute("id")));
System.out.println("ID"+ID);
List<CsclAppointmentMaster> appointees = CsclAppointmentMasterLocalServiceUtil.findByid_(ID);
System.out.println("CsclAppointmentMaster******"+appointees);

String name="";
String email="";
String mobile="";
String address="";
int SelectedAppointee;
Date preferedDate=new Date();
String reason="";
String PreferedTime="";

for (CsclAppointmentMaster temp : appointees) 
{
	name=temp.getName();
	email=temp.getEmail();
	mobile=temp.getMobile();
	address=temp.getAddress();
	SelectedAppointee=temp.getAppointee();
	preferedDate=temp.getPreferedDate();
	PreferedTime=temp.getPreferedTime();
	reason=temp.getReason();
}
%>

<div style="border: groove;padding-left: 15px;padding-right: 15px;padding-top: 15px;">
<aui:form cssClass="contact-form" name="fm" >

	<div class="row">
		<div class="col-md-6 name-field">
			<aui:input name="name" placeholder="name" label="name" value="<%=name%>" readonly="true">
			</aui:input>
		</div>
		
		<div class="col-md-6 email-field">
			<aui:input name="email" placeholder="email" label="email" value="<%=email%>" readonly="true">
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input name="mobile" placeholder="mobile" label="mobile" value="<%=mobile%>" readonly="true">
			</aui:input>
		</div>

		<div class="col-md-6">
			<aui:input name="address" placeholder="Address" label="address" value="<%=address%>" readonly="true">
			</aui:input>
		</div>
		
		<div class="col-md-6">
			<aui:input name="SelectedAppointee" placeholder="SelectedAppointee" label="SelectedAppointee" value="<%=SelectedAppointee%>" readonly="true">
			</aui:input>
		</div>
		
		<div class="col-md-6">
			<aui:input name="SelectedDate" placeholder="SelectedDate" label="SelectedDate" value="<%=preferedDate%>" readonly="true">
			</aui:input>
		</div>	
		
		<div class="col-md-6">
			<aui:input name="SelectedTime" placeholder="SelectedTime" label="SelectedTime" value="<%=PreferedTime%>" readonly="true">
			</aui:input>
		</div>	

		</div>
		<div class="col-md-6">
			<aui:input name="reason" placeholder="reason-appo" label="reason-appo" value="<%=reason%>">
			</aui:input>
		</div>
	
	
</aui:form>
</div>