<%@ page language="java" import="org.agnitas.util.*, java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/WEB-INF/agnitas-taglib.tld" prefix="agn" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<% int index=((Integer)request.getAttribute("opIndex")).intValue(); %>

<table border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td><b><%= index+1 %>.&nbsp;<bean:message key="Action.GetCustomerData"/></b></td>
    </tr>
    <tr>
        <td>
            <html:checkbox property="<%= "actions["+index+"].loadAlways" %>"><bean:message key="action.getcustomer.loadalways"/></html:checkbox>
        </td>
    </tr>
    <tr>
        <td>
            &nbsp;<br>
            <html:image src="button?msg=Delete" border="0" property="deleteModule" value="<%= Integer.toString(index) %>"/>
        </td>
    </tr>
</table>