<%@page import="victor.training.spring.webapp.UserServiceSingleton"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java"%>
<html>
<head>
<title>Spring Test Page - Logged in</title>
</head>
<body>

	You are logged in as <%=WebApplicationContextUtils.getWebApplicationContext(config.getServletContext())
		.getBean(UserServiceSingleton.class).getUsername() %>
	<p>
		<a href="home?logout">Logout Now</a>
	<p>
		Timestamp:
		<%=new java.util.Date()%>
		<p>See some <a href="scopes.jsp" >scopes</a>.
</body>
</html>