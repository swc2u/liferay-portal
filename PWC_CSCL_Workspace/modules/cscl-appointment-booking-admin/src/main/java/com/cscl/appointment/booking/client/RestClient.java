package com.cscl.appointment.booking.client;

import com.cscl.appointment.booking.admin.portlet.action.EmailWrapper;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.Header;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class RestClient {
	


	/* Token Generation public */
	public static final String ipHostAccessToken = "https://egov-dev.chandigarhsmartcity.in/user/oauth/token?tenantId=ch";
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
		    
			System.out.println("ipHostAccessToken---->"+ipHostAccessToken);
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
				HttpResponse response = null;
				
				  try {
					    response = client.execute(post);
					  } 
				  	catch (ClientProtocolException e) {	
				  		System.out.println("exception clientProtocol"+e);
					    e.printStackTrace();
					  } 
				  catch (IOException e) {
				  		System.out.println("exception IOException"+e);
					    e.printStackTrace();
					  }
				System.out.println("response---->"+response);
				
			/*
			 * try { JSONObject jsonObject =
			 * JSONFactoryUtil.createJSONObject(response.toString());
			 * 
			 * 
			 * JSONObject data = jsonObject.getJSONObject("data"); String token =
			 * data.toJSONString();
			 * 
			 * System.out.println("token---->"+token);
			 * 
			 * } catch (JSONException e) { e.printStackTrace(); }
			 */
				BufferedReader rd = new BufferedReader(	new InputStreamReader(response.getEntity().getContent()));
				
				System.out.println("BufferedReader rd"+rd);
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
					System.out.println("result is:----"+result);
					System.out.println("Line==="+line);
				}
			System.out.println("result.toString()"+result.toString());
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject(result.toString());
				System.out.println("......................"+jsonObject.getString("access_token")); 
				 accesToken = jsonObject.getString("access_token");
		}
				catch(Exception e) {
				e.printStackTrace();
			}
			return accesToken;
		}	
		
		public static String sendSms(JsonObject jsnObj) {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(ipHostSendSMS);
			StringBuffer result = new StringBuffer();
			try {
				
				
				System.out.println("Inside SMS Function");
				// HttpEntity entity = new ByteArrayEntity(jsnObj.toString().getBytes("UTF-8"));
		         StringEntity entity = new StringEntity(jsnObj.toString(),"UTF-8");
		         entity.setChunked(false);
		         post.addHeader("content-type", "application/json");
				 post.setEntity(entity);
		      //   CloseableHttpResponse response = (CloseableHttpResponse) client.execute(post);
				 
				HttpResponse response = client.execute(post);
				 BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				 
				 System.out.println("Response for sms--->"+response);
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
		
		public static String sendMail(JsonObject jsonMailObj) {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(ipHostSendMail);
			StringBuffer result = new StringBuffer();
			try {
				// HttpEntity entity = new ByteArrayEntity(jsnObj.toString().getBytes("UTF-8"));
		         StringEntity entity = new StringEntity(jsonMailObj.toString(),"UTF-8");
				 post.setEntity(entity);
		         post.addHeader("content-type", "application/json");			    
				 HttpResponse response = client.execute(post);
				 System.out.println("Response--->"+response);
				 BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				 System.out.println("RD->"+rd);
				 String line = "";
				 while ((line = rd.readLine()) != null) {
					result.append(line);
				 }
				 System.out.println("Result after while-->"+result);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("..........Mail............"+result.toString());
			
			return result.toString();
			
		}
			
}
