package com.cscl.appointment.booking.admin.portlet.action;

import com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys;
import com.cscl.appointment.booking.admin.portlet.util.RequestInfoUtil;
import com.cscl.appointment.booking.admin.portlet.util.SmsRequestUtil;
import com.cscl.appointment.booking.client.RestClient;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import cscl.appointment.booking.model.CsclAdminTimeSlots;
import cscl.appointment.booking.model.CsclAppointeeMaster;
import cscl.appointment.booking.model.CsclAppointmentMaster;
import cscl.appointment.booking.service.CsclAdminTimeSlotsLocalServiceUtil;
import cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil;
import cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil;
@Component(
		property = {
			"javax.portlet.name=" + CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN,
			"mvc.command.name=/appointmentAdmin/edit_appointment"
		},
		service = MVCActionCommand.class
	)

public class EditAppointmentMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		boolean isAllowed = false;
		System.out.println("Start of edit code");
		
		
//		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
//		User loggedUser = themeDisplay.getUser();
		
		String Name=ParamUtil.getString(actionRequest,"name");
		int status = ParamUtil.getInteger(actionRequest, "status");
		String comment = ParamUtil.getString(actionRequest, "comment");
		//String appointedDate = ParamUtil.getString(actionRequest, "preferedDate");
		//String appointedDateTime = ParamUtil.getString(actionRequest, "preferedTime");
		long appointmentId = ParamUtil.getLong(actionRequest, "appointmentId");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		String FromTime=ParamUtil.getString(actionRequest,"starttime");
		String ToTime=ParamUtil.getString(actionRequest,"endtime");
		String TimeSlot=FromTime+"-"+ToTime;
		System.out.println("status,comment,date,datetime,ID");
		System.out.println(status);
		System.out.println(comment);
		System.out.println(appointmentId);
		System.out.println("FromTime----------->"+FromTime);
		System.out.println("ToTime------------>"+ToTime);
		List<CsclAppointmentMaster> CsclAppointeeMaster=CsclAppointmentMasterLocalServiceUtil.findByid_(appointmentId);
		
		String Appointee="";
		String Time="";
		Date Date=null;
		String MailId="";
		String mobileNumber="";
		for (CsclAppointmentMaster temp : CsclAppointeeMaster) 
		{
			MailId=temp.getEmail();
			mobileNumber=temp.getMobile();
			Appointee=temp.getName();
			Time=temp.getPreferedTime();
			Date=temp.getPreferedDate();
		}
		
		System.out.println("Date"+Date);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String Appointmentdate = dateFormat.format(Date);
        System.out.println("Appointmentdate"+Appointmentdate);

		List<CsclAppointeeMaster> CsclMaster=CsclAppointeeMasterLocalServiceUtil.getByID(appointmentId);

		String AppointeeName="";
		for (CsclAppointeeMaster temp : CsclMaster) 
		{
			AppointeeName=temp.getName();			
		}
		
		if(Validator.isNotNull(status)) {
			if(Validator.isNotNull(comment)) {
						isAllowed = true;
					}
				}
		List<CsclAppointmentMaster> appointmentMaster=CsclAppointmentMasterLocalServiceUtil.findByTimeSlot(FromTime, ToTime);

		if(appointmentMaster.size()<10)
		{
		if(isAllowed) {
			try {
 
				System.out.println("appointmentMaster.size();"+appointmentMaster.size());
		
				CsclAppointmentMaster appointment = CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMaster(appointmentId);

				appointment.setComment(comment);
				appointment.setStatus(status);
				appointment.setModifiedDate(new Date());
				appointment.setFromTime(FromTime);
				appointment.setToTime(ToTime);
				CsclAppointmentMasterLocalServiceUtil.updateCsclAppointmentMaster(appointment);
				
				actionRequest.setAttribute("isResult", true);
				actionRequest.setAttribute("redirect", redirect);
				SessionMessages.add(actionRequest, "success-booking-appointment");
				
				try {
					String token = RestClient.generateAdminToken();
					System.out.println("........token.............."+token);
					
					 RequestInfoUtil requestInfo = new RequestInfoUtil();
					 requestInfo.setApiId("Rainmaker"); 
					 requestInfo.setVer(".01");
					 requestInfo.setTs(""); 
					 requestInfo.setAction("_send");
					 requestInfo.setDid("1");
					 requestInfo.setKey("");
					 requestInfo.setMsgId("20170310130900|en_IN");
					 requestInfo.setAuthToken(token);
					 
					JsonObject requestInfo1=new JsonObject();
					requestInfo1.addProperty("apiId","Rainmaker");
					requestInfo1.addProperty("ver",".01");
					requestInfo1.addProperty("action","_send");
					requestInfo1.addProperty("did","1");
					requestInfo1.addProperty("key","");
					requestInfo1.addProperty("msgid","20170310130900|en_IN");
					requestInfo1.addProperty("authToken",token);
				
					
					StringBuilder sb = new StringBuilder();
					sb.append("<div>Dear "+Appointee+",</div>");
					sb.append("<div>Your appointment has been confirmed on "+Date+".</div>");
					sb.append("<br/><div>For any additional information please contact</div>");
					sb.append("<br/>");
					sb.append("<br/><div>Thanks & Regards</div>");
					sb.append("<div>CSCL Team</div>");
					sb.append("<div>Chandigarh Smart City Limited</div>");
					
					System.out.println("SB.ToSTRING------>"+sb.toString());
					
					System.out.println("SMS Request");
					  
					 JsonObject smsRequest1=new JsonObject();
					 smsRequest1.addProperty("mobileNumber", mobileNumber);
					 smsRequest1.addProperty("message", sb.toString());

					 System.out.println("smsRequest object----->"+smsRequest1);
					 JsonObject jsnObj=new JsonObject();
					 jsnObj.add("RequestInfo", requestInfo1);
					 jsnObj.add("smsRequest", smsRequest1);

					 
					 String sms = RestClient.sendSms(jsnObj);
					  System.out.println("........sms.............."+sms);
					 
	
				
					JsonObject emailRequest1=new JsonObject();
					emailRequest1.addProperty("body", sb.toString());
					emailRequest1.addProperty("subject", "CSCL Team");
					emailRequest1.addProperty("email",MailId);

			       
					JsonObject jsonMailObj=new JsonObject();
					jsonMailObj.add("RequestInfo", requestInfo1);
					jsonMailObj.add("emailRequest", emailRequest1);
					
     				System.out.println("........jsonMailObj.............."+jsonMailObj);

					String eMail = RestClient.sendMail(jsonMailObj);
					System.out.println("........eMail.............."+eMail);
					
				}catch(Exception e) {
					e.getStackTrace();
				}
	            actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/tabs_page.jsp");
			}catch(Exception e) {
				e.getMessage();
				SessionErrors.add(actionRequest, e.getClass());
				actionRequest.setAttribute("redirect", redirect);
				actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/edit_appointment.jsp");
			}
		}else {
			SessionErrors.add(actionRequest, "Failed saving appointment");
			actionRequest.setAttribute("redirect", redirect);
			return;
			}
		}
		else
		{
			System.out.println("More Than 10 Appointment has been register for same time Slot");
			SessionErrors.add(actionRequest, "TimeSlot_error");
			actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/edit_appointment.jsp");
		}
		
	}
	

}
