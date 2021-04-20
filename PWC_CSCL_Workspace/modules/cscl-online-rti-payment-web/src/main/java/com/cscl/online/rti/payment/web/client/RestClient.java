package com.cscl.online.rti.payment.web.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;


public class RestClient {

	/* Token Generation public */
	public static final String ipHostAccessToken = "http://egov-dev.chandigarhsmartcity.in/user/oauth/token?tenantId=ch";
	public static final String ipHostSendSMS = "https://egov-dev.chandigarhsmartcity.in/notification-service/sms/v1/_send";
	public static final String ipHostSendMail = "https://egov-dev.chandigarhsmartcity.in/notification-service/email/v1/_send";
	
/*	  public static void main(String[] args) {
		  String token =  RestClient.generateAdminToken();
		  System.out.println("........token.............."+token); RequestInfoUtil
		  requestInfo = new RequestInfoUtil(); requestInfo.setApiId("Rainmaker");
		  requestInfo.setVer(".01"); requestInfo.setTs("");
		  requestInfo.setAction("_send"); requestInfo.setDid("1");
		  requestInfo.setKey(""); requestInfo.setMsgId("20170310130900|en_IN");
		  requestInfo.setAuthToken(token);
		  
		  SmsRequestUtil smsRequest = new SmsRequestUtil();
		  smsRequest.setMobileNumber("8073787281");
		  smsRequest.setMessage("Hello Testing OTP");
		  
		  JSONObject jsnObj = JSONFactoryUtil.createJSONObject();
		  jsnObj.put("RequestInfo", requestInfo); jsnObj.put("smsRequest", smsRequest);
		  
		  String sms = sendSms(jsnObj);
		  System.out.println("........sms.............."+sms);
	  }*/
	
	
	/*
	 * protected void init() { client = ClientBuilder.newClient(); //query params:
	 * ?q=Turku&cnt=10&mode=json&units=metric target =
	 * client.target("http://api.openweathermap.org/data/2.5/forecast/daily")
	 * .queryParam("cnt", "10") .queryParam("mode", "json") .queryParam("units",
	 * "metric"); }
	 */
	 
		@SuppressWarnings({ "deprecation", "resource" })
		public static String generateAdminToken() {
			
			HttpClient client = new DefaultHttpClient();
			
//			final HttpParams httpParams = new BasicHttpParams();
//		    HttpConnectionParams.setConnectionTimeout(httpParams, 30000);
//		    client = new DefaultHttpClient(httpParams);
		    
			HttpPost post = new HttpPost(ipHostAccessToken);
			StringBuffer result = new StringBuffer();
			String accesToken = ""; 
			post.setHeader("Authorization", "Basic ZWdvdi11c2VyLWNsaWVudDplZ292LXVzZXItc2VjcmV0");
			try {
				System.out.println("Execution starts");
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("username", "NOTIFICATIONUSER"));
				nameValuePairs.add(new BasicNameValuePair("scope", "read"));
				nameValuePairs.add(new BasicNameValuePair("password", "123456"));
				nameValuePairs.add(new BasicNameValuePair("grant_type", "password"));
				nameValuePairs.add(new BasicNameValuePair("tenantId", "ch"));
				nameValuePairs.add(new BasicNameValuePair("userType", "SYSTEM"));
				post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));
				System.out.println("Value Added");
				HttpResponse response = client.execute(post);
				BufferedReader rd = new BufferedReader(	new InputStreamReader(response.getEntity().getContent()));
				
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
			
				 JSONObject jsonObject = JSONFactoryUtil.createJSONObject(result.toString());
				 System.out.println("......................"+jsonObject.getString("access_token")); 
				 accesToken = jsonObject.getString("access_token");
			}catch(Exception e) {
				e.printStackTrace();
			}
			return accesToken;
		}	
		
		public static String sendSms(JSONObject jsnObj) {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(ipHostSendSMS);
			StringBuffer result = new StringBuffer();
			try {
				 HttpEntity entity = new ByteArrayEntity(jsnObj.toString().getBytes("UTF-8"));
			     post.setEntity(entity);
				 HttpResponse response = client.execute(post);
				 BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				 
				 String line = "";
				 while ((line = rd.readLine()) != null) {
					result.append(line);
				 }
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("..........SMS............"+result.toString());
			
			return result.toString();
			
		}
		
		public static String sendMail(JSONObject jsnObj) {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(ipHostSendMail);
			StringBuffer result = new StringBuffer();
			try {
				 HttpEntity entity = new ByteArrayEntity(jsnObj.toString().getBytes("UTF-8"));
			     post.setEntity(entity);
				 HttpResponse response = client.execute(post);
				 BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				 
				 String line = "";
				 while ((line = rd.readLine()) != null) {
					result.append(line);
				 }
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("..........Mail............"+result.toString());
			
			return result.toString();
			
		}
			
}
