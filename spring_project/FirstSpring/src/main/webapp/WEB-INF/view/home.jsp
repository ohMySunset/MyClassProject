<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<h1>Index</h1>

	<c:url value="/hello" var="hello" />
	<ul>
		<li><a href="hello">/hello</a></li>
		<li><a href="${hello}">${hello}</a></li>


		<c:url value="/member/login" var="login" />
		<li><a href="${login}">${login}</a></li>


		<c:url value="/member/search" var="memberSearch" />
		<li><a href="${memberSearch}">${memberSearch}</a></li>

		<c:url value="/order/order" var="order" />
		<li><a href="${order}">${order}</a></li>

		<c:url value="/cookie/make" var="cookieMake" />
		<li><a href="${cookieMake}">${cookieMake}</a></li>

		<c:url value="/cookie/view" var="cookieView" />
		<li><a href="${cookieView}">${cookieView}</a></li>

		<c:url value="/header/header" var="header_url" />
		<li><a href="${header_url}">${header_url}</a></li>

		<c:url value="/search/search" var="search" />
		<li><a href="${search}">${search}</a></li>

		<c:url value="/upload/uploadForm" var="upload" />
		<li><a href="${upload}">${upload}</a></li>

		<c:url value="/member/list" var="list" />
		<li><a href="${list}">${list}</a></li>

		<c:url value="/member/reg" var="reg" />
		<li><a href="${reg}">${reg}</a></li>

		<c:url value="/members/10" var="members" />
		<li><a href="${members}">${members}</a></li>

		<c:url value="/message/listXml" var="listXml" />
		<li><a href="${listXml}">${listXml}</a></li>

		<c:url value="/message/listJson" var="listJson" />
		<li><a href="${listJson}">${listJson}</a></li>

		<c:url value="/rest/ver1/members/3" var="restMember" />
		<li><a href="${restMember}">${restMember}</a></li>

		<c:url value="/rest/ver1/members" var="restMembers" />
		<li><a href="${restMembers}">${restMembers}</a></li>

		<c:url value="/rest/ver1/members/map" var="restMemberMap" />
		<li><a href="${restMemberMap}">${restMemberMap}</a></li>
		
			<c:url value="/mail/simplemail" var="simplemail" />
		<li><a href="${simplemail}">${simplemail}</a></li>
		

	</ul>
</body>
</html>
