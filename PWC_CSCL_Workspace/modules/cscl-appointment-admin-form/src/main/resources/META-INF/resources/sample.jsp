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
<%@page import="cscl.appointment.admin.form.constants.CsclAppointmentAdminFormPortletKeys" %>
<%@page import="java.util.List"%>
<%@page import="cscl.appointment.booking.model.CsclAppointeeMaster" %>
<%@page import="cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil" %>
<%@page import="cscl.appointment.admin.form.constants.CsclAppointmentAdminFormPortletKeys" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link href="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.css" rel="stylesheet"/>
<link href="https://code.jquery.com/ui/1.12.1/themes/pepper-grinder/jquery-ui.css" rel="stylesheet"/>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script src="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.js"></script>

<%
List<CsclAppointeeMaster> appointees =CsclAppointeeMasterLocalServiceUtil.getCsclAppointeeMasters(0, CsclAppointeeMasterLocalServiceUtil.getCsclAppointeeMastersCount());

/* List<timeslot> timeslots=timeslotLocalServiceUtil.gettimeslots(0, timeslotLocalServiceUtil.gettimeslotsCount());

System.out.println("timeslots"+timeslots); */
		/* //List<CsclAppointeeMaster> appointees = new ArrayList<CsclAppointeeMaster>();
//List<CsclAppointeeMaster> appointees =CsclAppointeeMasterLocalServiceUtil.findAll(); */

%>

<liferay-portlet:actionURL var="AdminActionURL" name="AddEntryAction">
</liferay-portlet:actionURL>

<liferay-portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</liferay-portlet:renderURL>

<div style="margin-left: 28%;margin-right: 28%;">
<aui:form cssClass="contact-form" action="${AdminActionURL}" method="post" name="masterForm" >
	<aui:fieldset>
		<aui:col cssClass="lfr-api-navigation" width="<%=400%>">
	
			<aui-label>Appointment With </aui-label>
	
	<aui:select name="appointee" label="" required="true">
			<aui:option value="" >Select Appointee</aui:option>
				<%for(CsclAppointeeMaster appointee : appointees){ 
					System.out.println("appointee.getId_()"+appointee.getId_());
				%>
					<aui:option value="<%=appointee.getId_()%>" ><%=appointee.getName() %> (<%=appointee.getDesignation() %>)</aui:option>
				<% System.out.println("appointee.getId_()***"+appointee.getId_()); } %>
				<aui:validator name="required" ></aui:validator>
			</aui:select>	
		
	<!-- <div class="row">
		<div class="input-group date form-group" id="datepicker">
    		<input type="text"  class="form-control" id="Dates" name="Dates" placeholder="Select days" required />
   			<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i><span class="count"></span></span>
		</div>
	</div>  --> 
<div style="margin-top: 20px;">
		<aui-label>Select Date </aui-label>
		<input id="mdp-demo" name="<portlet:namespace />Dates" placeholder="Date" autocomplete="off" />	
	</div>
	<div style="margin-top: 43px;">
	<aui-label>Select Time </aui-label>
	
	<input class="form-control timetrigger" id="<portlet:namespace />starttime" type="text" id="timepicker" name="<portlet:namespace/>starttime" required="true" placeholder="From">
    <input class="form-control timetrigger" id="<portlet:namespace />endtime" type="text" id="timepicker" name="<portlet:namespace/>endtime" required="true" placeholder="to">
	</div>
</aui:col>
	<aui:button style="margin-top: 50px;margin-left: 33px;" type="submit" name="Raise ticket" value="Submit"></aui:button>
	<aui:button style="margin-top: 50px;margin-left: 38px;" type="Cancel" value="cancel" onClick="${viewURL.toString()}"></aui:button>

	</aui:fieldset>

</aui:form>
 </div>
 <script>
$(document).ready(function() {
	
	if(document.URL.indexOf("#")==-1){
        // Set the URL to whatever it was plus "#".
        url = document.URL+"#";
        location = "#";

        //Reload the page
        location.reload(true);
    }
	
	
	var arr=[];
$('#mdp-demo').multiDatesPicker({
	
	onSelect:function(datetext){
		if(arr.includes(datetext)){
			console.log("in if");
		}
		else{
			var date= document.getElementById('mdp-demo');
			var date1=date.value
			console.log(date1);
		}
	}
});
});

/* startDate: new Date(),
	        multidate: true,
	        format: "dd/mm/yyyy",
	        daysOfWeekHighlighted: "5,6",
	        datesDisabled: ['31/08/2017'],
	        language: 'en',
	        altField: '#Dates', */
	        
	    /* }).on('changeDate', function(e) {
	    	console.log("in change"+$(this).val());
	        $(this).find('.input-group-addon .count').innerHTML(' ' + e.dates.length);
	        var sd1 =$('#Dates').attr('value');
	 	   console.log(sd1); */
	    
	   
	  

 </script>
 
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



<%-- <%

List<AdminModule> users =AdminModuleLocalServiceUtil.getAdminModules(0,AdminModuleLocalServiceUtil.getAdminModulesCount());
System.out.println(users);
//List<AdminModule> users= (List<AdminModule>)request.getAttribute("users");
	request.setAttribute("users", users);
%>

<body>
<table id="appointee" class="table table-bordered table-striped">
    <thead>
      <tr>
 		<th>Appointee</th>
 		<th>Available Date</th>
 		<th>Available Time</th>
       </tr>
    </thead>
    	<tbody>
   		<c:forEach items="${users}" var="Object">  
        		<tr> 
           			 <td>${Object.getAppointee()}</td>
           			 <td>${Object.getAppointedDate()}</td>  
           			 <td>${Object.getFromTime()}</td>                                    
         		</tr>
    		</c:forEach>
    	</tbody>
	</table>
</body> --%>