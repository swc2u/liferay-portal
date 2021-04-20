package cscl.appointment.booking.web.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;

import cscl.appointment.admin.table.model.csclAppointmentAdmin;
import cscl.appointment.booking.model.CsclAppointmentMaster;
import cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil;
import cscl.appointment.booking.web.constants.CsclAppointmentBookingWebPortletKeys;

@Component(
		property = {
			"javax.portlet.name=" + CsclAppointmentBookingWebPortletKeys.CSCLAPPOINTMENTBOOKINGWEB,
			"mvc.command.name=/appointment/view"
		},
		service = MVCActionCommand.class
	)

public class BookAppointmentMVCActionCommand  extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		boolean isAllowed = false;
		
		String name = ParamUtil.getString(actionRequest, "name");
		String email = ParamUtil.getString(actionRequest, "email");
		String mobile = ParamUtil.getString(actionRequest, "mobile");
		String address = ParamUtil.getString(actionRequest, "address");
		int appointee = ParamUtil.getInteger(actionRequest, "Appointee");
		String userDate = ParamUtil.getString(actionRequest, "Dates");
		String preferedDateTime = ParamUtil.getString(actionRequest, "Time");
		String CompanyName=ParamUtil.getString(actionRequest, "Company");
		String preferedDate=userDate.replace('-', '/');
		System.out.println("********preferedDate**********"+preferedDate);
		String reason = ParamUtil.getString(actionRequest, "reason");
		
		if(Validator.isNotNull(name)) {
			if(Validator.isNotNull(email)) {
				if(Validator.isNotNull(mobile)) {
					if(Validator.isNotNull(address)) {
						if(Validator.isNotNull(appointee)) {
							if(Validator.isNotNull(preferedDate)) {
								if(Validator.isNotNull(reason)) {
									if(Validator.isNotNull(CompanyName)) {

									isAllowed = true;
									}
								}
							}
						}	
					}	
				}	
			}
		}
		Date dateAppointment = new Date();
		long approverId = 0;
		String refId = "";
		int status = 1;//Pending
		Date today = new Date();
		int year = 0;
		try {
			int total = CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMastersCount()+1;
			System.out.println("******total*****"+total);
			year=today.getYear();
			year += 1900;
			if(total > 99999) {
				refId = year+""+total;// if 5 digit exceeds
				System.out.println("****refId1***"+refId);
			}else {
				refId = year+""+String.format("%05d", total);// 5 digit sequestial number
				System.out.println("****refId2****"+refId);
			}
			
			dateAppointment=new SimpleDateFormat("MM/dd/yyyy").parse(preferedDate);//yyyy-MM-dd
			System.out.println("dateAppointment:-"+dateAppointment);
		}catch(Exception e) {
			dateAppointment = new Date();
			System.err.println("Error : While converting date"+e);
		}
		
				List<CsclAppointmentMaster> appointmentMaster=CsclAppointmentMasterLocalServiceUtil.findByappointeeAndDateAndSlot(name, email, appointee, dateAppointment, preferedDateTime);
			
				System.out.println(appointmentMaster);
				
				if(appointmentMaster.isEmpty()) {
					
					if(isAllowed) {
						//if(isCaptchaVerified) {
							
					System.out.println("appointee master is empty");
					try {
						long id = CounterLocalServiceUtil.increment(CsclAppointmentMaster.class.getName());
		  				PortletSession session=actionRequest.getPortletSession();
		  					
		  				session.setAttribute("id", id);
						//_csclPollsMaster.
						CsclAppointmentMaster appointment = CsclAppointmentMasterLocalServiceUtil.createCsclAppointmentMaster(id);
						appointment.setName(name);
						appointment.setEmail(email);
						appointment.setMobile(mobile);
						appointment.setCompany(CompanyName);
						appointment.setPreferedDate(dateAppointment);
						//appointment.setAppointedDate(preferedDate);
						//appointment.setAppointedTime(preferedDateTime);
						appointment.setPreferedTime(preferedDateTime);
						appointment.setAddress(address);
						appointment.setReason(reason);
						appointment.setAppointee(appointee);
						appointment.setApprover(approverId);
						appointment.setStatus(status);
						appointment.setRefId(refId);
						appointment.setCreatedDate(today);
						CsclAppointmentMasterLocalServiceUtil.addCsclAppointmentMaster(appointment);
						
						actionRequest.setAttribute("refId", refId);
						actionRequest.setAttribute("isResult", true);
						SessionMessages.add(actionRequest, "success-booking-appointment");
						
						
			           actionResponse.getRenderParameters().setValue("mvcPath", "/appointment/view.jsp");
					}catch(Exception e) {
						e.getMessage();
						System.err.println("Error Came while sending mail notification......");	
						SessionErrors.add(actionRequest, e.getClass());
						actionResponse.getRenderParameters().setValue("mvcPath", "/appointment/view.jsp");
					}	
				}
					else {
						//System.err.println(".......Failed Booking Appointment..............");
						SessionErrors.add(actionRequest, "Please provide all mandatory field values");
						actionResponse.getRenderParameters().setValue("mvcPath", "/appointment/view.jsp");
						return;
					    }
				}else {
					System.out.println("appointee master is not empty");
					SessionErrors.add(actionRequest, "Duplicate_entry");
					actionResponse.getRenderParameters().setValue("mvcPath", "/appointment/view.jsp");
				}
						
				
					}
		

			/*}else {
				System.out.println("Inside else...");
				actionRequest.setAttribute("isResult", false);
				actionResponse.setRenderParameter("mvcPath", "/appointment/view.jsp");
			}*/
		
		
		}
	


