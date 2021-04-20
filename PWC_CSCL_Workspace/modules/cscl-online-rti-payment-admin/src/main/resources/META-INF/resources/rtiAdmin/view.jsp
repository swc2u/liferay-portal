<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ResourceBundle" %>
<%@page import="com.liferay.portal.kernel.security.permission.PermissionChecker" %>
<%@page import="com.cscl.online.rti.payment.admin.portlet.util.CommonUtil" %>
<%@page import="com.cscl.online.rti.payment.model.CsclRtiPaymentDetails" %>
<%@page import="com.cscl.online.rti.payment.service.CsclRtiPaymentDetailsLocalServiceUtil" %>
<%@page import="com.cscl.online.rti.payment.admin.portlet.util.comparator.CustomComparator" %>
<%@page import="com.cscl.online.rti.payment.admin.portlet.util.comparator.CustomComparatorUtil" %>

<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL name="/rtiAdmin/rti_search"
	refererPlid="<%=themeDisplay.getRefererPlid()%>" var="searchRtiAdminURL">
	<portlet:param name="mvcPath" value="/rtiAdmin/view.jsp" />
	<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"/>
</liferay-portlet:actionURL>
<%
/* long userId = themeDisplay.getUserId(); */
String fromDate = ParamUtil.getString(request, "fromDate",null);
String toDate = ParamUtil.getString(request, "toDate",null);
boolean isFilter = ParamUtil.getBoolean(request, "isFilter",false);
System.out.println("fromDate"+fromDate+"...toDate...."+toDate+"...isFilter...."+isFilter);
List<CsclRtiPaymentDetails> paymentList = new ArrayList<CsclRtiPaymentDetails>();
try{
	isFilter = GetterUtil.getBoolean(renderRequest.getAttribute("isFilter"));
	if(isFilter){
		System.out.println("ifff");
		paymentList = (List<CsclRtiPaymentDetails>) renderRequest.getAttribute("res");
// 		isFilter = GetterUtil.getBoolean(renderRequest.getAttribute("isFilter"));
	}else{
		paymentList = CsclRtiPaymentDetailsLocalServiceUtil.getCsclRtiPaymentDetailses(0, CsclRtiPaymentDetailsLocalServiceUtil.getCsclRtiPaymentDetailsesCount());
	}
}catch(Exception e){
	System.err.println("Error: While getting paymentList..");
}
String orderByCol = ParamUtil.getString(request, "orderByCol","refId");
String orderByType = ParamUtil.getString(request, "orderByType","desc");
int pageNo=GetterUtil.getInteger(ParamUtil.getString(request,"cur"));
int itemsPerPage=GetterUtil.getInteger(ParamUtil.getString(request,"delta"));
int startPagination =1;
int endPagination=20;
if(itemsPerPage != 0){
	if(pageNo != 0){
		startPagination=itemsPerPage*(pageNo-1)+1;
		endPagination=pageNo*itemsPerPage;
	}else{
		endPagination = itemsPerPage;
	}
}
int counter=startPagination;
if(Validator.isNotNull(paymentList)){
	System.out.println("Payment List...");
	OrderByComparator comparator = CustomComparatorUtil.getOrderByComparator(orderByCol, orderByType);
	ListUtil.sort(paymentList, comparator);
}

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/rtiAdmin/view.jsp");
iteratorURL.setParameter("orderByCol", orderByCol);
iteratorURL.setParameter("orderByType", orderByType);

//if(paymentList.size()>0){
%>
<portlet:resourceURL id="/rtiAdmin/report" var="exportCSVURL">
	<portlet:param name="fromDate" value="<%=fromDate %>"/>
	<portlet:param name="toDate" value="<%=toDate %>"/>
	<%-- <portlet:param name="paymentList" value="<%=paymentList %>"/> --%>
</portlet:resourceURL>

<b><liferay-ui:message key="list-rti-payments"/></b>
<aui:form cssClass="contact-form" action="<%=searchRtiAdminURL%>" method="post" name="fm">
	<div class="row" style="margin-top:1em;">
		<div class="col-md-4">
			<aui:input name="fromDate" type="date" placeholder="fromDate" label="fromDate" required="true">
				<aui:validator name="required" />
			</aui:input>
		</div>
		<div class="col-md-4">
			<aui:input name="toDate" type="date" placeholder="toDate" label="toDate" required="true">
				<aui:validator name="required" />
			</aui:input>
		</div>
		<div class="col-md-12">
			<aui:button type="submit" value="Search"/>
			<a href="<%=exportCSVURL%>"><aui:button type="button" value="Export Data as CSV"/></a>
		</div>
	</div>
</aui:form>
<%
if(paymentList.size()>0){
%>
<div class="col-md-12">
	<liferay-ui:search-container iteratorURL="<%=iteratorURL%>" orderByCol="<%= orderByCol %>" orderByType="<%=orderByType %>"  >
	<liferay-ui:search-container-results >
	    <%  results = paymentList;			    
			total = paymentList.size();
			searchContainer.setTotal(results.size());
			pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
		    pageContext.setAttribute("total", results.size());
	    %>
	</liferay-ui:search-container-results>
	    <liferay-ui:search-container-row
	        className="com.cscl.online.rti.payment.model.CsclRtiPaymentDetails"
	        modelVar="rti" keyProperty="id_">
	        <liferay-ui:search-container-column-text name="#">
				<span class="pull-right"><%=counter++ %></span>
			</liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text orderable="true" name="refId" orderableProperty="refId">
	        	<%=CommonUtil.getTextFromXml(rti.getRefId(), locale) %>
	        </liferay-ui:search-container-column-text>
	        <liferay-ui:search-container-column-text name="name">
	        	<%=CommonUtil.getTextFromXml(rti.getApplicantName(), locale) %>
	        </liferay-ui:search-container-column-text>
	       <liferay-ui:search-container-column-text name="mobile">
	        	<%=CommonUtil.getTextFromXml(rti.getApplicantMobile(), locale) %>
	        </liferay-ui:search-container-column-text>
	        <liferay-ui:search-container-column-text name="email">
	        	<%=CommonUtil.getTextFromXml(rti.getApplicantEmail(), locale) %>
	        </liferay-ui:search-container-column-text>
	        <%-- <liferay-ui:search-container-column-text name="address">
	        	<%=CommonUtil.getFormattedText(rti.getAddress(), locale) %>
	        </liferay-ui:search-container-column-text> --%>
	        <liferay-ui:search-container-column-text name="rtiSubject">
	        	<%=CommonUtil.getFormattedText(rti.getRtiSubject(), locale) %>
	        </liferay-ui:search-container-column-text>
	        <%-- <liferay-ui:search-container-column-text name="rtiFee">
	        	<%=rti.getRtiFeeAmount()%>
	        </liferay-ui:search-container-column-text> --%>
	        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "createdDate") %>">
	        	<%=DateUtil.getDate(rti.getCreatedDate(), "dd-MM-yyyy", locale) %>
	        </liferay-ui:search-container-column-text>
	    </liferay-ui:search-container-row>
	    <liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>
<%}else{ %>
<b><liferay-ui:message key="no-rti"/></b>
<%} %>
