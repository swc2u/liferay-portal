package cscl.appointment.admin.form.portlet;

import cscl.appointment.admin.form.constants.CsclAppointmentAdminFormPortletKeys;
import cscl.appointment.admin.table.model.csclAppointmentAdmin;
import cscl.appointment.admin.table.service.csclAppointmentAdminLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import cscl.appointment.booking.model.CsclAppointeeMaster;
import cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil;
/**
 * @author Admin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CsclAppointmentAdminForm",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CsclAppointmentAdminFormPortletKeys.CSCLAPPOINTMENTADMINFORM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CsclAppointmentAdminFormPortlet extends MVCPortlet {
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
			String availabledate=ParamUtil.getString(request, "Dates");
			System.out.println("Available date"+availabledate);
			String from_Time=ParamUtil.getString(request, "starttime");
			System.out.println("from_Time"+from_Time);
			String to_time = ParamUtil.getString(request, "endtime");
			System.out.println("to_time"+to_time);

			long ID=CounterLocalServiceUtil.increment();
			System.out.println("ID-----------"+ID);

			
			try {
			//AdminModule csclobject=AdminModuleLocalServiceUtil.createAdminModule(Id);
			csclAppointmentAdmin csclAppointmentAdmin=csclAppointmentAdminLocalServiceUtil.createcsclAppointmentAdmin(ID);
			csclAppointmentAdmin.setID(ID);
			csclAppointmentAdmin.setAppointee(appointee);
			csclAppointmentAdmin.setAppointeeId(AppointeeID);
			csclAppointmentAdmin.setAppointedDate(availabledate);
			csclAppointmentAdmin.setFromTime(from_Time);
			csclAppointmentAdmin.setToTime(to_time);
			System.out.println("csclAppointmentAdmin:-"+csclAppointmentAdmin);
			csclAppointmentAdmin addobject=csclAppointmentAdminLocalServiceUtil.addcsclAppointmentAdmin(csclAppointmentAdmin);
			response.setRenderParameter("jspPage","/view.jsp");
			}
			catch(Exception e)
			{
				System.out.println("Entry for this appointee is already present, kindly update the same");
				SessionErrors.add(request, "duplicateEntry-errorMessage");
				SessionMessages.add(request,PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				System.out.println(" in exception ="+e); 
				e.printStackTrace();
			}
			response.setRenderParameter("jspPage", "/view.jsp");
	}
	

	@ProcessAction(name = "updateUser")
    public void updateStudent(ActionRequest actionRequest,  ActionResponse actionResponse) {
       
		long AppointeeID=ParamUtil.getLong(actionRequest, "AppointeeID");
		String Appointee=ParamUtil.getString(actionRequest, "Appointee");
		String availabledate=ParamUtil.getString(actionRequest, "Dates");
		String from_Time=ParamUtil.getString(actionRequest, "starttime");
		String to_time = ParamUtil.getString(actionRequest, "endtime");

		long ID=ParamUtil.getLong(actionRequest, "ID");
		System.out.println("ID-----------"+ID);
		
		System.out.println("AppointeeID"+AppointeeID);
		System.out.println("appointee"+Appointee);
		System.out.println("availabledate"+availabledate);
		System.out.println("from_Time"+from_Time);
		
		csclAppointmentAdmin csclAppointmentAdmin=null;
		//AdminModule AdminModule = null;
        try {
        	csclAppointmentAdmin=csclAppointmentAdminLocalServiceUtil.getcsclAppointmentAdmin(ID);
        	//AdminModule = AdminModuleLocalServiceUtil.getAdminModule(Id);
        } catch (Exception e) {
            System.out.println("Exception"+e);
        }
 
        if(Validator.isNotNull(csclAppointmentAdmin)) {
        	csclAppointmentAdmin.setAppointedDate(availabledate);
        	csclAppointmentAdmin.setFromTime(from_Time);
        	csclAppointmentAdmin.setToTime(to_time);
           
        	csclAppointmentAdminLocalServiceUtil.updatecsclAppointmentAdmin(csclAppointmentAdmin);
        	//AdminModuleLocalServiceUtil.updateAdminModule(AdminModule);
        	 SessionMessages.add(actionRequest, "success");
			actionResponse.setRenderParameter("jspPage", "/view.jsp");

        }
    }
	
	@ProcessAction(name = "deleteUser")
    public void deleteStudent(ActionRequest actionRequest, ActionResponse actionResponse){
		long Id=ParamUtil.getLong(actionRequest, "Appointee");
System.out.println("ID to be delete:-"+Id);
		//String Appointee=ParamUtil.getString(actionRequest, "Appointee");
        try {
        	csclAppointmentAdminLocalServiceUtil.deletecsclAppointmentAdmin(Id);
        	//AdminModuleLocalServiceUtil.deleteAdminModule(Id);
			SessionErrors.add(actionRequest, "DeleteMessage");

        } catch (Exception e) {
            System.out.println("Exception"+e);
        }
    }
	
}