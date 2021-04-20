package com.cscl.appointment.booking.admin.portlet.action;


import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import cscl.appointment.booking.model.CsclAppointeeMaster;
import java.util.Date;
import cscl.appointment.booking.service.CsclApproverMappingLocalServiceUtil;
import cscl.appointment.booking.model.CsclApproverMapping;
import cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import javax.portlet.PortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.ActionResponse;
import javax.portlet.ActionRequest;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;

@Component(property = { "javax.portlet.name=com_cscl_appointment_booking_admin_CsclAppointmentBookingAdminPortlet", "mvc.command.name=/appointmentAdmin/add_approver" }, service = { MVCActionCommand.class })
public class AddApproverMVCActionCommand extends BaseMVCActionCommand
{
    protected void doProcessAction(final ActionRequest actionRequest, final ActionResponse actionResponse) throws Exception {
        boolean isAllowed = false;
        final String name = ParamUtil.getString((PortletRequest)actionRequest, "name");
        final String designation = ParamUtil.getString((PortletRequest)actionRequest, "designation");
        final String approverId = ParamUtil.getString((PortletRequest)actionRequest, "approver");
        final long appointeeId = ParamUtil.getLong((PortletRequest)actionRequest, "appointeeId");
        final String redirect = ParamUtil.getString((PortletRequest)actionRequest, "redirect");
        String userName = "";
        if (Validator.isNotNull(name) && Validator.isNotNull(designation) && Validator.isNotNull(approverId)) {
            isAllowed = true;
        }
        System.out.println("Appointee Id.." + appointeeId);
        System.out.println("AapproverId.." + approverId);
        System.out.println("IisAllowed.." + isAllowed);
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
                if (Validator.isNotNull(Long.valueOf(appointeeId))) {
                    System.out.println("Edit..");
                    final CsclAppointeeMaster appointee = CsclAppointeeMasterLocalServiceUtil.getCsclAppointeeMaster(appointeeId);
                    appointee.setName(name);
                    appointee.setDesignation(designation);
                    appointee.setIsActive(Boolean.valueOf(true));
                    CsclAppointeeMasterLocalServiceUtil.updateCsclAppointeeMaster(appointee);
                    System.out.println("Appointee Edited successfully");
                    final CsclApproverMapping approverVal = CsclApproverMappingLocalServiceUtil.findByAppointeeId((int)appointeeId).get(0);
                    approverVal.setAppointee((int)appointeeId);
                    approverVal.setModifiedDate(new Date());
                    approverVal.setApprover(userName);
                    approverVal.setAssignedTo((long)Long.valueOf(approverId));
                    CsclApproverMappingLocalServiceUtil.updateCsclApproverMapping(approverVal);
                }
                else {
                    System.out.println("Add..");
                    final long id = CounterLocalServiceUtil.increment(CsclAppointeeMaster.class.getName());
                    System.out.println("Edit.id....." + id);
                    final CsclAppointeeMaster appointee2 = CsclAppointeeMasterLocalServiceUtil.createCsclAppointeeMaster(id);
                    System.out.println("Edit..Appointee");
                    appointee2.setName(name);
                    appointee2.setDesignation(designation);
                    appointee2.setIsActive(Boolean.valueOf(true));
                    CsclAppointeeMasterLocalServiceUtil.addCsclAppointeeMaster(appointee2);
                    System.out.println("Appointee added successfully");
                    final long id_ = CounterLocalServiceUtil.increment(CsclApproverMapping.class.getName());
                    System.out.println("Edit.id_....." + id_);
                    final CsclApproverMapping approver = CsclApproverMappingLocalServiceUtil.createCsclApproverMapping(id_);
                    System.out.println("Edit.Approver.....");
                    approver.setAppointee((int)id);
                    approver.setCreatedDate(new Date());
                    approver.setApprover(userName);
                    approver.setAssignedTo((long)Long.valueOf(approverId));
                    CsclApproverMappingLocalServiceUtil.addCsclApproverMapping(approver);
                }
                System.out.println("Approver mapped successfully");
                actionRequest.setAttribute("isSubmitted", (Object)true);
                actionRequest.setAttribute("redirect", (Object)redirect);
                SessionMessages.add((PortletRequest)actionRequest, "success-add-approver");
                actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/add_approver.jsp");
            }
            catch (Exception e) {
                e.getMessage();
                SessionErrors.add((PortletRequest)actionRequest, (Class)e.getClass());
                actionRequest.setAttribute("redirect", (Object)redirect);
                actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/add_approver.jsp");
            }
            return;
        }
        SessionErrors.add((PortletRequest)actionRequest, "Failed : Adding approver");
        actionRequest.setAttribute("redirect", (Object)redirect);
    }
}
