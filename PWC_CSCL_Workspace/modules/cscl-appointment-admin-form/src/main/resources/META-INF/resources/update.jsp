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
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="cscl.appointment.booking.model.CsclAppointeeMaster" %>
<%@page import="cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil" %>
<%@page import="cscl.appointment.booking.model.CsclAppointmentMaster" %>
<%@page import="cscl.appointment.admin.table.model.csclAppointmentAdmin" %>
<%@page import="cscl.appointment.admin.table.service.csclAppointmentAdminLocalServiceUtil" %>

<portlet:defineObjects/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link href="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.css" rel="stylesheet"/>
<link href="https://code.jquery.com/ui/1.12.1/themes/pepper-grinder/jquery-ui.css" rel="stylesheet"/>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script src="https://cdn.rawgit.com/dubrox/Multiple-Dates-Picker-for-jQuery-UI/master/jquery-ui.multidatespicker.js"></script>


<portlet:actionURL name="updateUser" var="updateUserActionURL"/>
 
<%-- <aui:form action="<%=updateUserActionURL%>" name="AppointeeForm" method="POST"/>
 --%> 
<%
long AppointeeID=ParamUtil.getLong(request, "Id");
String Id1=request.getParameter("Id");


List<csclAppointmentAdmin> appointee =csclAppointmentAdminLocalServiceUtil.getByID(AppointeeID);

//List<AdminModule> appointee =AdminModuleLocalServiceUtil.getByID(Id);

//List<CsclAppointeeMaster> appointee=CsclAppointeeMasterLocalServiceUtil.getId(Id);
System.out.println("appointee"+appointee);

String AppointeeName="";
String from_Time="";
String to_Time="";
long ID=0;
for (csclAppointmentAdmin temp : appointee) 
{
	AppointeeName=temp.getAppointee();
	from_Time=temp.getFromTime();
	to_Time=temp.getToTime();
	ID=temp.getID();
}
System.out.println("AppointeeName"+AppointeeName);
System.out.println("ID"+ID);


%>
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
 	<div style="margin-top: 20px;">
		<aui-label>Select Date</aui-label>
		<input id="mdp-demo" name="<portlet:namespace />Dates" placeholder="Date" autocomplete="off" value="${appointee.getDates()}"/>
	</div>
	
	<div style="margin-top: 43px;">
	<aui-label>Select Time</aui-label>
	
	<input class="form-control timetrigger" id="<portlet:namespace />starttime" type="text" id="timepicker" name="<portlet:namespace/>starttime" required="true" value=<%=from_Time%>placeholder="From">
    <input class="form-control timetrigger" id="<portlet:namespace />endtime" type="text" id="timepicker" name="<portlet:namespace/>endtime" required="true" value=<%=to_Time%> placeholder="to">
	
    </div>
<%-- 		<input class="form-control timetrigger" id="<portlet:namespace />starttime" type="text" id="timepicker" name="<portlet:namespace/>starttime" required="true" placeholder="From">
 --%>		<%-- <input class="form-control timetrigger" id="<portlet:namespace />endtime" type="text" id="timepicker" name="<portlet:namespace/>endtime" required="true" placeholder="to"> --%>
</aui:col>
	<aui:button style="margin-top: 50px;margin-left: 33px;"  type="Submit" name="Update" value="Submit"></aui:button>
	<aui:button style="margin-top: 50px;margin-left: 38px;"  type="Cancel" value="cancel" onClick="${viewURL.toString()}"></aui:button>

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
	