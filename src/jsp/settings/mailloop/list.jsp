<%--
/*********************************************************************************
 * The contents of this file are subject to the Common Public Attribution
 * License Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.openemm.org/cpal1.html. The License is based on the Mozilla
 * Public License Version 1.1 but Sections 14 and 15 have been added to cover
 * use of software over a computer network and provide for limited attribution
 * for the Original Developer. In addition, Exhibit A has been modified to be
 * consistent with Exhibit B.
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 * 
 * The Original Code is OpenEMM.
 * The Original Developer is the Initial Developer.
 * The Initial Developer of the Original Code is AGNITAS AG. All portions of
 * the code written by AGNITAS AG are Copyright (c) 2007 AGNITAS AG. All Rights
 * Reserved.
 * 
 * Contributor(s): AGNITAS AG. 
 ********************************************************************************/
 --%><%@ page language="java" contentType="text/html; charset=utf-8" import="org.agnitas.util.*, org.agnitas.web.*, org.agnitas.beans.*" %>
<%@ taglib uri="/WEB-INF/agnitas-taglib.tld" prefix="agn" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<agn:CheckLogon/>

<agn:Permission token="mailing.show"/>

<% pageContext.setAttribute("sidemenu_active", new String("Settings")); %>


<% pageContext.setAttribute("sidemenu_sub_active", new String("Mailloops"));  %>

<% pageContext.setAttribute("agnNavigationKey", new String("Mailloops")); %>
<% pageContext.setAttribute("agnHighlightKey", new String("Overview")); %>
<% pageContext.setAttribute("agnTitleKey", new String("Mailloops")); %>
<% pageContext.setAttribute("agnSubtitleKey", new String("Mailloops")); %>

<%@include file="/header.jsp"%>
<html:errors/>

      <table border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td><span class="head3"><bean:message key="Mailloop"/>&nbsp;&nbsp;</span></td>
            <td><span class="head3"><bean:message key="Description"/>&nbsp;&nbsp;</span></td>

            <td><span class="head3"><bean:message key="mailloop.forward_adr"/>&nbsp;</span></td>
        </tr>
        <tr><td colspan="4"><hr></td></tr>
<%	EmmLayout aLayout=(EmmLayout)session.getAttribute("emm.layout");
	String dyn_bgcolor=null;
    boolean bgColor=true;
 %>          
        <logic:iterate id="loop" name="mailloopForm" property="mailloops" type="org.agnitas.beans.Mailloop">
<% 	if(bgColor) {
   		dyn_bgcolor=aLayout.getNormalColor();
    	bgColor=false;
    } else {
    	dyn_bgcolor=new String("#FFFFFF");
        bgColor=true;
    }
 %>        
            <tr bgcolor="<%= dyn_bgcolor %>">
                <td><html:link page="<%= new String("/mailloop.do?action=" + MailloopAction.ACTION_VIEW + "&mailloopID=" + ((Mailloop)pageContext.getAttribute("loop")).getId()) %>"><b><bean:write name="loop" property="shortname"/></b></html:link>&nbsp;&nbsp;</td>
                <td><html:link page="<%= new String("/mailloop.do?action=" + MailloopAction.ACTION_VIEW + "&mailloopID=" + ((Mailloop)pageContext.getAttribute("loop")).getId()) %>"><bean:write name="loop" property="description"/></html:link>&nbsp;&nbsp;</td>
                <td><html:link page="<%= new String("/mailloop.do?action=" + MailloopAction.ACTION_VIEW + "&mailloopID=" + ((Mailloop)pageContext.getAttribute("loop")).getId()) %>">
                ext_<%= ((Mailloop)pageContext.getAttribute("loop")).getId() %>@<%= AgnUtils.getCompany(request).getMailloopDomain() %>
                </html:link>&nbsp;&nbsp;</td>
                <td>
                        <html:link page="<%= new String("/mailloop.do?action=" + MailloopAction.ACTION_CONFIRM_DELETE + "&mailloopID=" + ((Mailloop)pageContext.getAttribute("loop")).getId()) %>"><img src="<bean:write name="emm.layout" property="baseUrl" scope="session"/>delete.gif" alt="<bean:message key="Delete"/>" border="0"></html:link>
                        <html:link page="<%= new String("/mailloop.do?action=" + MailloopAction.ACTION_VIEW + "&mailloopID=" + ((Mailloop)pageContext.getAttribute("loop")).getId()) %>"><img src="<bean:write name="emm.layout" property="baseUrl" scope="session"/>bearbeiten.gif" alt="<bean:message key="Edit"/>" border="0"></html:link>
                </td>
            </tr>
        </logic:iterate>
        
      </table>

<%@include file="/footer.jsp"%>
