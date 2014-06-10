<%--

  Header component.

  Header for tuproject

--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %><%
%><%
	// TODO add you code here
%>
<div class="logo">
    <a href="http://localhost/TUWiki.php">
        <img src="${currentDesign.path}/Images/Tyrant-Unleashed-Logo.jpg" height="79"/> </a> 
</div>

<div id="pagetitle">
    <a href="http://localhost/TUWiki.php" class="title">Tyrant Unleashed Wiki</a>
</div>

<div class="getit">
    Get the game:
</div>

<div class="download">
    <a href="https://play.google.com/store/apps/details?id=com.kongregate.mobile.tyrant.google">
        <img src="${currentDesign.path}/Images/gplay.png" height="41px"/></a> 
    <a href="https://itunes.apple.com/us/app/tyrant-unleashed/id657628191?mt=8">
        <img src="${currentDesign.path}/Images/apple.png" height="41px"/></a> 
</div>

<div class="topmenu"> &nbsp
    <a href="#" class="button">Game Overview</a> 
    <a href="#" class="button">Missions</a>
    <a href="#" class="button">Cards</a>
    <a href="#" class="button">Skills</a>
    <a href="#" class="button">About This Wiki</a>
</div>

<form method="get" action="/search.php" id="search">
    <input name="q" type="text" size="40" placeholder="Search this wiki" />
</form>