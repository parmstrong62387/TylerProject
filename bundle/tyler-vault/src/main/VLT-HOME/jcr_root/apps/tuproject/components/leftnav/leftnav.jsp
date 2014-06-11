<%@include file="/libs/foundation/global.jsp"%><%
%><%@ page import="com.swx.core.leftnav.LeftNav"%>

<% pageContext.setAttribute("leftNav", new LeftNav(currentPage)); %>
<div class="leftnavcont"> 
<ul>
<c:forEach items="${leftNav.items}" var="leftNavItem">
<c:if test="${leftNavItem.level == 0}"> 
    <li>
</c:if>
<c:if test="${leftNavItem.level == 1}">
    <li class="indentchild">
</c:if>
<a href="${leftNavItem.link}" class="link">${leftNavItem.title}</a></li>
</c:forEach>
</ul>    
</div>