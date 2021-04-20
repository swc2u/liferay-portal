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

<%
List<csclAppointmentAdmin> CsclAppointeeAdmin =csclAppointmentAdminLocalServiceUtil.findAll();

//List<AdminModule> CsclAppointeeAdmin=AdminModuleLocalServiceUtil.findAll();
System.out.println("CsclAppointeeAdmin"+CsclAppointeeAdmin);

CsclAppointmentMaster csclAppointmentMaster = (CsclAppointmentMaster)request.getAttribute(CsclAppointmentBookingWebPortletKeys.CSCLAPPOINTMENTBOOKINGWEB);
//Declarations
List<CsclAppointeeMaster> appointees = new ArrayList<CsclAppointeeMaster>();
//String name = "";
//String email = "";
String site_url = "";
String refId = "";
boolean isResult = false;
try{
	isResult = (boolean) renderRequest.getAttribute("isResult");
	refId = (String) renderRequest.getAttribute("refId");
}catch(Exception e){
	//System.err.println("Error came while getting values");
}

try{
	//name = themeDisplay.getUser().getFullName();
	//if(Validator.isNotNull(name)){
	//	email = themeDisplay.getUser().getEmailAddress();		
	//}
	site_url = themeDisplay.getPortalURL();
	site_url += "/web/guest/home"; 
}catch(Exception e1){
	//System.err.println("Error came while getting localities");
}
// Get Default VAlues
try{
	appointees = CsclAppointeeMasterLocalServiceUtil.getActiveAppointees();
}catch(Exception e1){
	//System.err.println("Error : While getting default values");
}
%>
<liferay-ui:error key="Duplicate_entry" message="Appointment already booked" />

<liferay-ui:success key="success-booking-appointment" message="You appointment booking request has been registered successfully with us" />
<liferay-ui:error key="text-verification-failed" message="Captcha verification has failed" />
<%-- <liferay-ui:error exception="<%= CaptchaTextException.class %>"  message="Captcha verification has failed" /> --%>
 
<liferay-portlet:actionURL name="/appointment/view" 
	refererPlid="<%=themeDisplay.getRefererPlid()%>" var="bookAppointmentURL">
	<portlet:param name="mvcPath" value="/appointment/view.jsp" />
	<%-- <portlet:param name="redirect" value="<%=currentUrl %>"/> --%>
</liferay-portlet:actionURL>
<portlet:resourceURL id="/appointment/captchaValidation" var="captchaValidationURL">
</portlet:resourceURL>

<portlet:resourceURL id="/appointment/dependentDropdown" var="getDataByEmployeeIDURL"></portlet:resourceURL>


<h2><liferay-ui:message key="book-appointment" /></h2>
<%if(isResult){ %>
	<div class="col-md-12">
		<h4 style="color: green;"><liferay-ui:message key="success-msg" />
		 : <%=refId %></h4>
	</div>
<%} %>
<div style="border: groove;padding-left: 15px;padding-right: 15px;padding-top: 15px;">
<aui:form cssClass="contact-form" action="<%=bookAppointmentURL%>" method="post"
 name="fm" onSubmit='<%="event.preventDefault(); " + renderResponse.getNamespace() + "checkCaptcha();"%>'>

