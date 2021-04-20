package cscl.appointment.admin.form.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(property = { "javax.portlet.name=com_cscl_appointment_admin_form_CsclAppointmentAdminFormPortlet", "mvc.command.name=/sample" }, service = { MVCActionCommand.class })

public class AddEntry extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		System.out.println("inside AddEntry Java function");
		
	}

}
