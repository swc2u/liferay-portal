package com.cscl.appointment.booking.admin.portlet.action;

import com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/*import org.apache.poi.ss.appointmentmodel.IndexedColors;
import org.apache.poi.ss.appointmentmodel.Row;
import org.apache.poi.xssf.appointmentmodel.XSSFCellStyle;
import org.apache.poi.xssf.appointmentmodel.XSSFFont;
import org.apache.poi.xssf.appointmentmodel.XSSFSheet;
import org.apache.poi.xssf.appointmentmodel.XSSFWorkbook;*/

import org.osgi.service.component.annotations.Component;

import cscl.appointment.booking.model.CsclAppointmentMaster;
import cscl.appointment.booking.model.CsclApproverMapping;
import cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil;
import cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil;
import cscl.appointment.booking.service.CsclApproverMappingLocalServiceUtil;
import cscl.appointment.booking.service.CsclStatusLocalServiceUtil;

@Component(
		property = {
			"javax.portlet.name=" + CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN,
			"mvc.command.name=/appointmentAdmin/report"
		},
		service = MVCResourceCommand.class
	)

public class ReportingAppointmentMVCResourceCommand implements MVCResourceCommand {
    public static String[] columnNames;
    public static final String CSV_SEPARATOR = ",";
    
    public boolean serveResource(final ResourceRequest request, final ResourceResponse response) throws PortletException {
        final String userId = ParamUtil.getString((PortletRequest)request, "userId");
        final String appointmentStatus = ParamUtil.getString((PortletRequest)request, "status");
        List<CsclAppointmentMaster> appointmentList = new ArrayList<CsclAppointmentMaster>();
        List<CsclApproverMapping> approvers = new ArrayList<CsclApproverMapping>();
        final List<Integer> appointees = new ArrayList<Integer>();
        if (Validator.isNotNull(userId) && Validator.isNotNull(appointmentStatus)) {
            try {
                approvers = (List<CsclApproverMapping>)CsclApproverMappingLocalServiceUtil.findByassignedTo((long)Long.valueOf(userId));
                if (Validator.isNotNull((Object)approvers)) {
                    for (final CsclApproverMapping approver : approvers) {
                        appointees.add(approver.getAppointee());
                    }
                }
            }
            catch (Exception e2) {
                System.err.println("Error: While getting approvers..");
            }
            try {
                final int stats = Integer.parseInt(appointmentStatus);
                for (final int appointe : appointees) {
                    List<CsclAppointmentMaster> tempAppointmentList = new ArrayList<CsclAppointmentMaster>();
                    tempAppointmentList = (List<CsclAppointmentMaster>)CsclAppointmentMasterLocalServiceUtil.getAppointmentsWithStatus(appointe, stats);
                    appointmentList.addAll(tempAppointmentList);
                }
            }
            catch (Exception e2) {
                System.err.println("Error : While getting appointment List");
            }
        }
        else {
            appointmentList = (List<CsclAppointmentMaster>)CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMasters(0, CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMastersCount());
        }
        final StringBundler sb = new StringBundler();
        for (final String columnName : ReportingAppointmentMVCResourceCommand.columnNames) {
            sb.append(this.getCSVFormattedValue(columnName));
            sb.append(",");
        }
        sb.setIndex(sb.index() - 1);
        sb.append('\n');
        String status = "";
        String appointee = "";
        for (final CsclAppointmentMaster appointment : appointmentList) {
            try {
                status = CsclStatusLocalServiceUtil.getCsclStatus((long)appointment.getStatus()).getName();
                appointee = CsclAppointeeMasterLocalServiceUtil.getCsclAppointeeMaster((long)appointment.getAppointee()).getName();
            }
            catch (Exception e3) {
                System.err.println("Error : While getting status & appointee");
            }
            sb.append(this.getCSVFormattedValue(String.valueOf(appointment.getName())));
            sb.append(",");
            sb.append(this.getCSVFormattedValue(String.valueOf(appointment.getMobile())));
            sb.append(",");
            sb.append(this.getCSVFormattedValue(String.valueOf(appointment.getEmail())));
            sb.append(",");
            sb.append(this.getCSVFormattedValue(String.valueOf(appointment.getAddress())));
            sb.append(",");
            sb.append(this.getCSVFormattedValue(String.valueOf(appointment.getReason())));
            sb.append(",");
            sb.append(this.getCSVFormattedValue(status));
            sb.append(",");
            sb.append(this.getCSVFormattedValue(appointee));
            sb.append(",");
            sb.append(this.getCSVFormattedDate(appointment.getPreferedDate()));
            sb.append(",");
            sb.append(this.getCSVFormattedValue(String.valueOf(appointment.getPreferedTime())));
            sb.append(",");
            sb.setIndex(sb.index() - 1);
            sb.append('\n');
        }
        final Date date = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        final String strDate = formatter.format(date);
        final String fileName = strDate + "_" + status + "_Appointments.csv";
        final byte[] bytes = sb.toString().getBytes();
        final String contentType = "application/text";
        try {
            PortletResponseUtil.sendFile((PortletRequest)request, (MimeResponse)response, fileName, bytes, contentType);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    protected String getCSVFormattedValue(final String value) {
        final StringBundler sb = new StringBundler(3);
        sb.append('\"');
        sb.append(StringUtil.replace(value, '\"', "\"\""));
        sb.append('\"');
        return sb.toString();
    }
    
    protected String getCSVFormattedDate(final Date preferedDate) {
        final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        final String strDate = formatter.format(preferedDate);
        return strDate;
    }
    
    static {
        ReportingAppointmentMVCResourceCommand.columnNames = new String[] { "Name", "Mobile", "E-Mail", "Address", "Reason for Appointment", "Status", "Appointee", "Date", "Time" };
    }
}