<aui:model-context bean="<%=csclAppointmentMaster%>" model="<%=CsclAppointmentMaster.class%>" />
	<div class="row">
		<div class="col-md-6 name-field">
			<aui:input name="name" placeholder="name" label="name" value="" required="true">
				<aui:validator name="required" />
			</aui:input>
		</div>
		<div class="col-md-6 email-field">
			<aui:input name="email" placeholder="email" label="email" value="" required="true">
				 <aui:validator name="email"/>
				 <aui:validator name="required" />
			</aui:input>
		</div>
		
		<div class="col-md-6">
			<aui:input name="Company" type="text" placeholder="Name of the company" label="Name of the company" required="true">
				<aui:validator name="required" />
			</aui:input>
		</div>
		
		<div class="col-md-6">
			<aui:input name="mobile" placeholder="mobile" label="mobile" value="" required="true">
				<aui:validator name="rangeLength" errorMessage="valid-mobile">[10,10]</aui:validator>
				<aui:validator name="digits" ></aui:validator>
			</aui:input>
			</div>
		
		<%-- <div class="col-md-6">
			<aui:input label="preferedDate" name="preferedDate" required="true" placeholder="Prefered Date">
				<aui:validator name="required" />
			</aui:input>
		</div> --%>

		<div class="col-md-6" style="padding-top: 23px;">
			
		<div class="input-field" type="text">					
			<select id="continent" style="height: 29px;padding-left: 66px;padding-right: 40px;" class="SelectedAppointee" name="<portlet:namespace/>Appointee">
 			    <option value="none" selected="true">Select Appointee</option>
 			       <%if(Validator.isNotNull(CsclAppointeeAdmin)){
  						for(CsclAppointeeMaster con : appointees){%>
   							<option value="<%=con.getId_()%>"><%=con.getName()%> (<%=con.getDesignation() %>)</option>
 					<%}}%>
			</select>
		</div>
			
			 <div class="input-field"  name="<portlet:namespace/>Dates">
                        <select id="SelectedDate" style="height: 26px;margin-top: 15px;padding-left: 65px;padding-right: 65px;" class="UserSelectedDate" name="<portlet:namespace/>Dates">
                            <option value="none" selected="true">Select Date</option>
                            <option >Select Date</option> 
                        </select>
                    </div>
                    
                    <div class="input-field" class="UserSelectedTime" name="Time" >
                        <select id="SelectedTime" style="height: 26px;margin-top: 15px;padding-left: 65px;padding-right: 65px;" name="<portlet:namespace/>Time">
                            <option value="none" selected="true">Select Time</option>
                             <option>Select time</option>
                        </select>
                    </div>
		</div>
	
		<div class="col-md-6">
			<aui:input name="address" placeholder="Address" label="address" required="true">
				<aui:validator name="required" />
			</aui:input>
		</div>
		
		<div class="col-md-6" style="padding-top: 44px;">
			<aui:input name="reason" placeholder="reason-appo" label="reason-appo" required="true">
				<aui:validator name="required" />
			</aui:input>
		</div>
	</div>
	<%if(!isResult){ %>
		<div class="form-group">
			<div class="col-md-6">
				<portlet:resourceURL id="/appointment/captcha" var="captchaURL">
				</portlet:resourceURL>
				<liferay-captcha:captcha url="<%=captchaURL%>" />
			</div>
		</div>
	<%} %>
	<div class="col-md-6">
		<div class="alert alert-danger show" role="alert" id="captchaFailed" style="color:red;">
			<!-- <span class="alert-indicator">
				<svg class="lexicon-icon" focusable="false" role="presentation" viewBox="0 0 512 512">
					<path class="lexicon-icon-outline" d="M484.1,139.7c-54.4,62.6-167,190-203.8,233c-5.9,6.8-14.6,11.2-24.3,11.2c-8.8,0-16.8-3.6-22.6-9.4c-45.3-45.3-50.7-50.7-96-96c-5.8-5.8-9.4-13.8-9.4-22.6c0-17.7,14.3-32,32-32c8.8,0,16.8,3.6,22.6,9.4c35.6,35.6,46.6,46.6,71.6,71.6c47-54.8,150.9-171.7,192.5-219.7C399.8,32.9,331.8,0,256,0C114.6,0,0,114.6,0,256s114.6,256,256,256s256-114.6,256-256C512,214.1,501.9,174.6,484.1,139.7z"></path>
				</svg>
			</span> -->
			<strong class="lead"><liferay-ui:message key="failed" />:</strong><liferay-ui:message key="captcha-failed" />
		</div>
		<div class="alert alert-success show" role="alert" id="captchaSuccess" style="green;">
			<span class="alert-indicator">
				<svg class="lexicon-icon lexicon-icon-check-circle-full" focusable="false" role="presentation" viewBox="0 0 512 512">
					<path class="lexicon-icon-outline" d="M484.1,139.7c-54.4,62.6-167,190-203.8,233c-5.9,6.8-14.6,11.2-24.3,11.2c-8.8,0-16.8-3.6-22.6-9.4c-45.3-45.3-50.7-50.7-96-96c-5.8-5.8-9.4-13.8-9.4-22.6c0-17.7,14.3-32,32-32c8.8,0,16.8,3.6,22.6,9.4c35.6,35.6,46.6,46.6,71.6,71.6c47-54.8,150.9-171.7,192.5-219.7C399.8,32.9,331.8,0,256,0C114.6,0,0,114.6,0,256s114.6,256,256,256s256-114.6,256-256C512,214.1,501.9,174.6,484.1,139.7z"></path>
				</svg>
			</span>
			<strong class="lead"><liferay-ui:message key="success" />:</strong><liferay-ui:message key="captcha-success" />
		</div>
	</div>
	<%if(!isResult){ %>
		<div class="form-group">
			<aui:button type="submit" value="submit"/>
			<a href="<%= site_url%>"><aui:button type="button" value="back" style="color: #FFF;background-color: #0B5FFF;border-color: #0B5FFF;box-shadow: none;"/></a>
		</div>
	<%}else{ %>
		<div class="form-group">
		<a href="<%= site_url%>"><aui:button type="button" value="back" style="color: #FFF;background-color: #0B5FFF;border-color: #0B5FFF;box-shadow: none;"/></a>
	</div>
	<%} %>
