<%--

  Header component.

  Header for tuproject

--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@ page import="java.util.Iterator,
        com.day.cq.wcm.api.PageFilter"%>
<div class="leftnavcont"> <dl>
<%  Page root = currentPage.getAbsoluteParent(1);
    if (root != null) {
        Iterator<Page> children = root.listChildren();
        while (children.hasNext()) {
            Page child = children.next();
            String title = child.getTitle() == null ? child.getName() : child.getTitle();%>
<dt><a href="<%= child.getPath() %>.html" class="link"><b><%= title %></b></a></dt>
		 <% Iterator<Page> childrenofchildren = child.listChildren();
        	while (childrenofchildren.hasNext()) {
            	Page superchild = childrenofchildren.next();
            	String childtitle = superchild.getTitle() == null ? superchild.getName() : superchild.getTitle();%>
				<dd><a href="<%= superchild.getPath() %>.html" class="link"><%= childtitle %></a></dd>
<%}}}%>
</dl></div>