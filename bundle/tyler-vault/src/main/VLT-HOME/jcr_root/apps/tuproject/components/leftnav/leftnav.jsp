<%--

  Header component.

  Header for tuproject

--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@ page import="java.util.Iterator,
        com.day.cq.wcm.api.PageFilter,
    	com.swx.core.leftnav.*"%>

<% pageContext.setAttribute("leftNav", new LeftNav(currentPage)); %>
<div class="leftnavcont"> 
<c:forEach items="${leftNav.items}" var="leftNavItem">
<c:if test="${leftNavItem.level == 0}"> 
    <h6> <a href="${leftNavItem.link}" class="link">${leftNavItem.title}</a> </h6>
</c:if>
<ul>
<c:if test="${leftNavItem.level == 1}">
    <li><a href="${leftNavItem.link}" class="link">${leftNavItem.title}</a></li>
</c:if>
</ul>
</c:forEach>
</div>