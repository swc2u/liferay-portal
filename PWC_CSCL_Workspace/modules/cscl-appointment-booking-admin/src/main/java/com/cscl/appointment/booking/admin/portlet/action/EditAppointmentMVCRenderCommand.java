package com.cscl.appointment.booking.admin.portlet.action;

import com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		property = {
			"javax.portlet.name=" + CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN,
			"mvc.command.name=/appointmentAdmin/edit_appointment"
		},
		service = MVCRenderCommand.class
	)

public class EditAppointmentMVCRenderCommand implements MVCRenderCommand{

    public String render(final RenderRequest renderRequest, final RenderResponse renderResponse) throws PortletException {
        try {
            ActionUtil.getAppointment((PortletRequest)renderRequest);
        }
        catch (Exception e) {
            if (e instanceof PrincipalException) {
                SessionErrors.add((PortletRequest)renderRequest, (Class)e.getClass());
                return "/appointmentAdmin/tabs_page.jsp";
            }
            throw new PortletException((Throwable)e);
        }
        return "/appointmentAdmin/edit_appointment.jsp";
    }
}
