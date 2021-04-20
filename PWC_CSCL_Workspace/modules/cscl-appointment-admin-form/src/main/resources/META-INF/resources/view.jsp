<%@ include file="/init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="cscl.appointment.admin.form.constants.CsclAppointmentAdminFormPortletKeys" %>
<%@page import="java.io.OutputStream" %>
<%@page import="javax.portlet.PortletSession" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.ActionResponse"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.List"%>
<%@page import="cscl.appointment.admin.table.service.csclAppointmentAdminLocalServiceUtil"%>
<%@page import="com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys"%>
<%@page import="cscl.appointment.booking.model.CsclAppointeeMaster" %>
<%@page import="cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil" %>
<%@page import="cscl.appointment.admin.table.model.csclAppointmentAdmin" %>
<%@page import="cscl.appointment.admin.table.service.csclAppointmentAdminLocalServiceUtil" %>

<liferay-ui:error key="duplicateEntry-errorMessage" message="Entry for this appointee is already present, kindly update the same" />
<liferay-ui:success key="success" message="Data has been updated"/>
<liferay-ui:error key="DeleteMessage" message="Entry has been deleted!" />

<liferay-portlet:actionURL var="searchURL" name="SearchRecordAction">
	<liferay-portlet:param name="cmd" value="SearchRecord"/>
</liferay-portlet:actionURL> 

<portlet:defineObjects />
 
<%
System.out.print("Starting of the code");
//List<AdminModule> users =AdminModuleLocalServiceUtil.getAdminModules(0,AdminModuleLocalServiceUtil.getAdminModulesCount());

//List<AdminModule> users =AdminModuleLocalServiceUtil.findAll();


List<csclAppointmentAdmin> users =csclAppointmentAdminLocalServiceUtil.findAll();

//List<AdminModule> users= (List<AdminModule>)request.getAttribute("users");
	request.setAttribute("users", users);
	System.out.println("users"+users);

%>

<portlet:renderURL var="addUserRenderURL">
    <portlet:param name="mvcPath" value="/sample.jsp"/>
</portlet:renderURL>
 
<div class="mb-5">
    <a href="<%= addUserRenderURL %>" class="btn  btn-primary btn-default">
        <i class="glyphicon glyphicon-plus"></i> Add Appointement </a>
</div>
<table class="table table-striped">
    <tr >
       <th>Id</th>
       <th>Appointee</th>
 		<th>Available Date</th>
 		<th>From Time</th>
 		<th>To Time</th>
        <th colspan="2" style="width: 100px">Action</th>
    </tr>
    <c:forEach items="${users}" var="student">  
    
        <portlet:renderURL var="updateUserRenderURL">
            <portlet:param name="mvcPath" value="/update.jsp"/>
            <portlet:param name="Id" value="${student.getAppointeeId()}"/>
           <%--  <portlet:param name="Appointee" value="${student.getAppointee()}"/>
            <portlet:param name="Available Date" value="${student.getAppointedDate()}"/>
            <portlet:param name="Available Time" value="${student.getFromTime()}"/> --%>

        </portlet:renderURL>
        
        <portlet:actionURL name="deleteUser" var="deleteUserActionURL">
            <portlet:param name="Appointee" value="${student.getID()}"/>
        </portlet:actionURL>
                
        <tr> 
            <td>${student.getAppointeeId()}</td>
            <td>${student.getAppointee()}</td>
            <td>${student.getAppointedDate()}</td>
            <td>${student.getFromTime()}</td>
             <td>${student.getToTime()}</td>
 
            <td class="text-center" style="width: 50px">
                <a href="<%=updateUserRenderURL%>" class="btn  btn-primary btn-default btn-sm px-2 py-1" >
                <i class ="glyphicon glyphicon-edit"></i>
                </a>
            </td> 
            <td class="text-center" style="width:50px">
                <a href="<%=deleteUserActionURL%>" 
                    class="btn  btn-primary btn-default btn-sm px-2 py-1"
                    onclick="return confirm('Are you sure you want to delete this item?');"> 
                    <i class ="glyphicon glyphicon-remove"></i>
                </a>
            </td>                                     
         </tr>
    </c:forEach>
</table>








