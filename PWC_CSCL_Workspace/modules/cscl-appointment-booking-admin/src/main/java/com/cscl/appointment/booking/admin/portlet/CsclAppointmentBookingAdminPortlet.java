package com.cscl.appointment.booking.admin.portlet;

import com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import cscl.appointment.admin.table.model.csclAppointmentAdmin;
import cscl.appointment.admin.table.service.csclAppointmentAdminLocalServiceUtil;
import cscl.appointment.booking.model.CsclAppointeeMaster;
import cscl.appointment.booking.model.CsclAppointmentTimeSlots;
import cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil;
import cscl.appointment.booking.service.CsclAppointmentTimeSlotsLocalServiceUtil;

/**
 * @author arnabsahvst
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=cscl",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CsclAppointmentBookingAdmin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/appointmentAdmin/tabs_page.jsp",
		"javax.portlet.name=" + CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CsclAppointmentBookingAdminPortlet extends MVCPortlet {

	@SuppressWarnings("deprecation")
	@ProcessAction(name="AddEntryAction")
	public void createNewTicket(ActionRequest request,ActionResponse response) throws IOException,PortletException,NumberFormatException
	{	

			long AppointeeID=ParamUtil.getLong(request, "appointee");
			System.out.println("AppointeeID"+AppointeeID);
			
			List<CsclAppointeeMaster>  CsclAppointeeMaster=  CsclAppointeeMasterLocalServiceUtil.getByID(AppointeeID);
			System.out.println("AdminList:-"+CsclAppointeeMaster);
		//String Appointee=CsclAppointeeMaster;
			String appointee="";
			   for (CsclAppointeeMaster temp : CsclAppointeeMaster) 
		         {
				    appointee=temp.getName();
		         }
			   System.out.println("appointee"+appointee);
			   
			String availabledate=ParamUtil.getString(request, "AvailableDate");
			System.out.println("Available date"+availabledate);
			
			long ID=CounterLocalServiceUtil.increment();
			System.out.println("ID-----------"+ID);
			

	        	try {
					//AdminModule csclobject=AdminModuleLocalServiceUtil.createAdminModule(Id);
					csclAppointmentAdmin csclAppointmentAdmin=csclAppointmentAdminLocalServiceUtil.createcsclAppointmentAdmin(ID);
					
					csclAppointmentAdmin.setID(ID);
					csclAppointmentAdmin.setAppointee(appointee);
					csclAppointmentAdmin.setAppointeeId(AppointeeID);
					csclAppointmentAdmin.setAppointedDate(availabledate);

					
					String TimeIndexesString = request.getParameter("phonesIndexes"); // do you remember: fieldIndexes: '<portlet:namespace />phonesIndexes'? :-)
					int[] TimeSlotIndexes = StringUtil.split(TimeIndexesString, 0);
					System.out.println("TimeIndexesString"+TimeIndexesString);
					System.out.println("phonesIndexes"+TimeSlotIndexes);

					String number="";
					String endtime="";
					int count=0;
					for (int TimeSlotIndex : TimeSlotIndexes) {
						 number = ParamUtil.getString(request, "starttime" + TimeSlotIndex);
						 endtime = ParamUtil.getString(request, "endtime" + TimeSlotIndex);
						 String TimeSlot=number+"-"+endtime;
						 System.out.println("-------TimeSlot-----"+TimeSlot);
						 if(count==0)
						 {
							 System.out.println("count is 0 TimeSlot"+TimeSlot);
							 csclAppointmentAdmin.setFromTime(TimeSlot);
						 }
						 if(count==1)
						 {
							 System.out.println("count is 1 TimeSlot"+TimeSlot);
							 csclAppointmentAdmin.setSecondTimeSlot(TimeSlot);
						 }
						 if(count==2)
						 {
							 System.out.println("count is 2 TimeSlot"+TimeSlot);
							 csclAppointmentAdmin.setThirdTimeSlot(TimeSlot);
						 }
						 if(count==3)
						 {
							 System.out.println("count is 3 TimeSlot"+TimeSlot);
							 csclAppointmentAdmin.setFourthTimeSlot(TimeSlot);
						 }
						 if(count==4)
						 {
							 System.out.println("count is 4 TimeSlot"+TimeSlot);
							 csclAppointmentAdmin.setFifthTimeSlot(TimeSlot);
						 }
						 if(count==5)
						 {
							 System.out.println("count is 5 TimeSlot"+TimeSlot);
							 csclAppointmentAdmin.setSixthTimeSlot(TimeSlot);
						 }
						 if(count==6)
						 {
							 System.out.println("count is 6 TimeSlot"+TimeSlot);
							 csclAppointmentAdmin.setSeventhTimeSlot(TimeSlot);
						 }
						 count++;	
						 System.out.println("count"+count);
					}
					
					System.out.println("csclAppointmentAdmin:-"+csclAppointmentAdmin);
					csclAppointmentAdmin addobject=csclAppointmentAdminLocalServiceUtil.addcsclAppointmentAdmin(csclAppointmentAdmin);
					response.setRenderParameter("jspPage","/appointmentAdmin/appointee_entry.jsp");
					}
					catch(Exception e)
					{
						System.out.println("Entry for this appointee is already present, kindly update the same");
						SessionErrors.add(request, "duplicateEntry-errorMessage");
						SessionMessages.add(request,PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
						System.out.println(" in exception ="+e); 
						e.printStackTrace();
					}
					response.setRenderParameter("jspPage", "/appointmentAdmin/appointee_entry.jsp");

	        
	        
		}
	

	@ProcessAction(name = "updateUser")
    public void updateStudent(ActionRequest actionRequest,  ActionResponse actionResponse) {
       
		long AppointeeID=ParamUtil.getLong(actionRequest, "AppointeeID");
		long ID=ParamUtil.getLong(actionRequest, "ID");
		String Appointee=ParamUtil.getString(actionRequest, "Appointee");
		String availabledate=ParamUtil.getString(actionRequest, "AvailableDate");
		
		System.out.println("Inside Update Code");
		csclAppointmentAdmin csclAppointmentAdmin=null;
		//AdminModule AdminModule = null;
        try {
        	csclAppointmentAdmin=csclAppointmentAdminLocalServiceUtil.getcsclAppointmentAdmin(ID);
        	//AdminModule = AdminModuleLocalServiceUtil.getAdminModule(Id);
        	csclAppointmentAdmin.setAppointedDate(availabledate);
        	String TimeIndexesString = actionRequest.getParameter("phonesIndexes"); // do you remember: fieldIndexes: '<portlet:namespace />phonesIndexes'? :-)
			int[] TimeSlotIndexes = StringUtil.split(TimeIndexesString, 0);
			System.out.println("phonesIndexes"+TimeSlotIndexes);

			String number="";
			String endtime="";
			int count=0;
			for (int TimeSlotIndex : TimeSlotIndexes) {
				 number = ParamUtil.getString(actionRequest, "starttime" + TimeSlotIndex);
				 endtime = ParamUtil.getString(actionRequest, "endtime" + TimeSlotIndex);
				 String TimeSlot=number+"-"+endtime;
				 System.out.println("-------TimeSlot-----"+TimeSlot);
				 if(count==0)
				 {
					 System.out.println("count is 0 TimeSlot"+TimeSlot);
					 csclAppointmentAdmin.setFromTime(TimeSlot);
				 }
				 if(count==1)
				 {
					 System.out.println("count is 1 TimeSlot"+TimeSlot);
					 csclAppointmentAdmin.setSecondTimeSlot(TimeSlot);
				 }
				 if(count==2)
				 {
					 System.out.println("count is 2 TimeSlot"+TimeSlot);
					 csclAppointmentAdmin.setThirdTimeSlot(TimeSlot);
				 }
				 if(count==3)
				 {
					 System.out.println("count is 3 TimeSlot"+TimeSlot);
					 csclAppointmentAdmin.setFourthTimeSlot(TimeSlot);
				 }
				 if(count==4)
				 {
					 System.out.println("count is 4 TimeSlot"+TimeSlot);
					 csclAppointmentAdmin.setFifthTimeSlot(TimeSlot);
				 }
				 if(count==5)
				 {
					 System.out.println("count is 5 TimeSlot"+TimeSlot);
					 csclAppointmentAdmin.setSixthTimeSlot(TimeSlot);
				 }
				 if(count==6)
				 {
					 System.out.println("count is 6 TimeSlot"+TimeSlot);
					 csclAppointmentAdmin.setSeventhTimeSlot(TimeSlot);
				 }
				 count++;	
				 System.out.println("count"+count);
			}
        	
			System.out.println("TimeSlot Updated"+count);
        	csclAppointmentAdminLocalServiceUtil.updatecsclAppointmentAdmin(csclAppointmentAdmin);
       	    SessionMessages.add(actionRequest, "success");
			actionResponse.setRenderParameter("jspPage", "/appointmentAdmin/appointee_entry.jsp");

        } catch (Exception e) {
            System.out.println("Exception"+e);
        }     	            	
        
    }
	
	@ProcessAction(name = "deleteUser")
    public void deleteStudent(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		long Id=ParamUtil.getLong(actionRequest, "Appointee");
		System.out.println("ID to be delete:-"+Id);
		//String Appointee=ParamUtil.getString(actionRequest, "Appointee");
        try {
        	csclAppointmentAdminLocalServiceUtil.deletecsclAppointmentAdmin(Id);
        	//AdminModuleLocalServiceUtil.deleteAdminModule(Id);
			SessionErrors.add(actionRequest, "DeleteMessage");
			actionResponse.setRenderParameter("jspPage", "/appointmentAdmin/appointee_entry.jsp");

        } catch (Exception e) {
            System.out.println("Exception"+e);
        }
    }
}