</aui:form>
</div>
<style>
#captchaSuccess{
	display: none;
}
#captchaFailed{
	display: none;
}
</style>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <script type="text/javascript">
        
        var catUrl='${getDataByEmployeeIDURL}';
        console.log("catUrl " + catUrl);
        
        $(document).ready(function () {
        	
        	  $('.SelectedAppointee').change(function () {
        		  var countryId = $(this).val();
        		  let sid = countryId;
        		  console.log("Selected Date ID" +sid);
                  let data = {'<portlet:namespace/>operation':'SelectedDate','<portlet:namespace/>id': sid};
        			$.ajax({
        				type: 'GET',
        				url:catUrl,
        				 data: data,
        				
        				success: function(result) {
        					
        					 console.log("result for Date- "+result);
        					 
        				var token=result.split(",");
       					 console.log("token for Date- "+token);
           					var s='';
                             for(var i=0; i<token.length; i++){
                            	 console.log("token[i]"+token[i]);
                            	s+='<option value="' + token[i] + '">' + token[i] + '</option>'
                             	//s+='<option value="token[i]">' + token[i] + '</option>;
                            	console.log("selecte Date s"+s);
                             }
        				console.log("selecte Date s"+s);
        				
        				// $('#state').append('<option value="' + s + '">' + s + '</option>')
        					$('#SelectedDate').html(s);
        					
        				}
        		
        			});
        			
        			
        	  });
        	  
        	  $('.UserSelectedDate').change(function () {
        		  var stateid = $(this).val();
        		  let cid = stateid;
        		  console.log("Date ID for Time"+stateid);
        		  console.log("Date ID for Time cid"+cid);
                  let data = {'<portlet:namespace/>operation':'SelectedTime','<portlet:namespace/>id': cid};
        			$.ajax({
        				type: 'GET',
        				url:catUrl,
        				 data: data,
        				
        				success: function(result) {
        					 console.log("Selecte time result"+result);
             				
        					 var token=result.split(",");
             				console.log("Selected time token- "+token);
           					
             				var s='';
                             for(var i=0; i<token.length; i++){
                            	 console.log(token[i]);
                            	s+='<option value="' + token[i] + '">' + token[i] + '</option>'
                            	console.log("Selected Time s:-"+s);
                             }
             				console.log("Selected Time s:-"+s);

           					        				
        					$('#SelectedTime').html(s);
        				}
        			});
  		
  			});
        });
                
        </script>
 <aui:script>
	function <portlet:namespace />checkCaptcha() {
		var form = document.getElementById('<portlet:namespace />fm');
		var url="<%=captchaValidationURL.toString() %>";
	 	var captchaText=$("#<portlet:namespace />captchaText").val().trim();
		
		if (form) {
			jQuery.ajax({
			 type: "POST",
			 url:url,
			 async:false,
			 data : {'<portlet:namespace />captchaText':captchaText,},
			 success: function(msg){
			 	if(msg == 'true'){
			 		$("#captchaSuccess").css("display","block");
			 		$("#captchaFailed").css("display","none");
			 		form.submit();
			 	}else{
			 		$("#captchaSuccess").css("display","none");
			 		$("#captchaFailed").css("display","block");
			 	}
			 }
		}); 
			
		}
	}
</aui:script>