<%-- <%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="java.io.OutputStream" %>
<%@page import="javax.portlet.PortletSession" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.ActionResponse"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="java.util.Collections"%>
<%@page import="cscl.appointment.booking.model.CsclAppointeeMaster" %>
<%@page import="cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil" %>
<%@page import="cscl.appointment.admin.form.constants.CsclAppointmentAdminFormPortletKeys" %>

<%	
String uniqueId=ParamUtil.getString(request, "Id");
System.out.println("uniqueId"+uniqueId);
long ID=Long.parseLong(uniqueId);  
CsclAppointeeAdmin CustObj=CsclAppointeeAdminLocalServiceUtil.getCsclAppointeeAdmin(ID);
%>

<aui:form name="newform" method="post">
<aui:fieldset>
<aui:col cssClass="lfr-api-navigation" width="<%= 50 %>">

<aui:input name="Appointee" type="text" lable=" " value="<%=CustObj.getAppointee()%>" readonly="true"></aui:input>
<aui:input name="Date" type="text" lable=" " value="<%=CustObj.getAppointedDate()%>"></aui:input>
<aui:input name="Time" type="text" lable=" " value="<%=CustObj.getFromTime()%>"></aui:input>

 </aui:col>
</aui:fieldset>

<aui:button type="submit" value="Update"></aui:button>

<aui:button type="Cancel" value="Back"></aui:button>

</aui:form> --%>