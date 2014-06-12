<%@include file="/libs/foundation/global.jsp"%>
<%@ page session="false"
         contentType="text/html; charset=utf-8"%>
<% String title = xssAPI.encodeForHTML(properties.get("wikiPageTitle", ""));
   String pageTitle = currentPage.getTitle();
   if (title.isEmpty())
		title = pageTitle;
%>
<%= title %>