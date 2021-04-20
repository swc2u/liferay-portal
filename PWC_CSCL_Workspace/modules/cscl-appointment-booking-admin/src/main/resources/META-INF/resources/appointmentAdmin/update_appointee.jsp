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
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="cscl.appointment.booking.model.CsclAppointeeMaster" %>
<%@page import="cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil" %>
<%@page import="cscl.appointment.booking.model.CsclAppointmentMaster" %>
<%@page import="cscl.appointment.admin.table.model.csclAppointmentAdmin" %>
<%@page import="cscl.appointment.admin.table.service.csclAppointmentAdminLocalServiceUtil" %>
<%@page import="com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys"%>
<%@page import="cscl.appointment.booking.model.CsclAppointmentTimeSlots" %>
<%@page import="cscl.appointment.booking.service.CsclAppointmentTimeSlotsLocalServiceUtil" %>
<portlet:defineObjects/>

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

<portlet:actionURL name="updateUser" var="updateUserActionURL"/>
 
 <liferay-portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/appointmentAdmin/appointee_entry.jsp"></portlet:param>
</liferay-portlet:renderURL>
 
<%-- <aui:form action="<%=updateUserActionURL%>" name="AppointeeForm" method="POST"/>
 --%> 
<%
long AppointeeID=ParamUtil.getLong(request, "Id");
String Id1=request.getParameter("Id");


List<csclAppointmentAdmin> appointee =csclAppointmentAdminLocalServiceUtil.getByID(AppointeeID);
List<CsclAppointmentTimeSlots> TimeSlot =CsclAppointmentTimeSlotsLocalServiceUtil.getCsclAppointmentTimeSlotses(0,CsclAppointmentTimeSlotsLocalServiceUtil.getCsclAppointmentTimeSlotsesCount());

//List<AdminModule> appointee =AdminModuleLocalServiceUtil.getByID(Id);

//List<CsclAppointeeMaster> appointee=CsclAppointeeMasterLocalServiceUtil.getId(Id);
System.out.println("appointee"+appointee);

String AppointeeName="";
String AppointeeDate="";
long ID=0;
for (csclAppointmentAdmin temp : appointee) 
{
	AppointeeName=temp.getAppointee();
	AppointeeDate=temp.getAppointedDate();
	ID=temp.getID();
}
System.out.println("AppointeeName"+AppointeeName);
System.out.println("AppointeeDate"+AppointeeDate);


//String token=AppointeeDate.toString();
	request.setAttribute("AppointeeDate", AppointeeDate);

String[] token = AppointeeDate.split(", ");

int i=0;
 for(i=0; i<token.length; i++){
	System.out.println("inside For"+token[i]);
	request.setAttribute("token[]", token[i]);
}
 System.out.println("i value"+i);

	request.setAttribute("i",i);

%>
</div>
<div style="margin-left: 28%;margin-right: 28%;">
<aui:form action="<%= updateUserActionURL %>" method="post" >
   
<aui:fieldset>
		<aui:col cssClass="lfr-api-navigation" width="<%=400%>">
	
 	 <aui:input label=" " name="ID" type="hidden" value="<%=ID%>" readonly="true" ></aui:input>
	<aui:input label=" " name="AppointeeID" type="hidden" value="<%=AppointeeID%>" readonly="true" ></aui:input>
 	
 	<aui-label>Appointee</aui-label>
 	<div style="margin-left:84px;margin-top:-29px;">
	<aui:input label=" " name="Appointee" type="text" value="<%=AppointeeName%>" readonly="true"></aui:input>
 	</div>
	<%-- <div style="margin-top: 20px;">
		<aui-label>Select Date</aui-label>
 			<div id="datetimepicker4" class="input-append" required="true">
    		    <input autocomplete="off" name="<portlet:namespace />AvailableDate" data-format="yyyy-MM-dd" type="text" value=<%=AppointeeDate%> readonly="true"></input>
  			</div>
 </div> 
	 --%>
 	
	<div style="margin-top: 43px;">
	<%-- <div id="Time-Slot">
        <div class="lfr-form-row lfr-form-row-inline">
            <div class="row-fields">
                <!--
                    Notice the zero at the end of the name & id of the input element "phoneNumber0".
                    When you add dynamic fields this would be incremented.
                -->
                <aui-label>Select Time</aui-label>
                
         <input class="form-control timetrigger" id="<portlet:namespace />starttime0" type="text" id="timepicker" name="<portlet:namespace/>starttime0" required="true" placeholder="From">
 		<input class="form-control timetrigger" id="<portlet:namespace />endtime0" type="text" id="timepicker" name="<portlet:namespace/>endtime0" required="true" placeholder="to">	
            
            </div>
        </div>
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
	<aui:button style="margin-top: 50px;margin-left: 33px;"  type="Submit" name="Update" value="Submit"></aui:button>
	<aui:button style="margin-top: 50px;margin-left: 38px;"  type="Cancel" value="cancel" onClick="${viewURL.toString()}"></aui:button>

	</aui:fieldset>
	</aui:form>
	
</div>
	
 <%-- <script>
$(document).ready(function() {
	 
	if(document.URL.indexOf("#")==-1){
        // Set the URL to whatever it was plus "#".
        url = document.URL+"#";
        location = "#";

        //Reload the page
        location.reload(true);
    }
	
	var arr=[];
	
	var temp="<%= request.getAttribute("AppointeeDate") %>";
	console.log("temp"+temp);
	var token = temp.split(", ");
	console.log("token- "+token);
	
	var s='';	
	var res = token.toString();
	var date = res.split("/");
	var temp1='';
	
    for(var i=1; i<date.length; i++)
     {
    	 console.log(date[i]);
         temp1 = date[i];
	   	 i=i+1;
    
    console.log(temp1);
     var date2 = new Date();
	$('#mdp-demo').multiDatesPicker ({
 	addDates: [date2.setDate(temp1)]
  	
	
		});
     }
});
  

 </script> --%>
 
 
  <script>
 $(document).ready(function() {
		
		if(document.URL.indexOf("#")==-1){
	        // Set the URL to whatever it was plus "#".
	        url = document.URL+"#";
	        location = "#";

	        //Reload the page
	        location.reload(true);
	    }
});
</script>

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