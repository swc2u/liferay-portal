package com.cscl.online.rti.payment.admin.portlet.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.liferay.portal.kernel.util.Validator;

@Component(
		property = {
			"javax.portlet.name=" + CsclOnlineRtiPaymentAdminPortletKeys.CSCLONLINERTIPAYMENTADMIN,
			"mvc.command.name=/rtiAdmin/rti_search",
			"javax.portlet.init-param.add-process-action-success-action=false"
		},
		service = MVCActionCommand.class
	)
public class CsclRtiSearchFilterMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");  
		
		String fromDate = ParamUtil.getString(request, "fromDate");
		String toDate =  ParamUtil.getString(request, "toDate");
		System.out.println("toDate...."+toDate+"fromDate..."+fromDate);
		
		List<CsclRtiPaymentDetails> rtiList = new ArrayList<CsclRtiPaymentDetails>();
		if(Validator.isNotNull(fromDate) || Validator.isNotNull(toDate)) {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM cscl_rti_payment WHERE DATE(createdDate) BETWEEN '"+fromDate+"' AND '"+toDate+"' ");
			try{
				rtiList = executeQuery(sql.toString());
			}catch(Exception e){
				System.err.println("Error: While getting approvers..");
			}
		}else {
			rtiList = CsclRtiPaymentDetailsLocalServiceUtil.getCsclRtiPaymentDetailses(0, CsclRtiPaymentDetailsLocalServiceUtil.getCsclRtiPaymentDetailsesCount());
		}
		
		request.setAttribute("res", rtiList);
		request.setAttribute("fromDate", fromDate);
		request.setAttribute("toDate", toDate);
		request.setAttribute("isFilter", true);
		response.setRenderParameter("mvcPath", "/rtiAdmin/view.jsp");
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
