package cscl.online.rti.payment.web.portlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.cscl.online.rti.payment.web.constants.CsclOnlineRtiPaymentWebPortletKeys;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(property = { "javax.portlet.name=" + CsclOnlineRtiPaymentWebPortletKeys.CSCLONLINERTIPAYMENTWEB,
"mvc.command.name=/rti/otpValidation" }, service = MVCResourceCommand.class)

public class OtpValidationMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		String otpText = ParamUtil.getString(resourceRequest, "otpText", StringPool.BLANK);
		System.out.println("OTP ...."+otpText);
		boolean isOtpVerified = false;
		try {
			if("2222".equalsIgnoreCase(otpText)) {
				isOtpVerified = true;
			}
		} catch (Exception e) {
			System.err.println("OTP verification failed.");
		}
		PrintWriter writer = null;
		try {
			writer = resourceResponse.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.print(isOtpVerified);
		writer.flush();
		resourceResponse.reset();
		resourceResponse.resetBuffer();
		return true;
	}

}
