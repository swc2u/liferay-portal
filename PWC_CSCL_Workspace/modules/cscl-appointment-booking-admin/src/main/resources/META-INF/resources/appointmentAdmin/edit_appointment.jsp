<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ include file="../init.jsp" %>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="javax.portlet.PortletSession"%>

<%@page import="cscl.appointment.booking.model.CsclStatus" %>
<%@page import="cscl.appointment.booking.service.CsclStatusLocalServiceUtil" %>
<%@page import="cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil"%>
<%@page import="cscl.appointment.booking.model.CsclAppointmentMaster"%>
<%@page import="cscl.appointment.booking.model.CsclAppointeeMaster" %>
<%@page import="cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil" %>
<%@page import="com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys"%>
<%@page import="cscl.appointment.booking.model.CsclAppointmentTimeSlots" %>
<%@page import="cscl.appointment.booking.service.CsclAppointmentTimeSlotsLocalServiceUtil" %>
<%@page import="cscl.appointment.booking.model.CsclAdminTimeSlots" %>
<%@page import="cscl.appointment.booking.service.CsclAdminTimeSlotsLocalServiceUtil" %>

<script src="https://cdn.alloyui.com/3.0.1/aui/aui-min.js"></script>

<%
String redirect = ParamUtil.getString(request, "redirect");

List<CsclAdminTimeSlots> TimeSlot =CsclAdminTimeSlotsLocalServiceUtil.getCsclAdminTimeSlotses(0,CsclAdminTimeSlotsLocalServiceUtil.getCsclAdminTimeSlotsesCount());

CsclAppointmentMaster appointment = (CsclAppointmentMaster)request.getAttribute(CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN);

List<CsclStatus> statusList = new ArrayList<CsclStatus>();
List<CsclAppointeeMaster> appointees = new ArrayList<CsclAppointeeMaster>();
CsclAppointmentMaster appointmentObj = null;
long appointmentId = ParamUtil.getLong(request, "appointmentId");
System.out.println("appointmentId"+appointmentId);

Calendar cal = Calendar.getInstance();
try{
	statusList = CsclStatusLocalServiceUtil.getActiveStatuses();
	System.out.println("***statusList***"+statusList);
	appointmentObj = CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMaster(appointmentId);
	System.out.println("****appointmentObj***"+appointmentObj);
	cal.setTime(appointmentObj.getPreferedDate());
}catch(Exception e){
	System.err.println("Error : While getting Status");
}
Date dateAge = new Date();
String formatedDate = "";
// Get Default VAlues
try{
	appointees = CsclAppointeeMasterLocalServiceUtil.getActiveAppointees();
	System.out.println("****appointees:---***"+appointees);
}catch(Exception e1){
	System.err.println("Error : While getting default values");
}
%>

<liferay-ui:error key="TimeSlot_error" message="Kindly select another time slot" />
<liferay-ui:success key="success-booking-appointment" message="Appointment has been confirmed" />
<liferay-portlet:actionURL name="/appointmentAdmin/edit_appointment" refererPlid="<%=themeDisplay.getRefererPlid()%>" var="editAppointmentURL">
	<portlet:param name="mvcPath" value="/appointmentAdmin/edit_appointment.jsp" />
</liferay-portlet:actionURL>

