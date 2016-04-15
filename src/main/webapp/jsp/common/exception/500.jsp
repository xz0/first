<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" isErrorPage="true"%>
<html>
<head>
<title>500</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="Cache-control" content="no-cache" />
</head>
<body>
<%
String original = (String) request.getAttribute("javax.servlet.forward.request_uri");
String queryString = request.getQueryString();
System.out.println("=====+++++500 url:"+original+"?"+queryString);
if (exception != null){
	exception.printStackTrace(System.out);
}
%>
网络繁忙,请稍后再试!(出错码:500)<br/>
</body>
</html>
