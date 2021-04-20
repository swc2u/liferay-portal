package com.cscl.online.rti.payment.admin.portlet.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.cscl.online.rti.payment.admin.constants.CsclOnlineRtiPaymentAdminPortletKeys;
import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;
import com.cscl.online.rti.payment.service.CsclRtiPaymentDetailsLocalServiceUtil;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;


@Component(
		property = {
			"javax.portlet.name=" +  CsclOnlineRtiPaymentAdminPortletKeys.CSCLONLINERTIPAYMENTADMIN,
			"mvc.command.name=/rtiAdmin/report"
		},
		service = MVCResourceCommand.class
	)

public class ReportingRtiMVCResourceCommand implements MVCResourceCommand {

	public static String[] columnNames = { "Reference Id","Applicant Name", "Applicant Mobile", "Applicant Email","Address", "RTI Subject", "Created Date"};
	public static final String CSV_SEPARATOR = ",";
	
	
	@Override
	public boolean serveResource(ResourceRequest request, ResourceResponse response)
			throws PortletException {
		SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");  
		
		String fromDate = ParamUtil.getString(request, "fromDate");
		String toDate =  ParamUtil.getString(request, "toDate");
		  System.out.println("toDate...."+toDate+"fromDate..."+fromDate);
		
		/* paymentList
		 * Date fromDate1 = ParamUtil.getDate(request, "fromDate", formatter1); Date
		 * toDate1 = ParamUtil.getDate(request, "toDate", formatter1);
		 * System.out.println("toDate...."+toDate1+"fromDate..."+fromDate1);
		 */
		/*
		 * String fromDate = fromDate1; String toDate = toDate1; try { fromDate =
		 * formatter1.format(fromDate1); toDate = formatter1.format(toDate1);
		 * }catch(Exception e) { System.err.println("Error : While Converting date "); }
		 */
		
		List<CsclRtiPaymentDetails> rtiList = new ArrayList<CsclRtiPaymentDetails>();
		
		if(Validator.isNotNull(fromDate) || Validator.isNotNull(toDate)) {
			//System.out.println("toDate...."+toDate+"fromDate..."+fromDate);
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM cscl_rti_payment WHERE DATE(createdDate) BETWEEN '"+fromDate+"' AND '"+toDate+"' ");
			try{
				rtiList = executeQuery(sql.toString());
//		CsclRtiPaymentDetailsLocalServiceUtil.getCsclRtiPaymentDetailses(0, CsclRtiPaymentDetailsLocalServiceUtil.getCsclRtiPaymentDetailsesCount());
			}catch(Exception e){
				System.err.println("Error: While getting approvers..");
			}
		}else {
			rtiList = CsclRtiPaymentDetailsLocalServiceUtil.getCsclRtiPaymentDetailses(0, CsclRtiPaymentDetailsLocalServiceUtil.getCsclRtiPaymentDetailsesCount());
		}
		
		StringBundler sb = new StringBundler();
		for (String columnName : columnNames) {
			sb.append(getCSVFormattedValue(columnName));
			sb.append(CSV_SEPARATOR);
		}
		sb.setIndex(sb.index() - 1);
		sb.append(CharPool.NEW_LINE);
		if(Validator.isNotNull(rtiList)) {
			for (CsclRtiPaymentDetails item : rtiList) {
				sb.append(getCSVFormattedValue(String.valueOf(item.getRefId())));
				sb.append(CSV_SEPARATOR);
				sb.append(getCSVFormattedValue(String.valueOf(item.getApplicantName())));
				sb.append(CSV_SEPARATOR);
				sb.append(getCSVFormattedValue(String.valueOf(item.getApplicantMobile())));
				sb.append(CSV_SEPARATOR);
				sb.append(getCSVFormattedValue(String.valueOf(item.getApplicantEmail())));
				sb.append(CSV_SEPARATOR);
				sb.append(getCSVFormattedValue(String.valueOf(item.getAddress())));
				sb.append(CSV_SEPARATOR);
				sb.append(getCSVFormattedValue(String.valueOf(item.getRtiSubject())));
				sb.append(CSV_SEPARATOR);
				sb.append(getCSVFormattedDate(item.getCreatedDate()));
				sb.append(CSV_SEPARATOR);
				sb.setIndex(sb.index() - 1);
				sb.append(CharPool.NEW_LINE);
			}
		}
	    Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    String strDate = formatter.format(date);  
	    
		String fileName = strDate+"_RTI_Payments.csv";
		byte[] bytes = sb.toString().getBytes();
		String contentType = ContentTypes.APPLICATION_TEXT;
		try {
			PortletResponseUtil.sendFile(request, response,	fileName, bytes, contentType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	protected String getCSVFormattedValue(String value) {
		StringBundler sb = new StringBundler(3);
		sb.append(CharPool.QUOTE);
		sb.append(StringUtil.replace(value, CharPool.QUOTE,
		StringPool.DOUBLE_QUOTE));
		sb.append(CharPool.QUOTE);
		return sb.toString();
	}
	
	protected String getCSVFormattedDate(Date preferedDate) {
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
	    String strDate = formatter.format(preferedDate);  
		return strDate;
	}
	
	public static List<CsclRtiPaymentDetails> executeQuery(String sql) {
		List<CsclRtiPaymentDetails> rtis = new ArrayList<CsclRtiPaymentDetails>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		long entryId = 0;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());	
			while (rs.next()) {
			  entryId = rs.getLong("id_");//GetterUtil.getLong(rs.getLong("entryId"));
			  CsclRtiPaymentDetails rti = null; 
			  try{ 
				  rti = CsclRtiPaymentDetailsLocalServiceUtil.getCsclRtiPaymentDetails(entryId);
				  rtis.add(rti); 
			  }catch(Exception e){
				  System.err.println("Error: While getting Pass w.r.t refId.."+e);
			  }
			}
			rs.close();
		}catch(Exception e){
		     e.printStackTrace();
		}
		return rtis;
	}
}