<aui:form action="<%=editAppointmentURL%>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="" />
	<aui:input name="redirect" type="hidden" value="<%=redirect%>" />
	<aui:input name="appointmentId" type="hidden" value="<%=appointmentId%>" />

	<aui:model-context bean="<%=appointment%>" model="<%=CsclAppointmentMaster.class%>" />
	<div class="row">
		<div class="col-md-12" style="margin-bottom: 1rem;">
			<h4>Appointment Details</h4>
			<hr>
		</div>
		<div class="col-md-6">
			<aui:input name="name" placeholder="name" label="name" value="<%=appointmentObj.getName() %>" disabled="true"/>
		</div>
		<div class="col-md-6">
			<aui:input name="email" placeholder="email" label="email" value="<%=appointmentObj.getEmail() %>" disabled="true">
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input name="mobile" placeholder="mobile" label="mobile" value="<%=appointmentObj.getMobile() %>" disabled="true">
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input name="refId" placeholder="refId" label="refId" value="<%=appointmentObj.getRefId() %>" disabled="true"/>
		</div>
		<div class="col-md-6">
			<aui:input label="preferedDate" name="preferedDate" placeholder="preferedDate" disabled="true"/>
		</div>
		<div class="col-md-6" style="display:none;">
			<aui:input label="preferedTime" name="preferedTime" placeholder="preferedTime" value="<%=appointmentObj.getPreferedTime() %>" disabled="true">
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input label="reason" name="reason" placeholder="reason" value="<%=appointmentObj.getReason() %>" disabled="true"/>
		</div>
		<div class="col-md-6">
			<aui:input name="address" placeholder="address" label="address" disabled="true" required="false" aria-required="false"/>
		</div>
		<div class="col-md-6">
			<aui:select name="appointee" label="appointee" disabled="true">
				<aui:option value="" >Select Appointee</aui:option>
				<%for(CsclAppointeeMaster appointee : appointees){ %>
					<aui:option value="<%=appointee.getId_() %>" ><%=appointee.getName() %> (<%=appointee.getDesignation() %>)</aui:option>
				<%} %>
			</aui:select>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-6 name-field">
			<aui:select name="status" label="status">
			<aui:option value="" >Select Status</aui:option>
				<aui:option value="2" >Approve</aui:option>
				<aui:option value="3" >Reject</aui:option>
				<aui:validator name="required" ></aui:validator>
			</aui:select>
		</div>
		
	<div class="col-md-6">
		<aui-label>Select TimeSlot</aui-label>
		<%-- <input style="width: 310px;" class="form-control timetrigger" id="<portlet:namespace />starttime" type="text" id="timepicker" name="<portlet:namespace/>starttime" required="true" placeholder="From">
 		<input style="width: 310px;" class="form-control timetrigger" id="<portlet:namespace />endtime" type="text" id="timepicker" name="<portlet:namespace/>endtime" required="true" placeholder="to">	
 --%>	
 				<aui:select id="starttime0" name="starttime0" label="" placeholder="From">
				<aui:option value="" >FromTime</aui:option>
				<%for(CsclAdminTimeSlots TimeSlots : TimeSlot){%>
					<aui:option value="<%=TimeSlots.getTimeslot()%>" ><%=TimeSlots.getTimeslot()%></aui:option>
				<%}%>
			</aui:select>
				
			<aui:select id="endtime0" name="endtime0" label="" placeholder="To">
				<aui:option value="" >ToTime</aui:option>
				<%for(CsclAdminTimeSlots TimeSlots : TimeSlot){%>
					<aui:option value="<%=TimeSlots.getTimeslot()%>" ><%=TimeSlots.getTimeslot()%></aui:option>
				<%}%>
			</aui:select> 
 </div>
	
		<div class="col-md-6">
			<aui:input label="comment" name="comment" placeholder="comment" value="" required="true">
			</aui:input>
		</div>
	</div>
	
	<aui:button-row>
	<%if(appointmentObj.getStatus() > 1){ %>
		<a href="<%=redirect%>"><aui:button type="cancel" /></a>
	<%}else{ %>
		<aui:button type="submit" />
		<a href="<%=redirect%>"><aui:button type="cancel" /></a>
	<%} %>
	</aui:button-row>
</aui:form>
<aui:script>
	$(document).ready(function(){
		var temp = $('#<portlet:namespace />preferedTime').val();
		console.log("temp"+temp);
  		$('#<portlet:namespace />preferedDateTime').val(temp);
	});
</aui:script>


<script>
YUI().use('aui-timepicker',function(Y) {
		    new Y.TimePicker(
		      {
		        trigger: '#<portlet:namespace/>starttime',
		        popover: {
		          zIndex: 1
		        },
		        on: {
		          selectionChange: function(event) {
		            console.log(event.newSelection)
		          }
		        }
		      }
		    );
		  }
		);
</script> 

 <script>
YUI().use('aui-timepicker',function(Y) {
		    new Y.TimePicker(
		      {
		        trigger: '#<portlet:namespace/>endtime',
		        popover: {
		          zIndex: 1
		        },
		        on: {
		          selectionChange: function(event) {
		            console.log(event.newSelection)
		          }
		        }
		      }
		    );
		  }
		);
</script> 