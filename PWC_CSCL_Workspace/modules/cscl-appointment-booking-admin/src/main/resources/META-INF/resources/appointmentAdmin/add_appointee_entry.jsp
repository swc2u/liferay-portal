<%@page import="cscl.appointment.booking.model.CsclAppointmentTimeSlots"%>
<%@page import="cscl.appointment.booking.service.CsclAppointmentTimeSlotsLocalService"%>
<%@include file="/init.jsp" %>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="java.io.OutputStream" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.ActionResponse"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="java.util.List" %>
<%@page import="java.util.List"%>
<%@page import="cscl.appointment.booking.model.CsclAppointeeMaster" %>
<%@page import="cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil" %>
<%@page import="com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys"%>
<%@page import="cscl.appointment.booking.model.CsclAppointmentTimeSlots" %>
<%@page import="cscl.appointment.booking.service.CsclAppointmentTimeSlotsLocalServiceUtil" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link href="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.css" rel="stylesheet"/>
<link href="https://code.jquery.com/ui/1.12.1/themes/pepper-grinder/jquery-ui.css" rel="stylesheet"/>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script src="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.js"></script>
<script type="text/javascript"  src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
    </script> 
    <script type="text/javascript"
     src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
    </script>
    <link rel="stylesheet" type="text/css" media="screen" href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">


<%
List<CsclAppointeeMaster> appointees =CsclAppointeeMasterLocalServiceUtil.getCsclAppointeeMasters(0, CsclAppointeeMasterLocalServiceUtil.getCsclAppointeeMastersCount());
List<CsclAppointmentTimeSlots> TimeSlot =CsclAppointmentTimeSlotsLocalServiceUtil.getCsclAppointmentTimeSlotses(0,CsclAppointmentTimeSlotsLocalServiceUtil.getCsclAppointmentTimeSlotsesCount());

		/* //List<CsclAppointeeMaster> appointees = new ArrayList<CsclAppointeeMaster>();
//List<CsclAppointeeMaster> appointees =CsclAppointeeMasterLocalServiceUtil.findAll(); */

%>

<liferay-portlet:actionURL var="AdminActionURL" name="AddEntryAction">
	<portlet:param name="mvcPath" value="/appointmentAdmin/appointee_entry.jsp" />
</liferay-portlet:actionURL>

<liferay-portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/appointmentAdmin/appointee_entry.jsp"></portlet:param>
</liferay-portlet:renderURL>
	
<div style="margin-left: 28%;margin-right: 28%;">
<aui:form cssClass="contact-form" action="${AdminActionURL}" method="post" name="masterForm" >
	<aui:fieldset>
		<aui:col cssClass="lfr-api-navigation" width="<%=400%>">
	
			<aui-label>Appointment With </aui-label>
	
	<aui:select name="appointee" label="" required="true">
			<aui:option value="" >Select Appointee</aui:option>
				<%for(CsclAppointeeMaster appointee : appointees){%>
					<aui:option value="<%=appointee.getId_()%>" ><%=appointee.getName() %> (<%=appointee.getDesignation() %>)</aui:option>
				<%}%>
				<aui:validator name="required" ></aui:validator>
			</aui:select>	
		
	<!-- <div class="row">
		<div class="input-group date form-group" id="datepicker">
    		<input type="text"  class="form-control" id="Dates" name="Dates" placeholder="Select days" required />
   			<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i><span class="count"></span></span>
		</div>
	</div>  --> 
	<div style="margin-top: 20px;">
		<aui-label>Select Date</aui-label>
<%-- 				<input id="mdp-demo" name="<portlet:namespace />Dates" placeholder="Date" autocomplete="off" />	
 --%>	
 <div id="datetimepicker4" class="input-append" required="true">
    <input name="<portlet:namespace />AvailableDate" data-format="yyyy-MM-dd" type="text"></input>
    <span class="add-on">
      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
      </i>
    </span>
  </div>
 
 </div>
	<%-- <div style="margin-top: 43px;">
	<aui-label>Select TimeSlot</aui-label>
		<input class="form-control timetrigger" id="<portlet:namespace />starttime" type="text" id="timepicker" name="<portlet:namespace/>starttime" required="true" placeholder="From">
 		<input class="form-control timetrigger" id="<portlet:namespace />endtime" type="text" id="timepicker" name="<portlet:namespace/>endtime" required="true" placeholder="to">	
	</div> --%>
	
	 <div id="Time-Slot" style="width: 168px;">
        <div class="lfr-form-row lfr-form-row-inline">
            <div class="row-fields">
                <!--
                    Notice the zero at the end of the name & id of the input element "phoneNumber0".
                    When you add dynamic fields this would be incremented.
                -->
                <aui-label>Select Time</aui-label>
            
 			<aui:select id="starttime0" name="starttime0" label="" placeholder="From">
				<aui:option value="" >Select Time</aui:option>
				<%for(CsclAppointmentTimeSlots TimeSlots : TimeSlot){%>
					<aui:option value="<%=TimeSlots.getTimeslot()%>" ><%=TimeSlots.getTimeslot()%></aui:option>
				<%}%>
			</aui:select>
				
			<aui:select id="endtime0" name="endtime0" label="" placeholder="To">
				<aui:option value="" >Select Time</aui:option>
				<%for(CsclAppointmentTimeSlots TimeSlots : TimeSlot){%>
					<aui:option value="<%=TimeSlots.getTimeslot()%>" ><%=TimeSlots.getTimeslot()%></aui:option>
				<%}%>
			</aui:select> 
		                           
            </div>
        </div>
    </div>
</div>
                

</aui:col>
	<aui:button style="margin-top: 50px;margin-left: 33px;" type="submit" name="Raise ticket" value="Submit"></aui:button>
	<aui:button style="margin-top: 50px;margin-left: 38px;" type="Cancel" value="cancel" onClick="${viewURL.toString()}"></aui:button>

	</aui:fieldset>

</aui:form>
 </div>
	
<aui:script use="liferay-auto-fields">
new Liferay.AutoFields(
    {
        contentBox: '#Time-Slot', // this is the container within which the fields would be added dynamically
        fieldIndexes: '<portlet:namespace />phonesIndexes' // this is the field which will store the values of the 
    }
).render();
</aui:script>
 
 <script>
$(function(){
$('input[name="Dates"]').change(function(){
	$(this).val();
	console.log($(this).val());
});
});
</script>
 
 <script>
 $(document).ready(function() {
		
		if(document.URL.indexOf("#")==-1){
	        // Set the URL to whatever it was plus "#".
	        url = document.URL+"#";
	        location = "#";

	        //Reload the page
	        location.reload(true);
	    }
  $(function() {
    $('#datetimepicker4').datetimepicker({
      pickTime: false
    });
  });
});
</script>
 
<aui:script>
YUI().use('aui-timepicker',function(Y) {
	new Y.TimePicker(
		      {
       trigger: '#<portlet:namespace/>Time-Slot',
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

<!-- <script>
$(".add-more").click(function(){
    var html = $(".copy").html();
    $(".after-add-more").after(html);
});
$("body").on("click",".remove",function(){ 
    $(this).parents(".control-group").remove();
});
</script> -->
