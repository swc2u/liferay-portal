package cscl.online.rti.payment.web.portlet.action;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;
import com.cscl.online.rti.payment.service.CsclRtiPaymentDetailsLocalServiceUtil;
import com.cscl.online.rti.payment.web.client.RestClient;
//import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;
//import com.cscl.online.rti.payment.service.CsclRtiPaymentDetailsLocalServiceUtil;
import com.cscl.online.rti.payment.web.constants.CsclOnlineRtiPaymentWebPortletKeys;
import com.cscl.online.rti.payment.web.util.EmailRequestUtil;
import com.cscl.online.rti.payment.web.util.RequestInfoUtil;
import com.cscl.online.rti.payment.web.util.SmsRequestUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

@Component(property = { "javax.portlet.name=" + CsclOnlineRtiPaymentWebPortletKeys.CSCLONLINERTIPAYMENTWEB,
		"mvc.command.name=/rti/view" }, service = MVCActionCommand.class)
public class BookRtiPaymentMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		boolean isAllowed = false;

		String name = ParamUtil.getString(actionRequest, "applicantName");
		String email = ParamUtil.getString(actionRequest, "applicantEmail");
		String mobile = ParamUtil.getString(actionRequest, "applicantMobile");
		String address = ParamUtil.getString(actionRequest, "address");
		int rtiFees = 0;//ParamUtil.getInteger(actionRequest, "rtiFeeAmount");
		String subject = ParamUtil.getString(actionRequest, "rtiSubject");

		if (Validator.isNotNull(name)) {
			if (Validator.isNotNull(email)) {
				if (Validator.isNotNull(mobile)) {
					if (Validator.isNotNull(address)) {
						if (Validator.isNotNull(rtiFees)) {
							if (Validator.isNotNull(subject)) {
								isAllowed = true;
							}
						}
					}
				}
			}
		}

		if (isAllowed) {
			// if(isCaptchaVerified) {
			// Date dateAppointment = new Date();
			String refId = "RTI-";
			Date today = new Date();
			int year = 0;
			int month = 0;
			int day = 0;
			try {
				int total = CsclRtiPaymentDetailsLocalServiceUtil.getCsclRtiPaymentDetailsesCount()+1;
				year = today.getYear();
				year += 1900;
				month = today.getMonth();
				day = today.getDay();
				String days = "";
				String months = "";
				
				if (day < 10) {
					System.out.println("if day");
					days = new DecimalFormat("00").format(day);
				}else {
					days = String.valueOf(day);
				}
				if (month < 10) {
					months = new DecimalFormat("00").format(month);
				}else {
					months = String.valueOf(month);
				}
				refId += year + "-" + months + "-" + days + "-";
				if (total > 999999) {
					refId += total;// if 6 digit exceeds
				} else {
					refId += String.format("%06d", total);// 6 digit sequestial number
				}
				System.out.println("refId" + refId);
				// dateAppointment=new
				// SimpleDateFormat("dd/MM/yyyy").parse(today.toString());//yyyy-MM-dd
			} catch (Exception e) {
				// dateAppointment = new Date();
				System.err.println("Error : While converting date" + e);
			}
			String otp = generateOTP();
			try {
				long id = CounterLocalServiceUtil.increment(CsclRtiPaymentDetails.class.getName());
				CsclRtiPaymentDetails rti = CsclRtiPaymentDetailsLocalServiceUtil.createCsclRtiPaymentDetails(id);
				rti.setApplicantName(name);
				rti.setApplicantEmail(email);
				rti.setApplicantMobile(mobile);
				rti.setAddress(address);
				rti.setRefId(refId);
				rti.setRtiSubject(subject);
				rti.setRtiFeeAmount(rtiFees);
				
				try {
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
					
					SmsRequestUtil smsRequest = new SmsRequestUtil();
					smsRequest.setMobileNumber("8073787281");
					smsRequest.setMessage("Here is your  OTP "+otp);
					
					JSONObject jsnObj = JSONFactoryUtil.createJSONObject();
					jsnObj.put("RequestInfo", requestInfo);
					jsnObj.put("smsRequest", smsRequest);
					
					String sms = RestClient.sendSms(jsnObj);
					System.out.println("........sms.............."+sms);
					
					
					StringBuilder sb = new StringBuilder();
					sb.append("<div>Dear "+name+",</div>");
					sb.append("<div>Your login credential to access mChandigarh Application https://egov.chandigarhsmartcity.in/employee/user/login is given below. Please change your password after login from the edit profile section of dashboard.</div>");
					sb.append("<br/><div>User Id: </div>");
					sb.append("<div>Password: </div>");
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
					
				}catch(Exception e) {
					e.getStackTrace();
				}
				actionRequest.setAttribute("refId", refId);
				actionRequest.setAttribute("OTP", otp);
				actionRequest.setAttribute("rtiObject", rti);
				actionRequest.setAttribute("isSubmitted", false);
				actionRequest.setAttribute("isResult", true);
				/* SessionMessages.add(actionRequest, "success-rti-payment"); */
				SessionMessages.add(actionRequest, "otp-sent-successful");

				actionResponse.getRenderParameters().setValue("mvcPath", "/rti/otpValidation.jsp");
			} catch (Exception e) {
				System.err.println("Error : "+e.getMessage());
				SessionErrors.add(actionRequest, e.getClass());
				actionResponse.getRenderParameters().setValue("mvcPath", "/rti/view.jsp");
			}
			/*
			 * }else { System.out.println("Inside else...");
			 * actionRequest.setAttribute("isResult", false);
			 * SessionErrors.add(actionRequest, "captcha-validation-failed");
			 * actionResponse.setRenderParameter("mvcPath", "/rti/view.jsp"); }
			 */
		} else {
			SessionErrors.add(actionRequest, "Please provide all mandatory field values");
			actionResponse.getRenderParameters().setValue("mvcPath", "/rti/view.jsp");
			return;
		}

	}

	public static String generateOTP() {
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		return String.valueOf(n);
	}
}
