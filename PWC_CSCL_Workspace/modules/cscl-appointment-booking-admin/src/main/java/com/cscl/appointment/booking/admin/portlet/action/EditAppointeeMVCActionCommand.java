package com.cscl.appointment.booking.admin.portlet.action;

import com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import cscl.appointment.booking.model.CsclApproverMapping;
import cscl.appointment.booking.service.CsclApproverMappingLocalServiceUtil;

@Component(
		property = {
			"javax.portlet.name=" + CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN,
			"mvc.command.name=/appointmentAdmin/editAppointee"
		},
		service = MVCActionCommand.class
	)

public class EditAppointeeMVCActionCommand extends BaseMVCActionCommand{
    protected void doProcessAction(final ActionRequest actionRequest, final ActionResponse actionResponse) throws Exception {
        boolean isAllowed = false;
        final long appointeeId = ParamUtil.getLong((PortletRequest)actionRequest, "appointeeId");
        final String approverId = ParamUtil.getString((PortletRequest)actionRequest, "approver");
        final String redirect = ParamUtil.getString((PortletRequest)actionRequest, "redirect");
        String userName = "";
        if (Validator.isNotNull(Long.valueOf(appointeeId)) && Validator.isNotNull(approverId)) {
            isAllowed = true;
        }
        try {
            final User user = UserLocalServiceUtil.getUser((long)Long.valueOf(approverId));
            if (Validator.isNotNull((Object)user)) {
                userName = user.getFullName();
            }
        }
        catch (Exception e) {
            System.err.println("Error : While getting user Id..");
        }
        if (isAllowed) {
            try {
                final CsclApproverMapping approver = CsclApproverMappingLocalServiceUtil.findByAppointeeId((int)appointeeId).get(0);
                approver.setApprover(userName);
                approver.setAssignedTo((long)Long.valueOf(approverId));
                approver.setCreatedDate(new Date());
                CsclApproverMappingLocalServiceUtil.updateCsclApproverMapping(approver);
                System.out.println("Approver updated successfully");
                actionRequest.setAttribute("isSubmitted", (Object)true);
                actionRequest.setAttribute("redirect", (Object)redirect);
                SessionMessages.add((PortletRequest)actionRequest, "success-add-approver");
                actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/manage_appointee_mapper.jsp");
            }
            catch (Exception e) {
                e.getMessage();
                SessionErrors.add((PortletRequest)actionRequest, (Class)e.getClass());
                actionRequest.setAttribute("redirect", (Object)redirect);
                actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/manage_appointee_mapper.jsp");
            }
        }
        else {
            SessionErrors.add((PortletRequest)actionRequest, "Failed : Adding approver");
            actionRequest.setAttribute("redirect", (Object)redirect);
            actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/manage_appointee_mapper.jsp");
        }
    }
}
