<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

session.invalidate();
response.sendRedirect(request.getContextPath() + "/login.jsp");
//out.println("<script>parent.location.href='login.jsp'</script>");
%>