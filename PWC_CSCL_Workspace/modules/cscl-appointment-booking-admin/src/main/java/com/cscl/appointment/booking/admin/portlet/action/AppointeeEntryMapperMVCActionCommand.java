package com.cscl.appointment.booking.admin.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(property = { "javax.portlet.name=com_cscl_appointment_booking_admin_CsclAppointmentBookingAdminPortlet", "mvc.command.name=/appointmentAdmin/add_appointee_entry" }, service = { MVCActionCommand.class })

public class AppointeeEntryMapperMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Add appointee MVC Action ");
		
	}
}
