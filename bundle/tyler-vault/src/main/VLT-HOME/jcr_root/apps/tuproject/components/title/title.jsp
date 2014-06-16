<%@include file="/libs/foundation/global.jsp"%>
<%@ page session="false"
         contentType="text/html; charset=utf-8"%>
<cq:text property="wikiPageTitle" default="${currentPage.title}" placeholder="${currentPage.title}"/>