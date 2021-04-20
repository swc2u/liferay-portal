package com.cscl.appointment.booking.admin.portlet.util;

public class RequestInfoUtil {


	private String apiId;
	private String ver;
    private String ts;
    private String action;
    private String did;
    private String key;
    private String msgId;
    private String requesterId;
    private String authToken;
    
    public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	@Override
	public String toString() {
		return "RequestInfoUtil [apiId=" + apiId + ", ver=" + ver + ", ts=" + ts + ", action=" + action + ", did=" + did
				+ ", key=" + key + ", msgId=" + msgId + ", requesterId=" + requesterId + ", authToken=" + authToken
				+ ", getVer()=" + getVer() + ", getTs()=" + getTs() + ", getAction()=" + getAction() + ", getDid()="
				+ getDid() + ", getKey()=" + getKey() + ", getMsgId()=" + getMsgId() + ", getRequesterId()="
				+ getRequesterId() + ", getAuthToken()=" + getAuthToken() + ", getApiId()=" + getApiId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getRequesterId() {
		return requesterId;
	}
	public void setRequesterId(String requesterId) {
		this.requesterId = requesterId;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getApiId() {
		return apiId;
	}
	public void setApiId(String apiId) {
		this.apiId = apiId;
	}
    
    


}
