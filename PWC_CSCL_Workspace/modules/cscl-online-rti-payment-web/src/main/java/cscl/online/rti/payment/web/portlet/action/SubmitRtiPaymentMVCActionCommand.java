package cscl.online.rti.payment.web.portlet.action;

import java.util.Date;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;
import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;
import com.cscl.online.rti.payment.service.CsclRtiPaymentDetailsLocalServiceUtil;
import com.cscl.online.rti.payment.web.client.RestClient;
import com.cscl.online.rti.payment.web.constants.CsclOnlineRtiPaymentWebPortletKeys;
import com.cscl.online.rti.payment.web.util.EmailRequestUtil;
import com.cscl.online.rti.payment.web.util.RequestInfoUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(property = { "javax.portlet.name=" + CsclOnlineRtiPaymentWebPortletKeys.CSCLONLINERTIPAYMENTWEB,
"mvc.command.name=/rti/submit" }, service = MVCActionCommand.class)
public class SubmitRtiPaymentMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String name = ParamUtil.getString(actionRequest, "applicantName");
		String email = ParamUtil.getString(actionRequest, "applicantEmail");
		String mobile = ParamUtil.getString(actionRequest, "applicantMobile");
		String address = ParamUtil.getString(actionRequest, "address");
		int rtiFees = 0;//ParamUtil.getInteger(actionRequest, "rtiFeeAmount");
		String subject = ParamUtil.getString(actionRequest, "rtiSubject");
		String refId = ParamUtil.getString(actionRequest, "refId");
		long id = ParamUtil.getLong(actionRequest, "id");
		
		try {
			CsclRtiPaymentDetails rti = CsclRtiPaymentDetailsLocalServiceUtil.createCsclRtiPaymentDetails(id);
			rti.setApplicantName(name);
			rti.setApplicantEmail(email);
			rti.setApplicantMobile(mobile);
			rti.setAddress(address);
			rti.setRefId(refId);
			rti.setRtiSubject(subject);
			rti.setRtiFeeAmount(rtiFees);
			rti.setCreatedDate(new Date());
			
			CsclRtiPaymentDetailsLocalServiceUtil.addCsclRtiPaymentDetails(rti);
			/*try {
				String token = RestClient.generateAdminToken();
				System.out.println("........token.............."+token);
				RequestInfoUtil requestInfo = new RequestInfoUtil();
				requestInfo.setApiId("Rainmaker");
				requestInfo.setVer(".01");
				requestInfo.setTs("");
				requestInfo.setAction("_send");
				requestInfo.setDid("1");
				requestInfo.setKey("");
				requestInfo.setMsgId("20170310130900|en_IN");
				requestInfo.setAuthToken(token);
				
				StringBuilder sb = new StringBuilder();
				sb.append("<div>Dear "+name+",</div>");
				sb.append("<div>Your RTI request is saved with us. Please bring the document with you.</div>");
				sb.append("<br/><div>sdfgjdfhgjsdfjsdfjgdsjgvsdjgjdgjksgsjg jvs d fgjdgj </div>");
				sb.append("<div> sdjhgfjsg fsdf jjsrywweuwetruwetuirierwerweiuteuiw  ertyerityerterterterte </div>");
				sb.append("<br/>");
				sb.append("<br/><div>Thanks & Regards</div>");
				sb.append("<div>Support Team</div>");
				sb.append("<div>Chandigarh Smart City Limited</div>");
				
				EmailRequestUtil mail = new EmailRequestUtil();
				mail.setBody(sb.toString());
				mail.setEmail("arnabslife@gmail.com");
				mail.setSubject("CSCL : email notification...");
				
				JSONObject jsonMailObj = JSONFactoryUtil.createJSONObject();
				jsonMailObj.put("RequestInfo", requestInfo);
				jsonMailObj.put("emailRequest", mail);
				
				String eMail = RestClient.sendMail(jsonMailObj);
				System.out.println("........eMail.............."+eMail);
			}catch(Exception e1) {
				System.err.println("Error Came while sending mail notification......");	
			}*/

			actionRequest.setAttribute("refId", refId);
			actionRequest.setAttribute("isSubmitted", true);
			actionRequest.setAttribute("isResult", true);
			SessionMessages.add(actionRequest, "success-rti-payment");

			actionResponse.getRenderParameters().setValue("mvcPath", "/rti/view.jsp");
		}catch(Exception e) {
			System.err.println("Error Came while saving the data......");	
			SessionErrors.add(actionRequest, e.getClass());
			actionRequest.setAttribute("refId", refId);
			actionRequest.setAttribute("isSubmitted", false);
			actionRequest.setAttribute("isResult", false);
			actionResponse.getRenderParameters().setValue("mvcPath", "/rti/view.jsp");
		}
	}
}
