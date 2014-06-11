<%@include file="/libs/foundation/global.jsp"%>
<%@ page session="false"
         contentType="text/html; charset=utf-8"%>
<%= xssAPI.encodeForHTML( properties.get("wikiPageTitle", "") ) %>