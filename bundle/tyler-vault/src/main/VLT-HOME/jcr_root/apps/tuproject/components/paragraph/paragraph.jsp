<%@include file="/libs/foundation/global.jsp"%>
<%@ page session="false"
         contentType="text/html; charset=utf-8"%>
<% String paragraph = xssAPI.encodeForHTML(properties.get("paragraph", ""));
   String empty = "Enter paragraph information here";
   if (paragraph.isEmpty())
		paragraph = empty;
%>
<p class="paragraph"><%= paragraph %></p>
