<%@include file="/libs/foundation/global.jsp"%><%
%><%@ page session="false" %>
<body>
    <cq:include resourceType="/apps/tuproject/components/header" path="header"/>
	<div id="container-outer">
        <div id="container-inner">
            <div id="sidebar">
                <cq:include resourceType="/apps/tuproject/components/leftnav" path="leftnav"/>
            </div>
            <div id="content">
                <cq:include resourceType="/libs/foundation/components/parsys" path="parsys"/>
            </div>
        </div> 
    </div>
	<cq:include resourceType="/apps/tuproject/components/footer" path="footer"/>
</body>