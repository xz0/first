<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" isErrorPage="true"%>
<html>
<head>
<title>404</title>
<meta http-equiv="Cache-control" content="no-cache" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<%
String original = (String) request.getAttribute("javax.servlet.forward.request_uri");
String queryString = request.getQueryString();
    if(queryString!=null && queryString.equals("a=login")){
        if(original!=null && original.contains("admin.d")){
            String url = request.getContextPath()+"/admin/login.d";
            System.out.println("url: "+url);
            response.sendRedirect(url);
        }
    }
System.out.println("=====+++++404 url:"+original+"?"+queryString);
if (exception != null){
	exception.printStackTrace(System.out);
}
%>
很抱歉,您访问的页面不存在或已被删除。(出错码:404)<br/>
</body>
</html>