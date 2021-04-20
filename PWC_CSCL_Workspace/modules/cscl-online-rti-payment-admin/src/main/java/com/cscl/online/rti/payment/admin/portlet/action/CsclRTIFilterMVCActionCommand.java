package com.cscl.online.rti.payment.admin.portlet.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.cscl.online.rti.payment.admin.constants.CsclOnlineRtiPaymentAdminPortletKeys;
import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;
import com.cscl.online.rti.payment.service.CsclRtiPaymentDetailsLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(property = { 
		"javax.portlet.name=" + CsclOnlineRtiPaymentAdminPortletKeys.CSCLONLINERTIPAYMENTADMIN,
		"mvc.command.name=/rti/view" 
		},
service = MVCActionCommand.class)

public class CsclRTIFilterMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String fromDate = ParamUtil.getString(actionRequest, "fromDate");
		String toDate = ParamUtil.getString(actionRequest, "toDate");
		
		Date fromDate1 = new Date();
		Date toDate1 = new Date();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM cscl_polls_master WHERE DATE(birthDate) BETWEEN '"+fromDate1+"' AND '"+toDate1+"' ");
		System.out.println(sql);
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
			  entryId = rs.getLong("entryId");//GetterUtil.getLong(rs.getLong("entryId"));
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
