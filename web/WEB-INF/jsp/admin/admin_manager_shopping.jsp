<%-- 
    Document   : admin_manager_shopping
    Created on : Dec 6, 2018, 1:26:00 AM
    Author     : chellong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="author" content="">
    <!-- Favicon icon -->
<!--    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/public/assets/images/favicon.png">
    <title>Admin Press Admin Template - The Ultimate Bootstrap 4 Admin Template</title>
     Bootstrap Core CSS 
    <link href="${pageContext.request.contextPath}/public/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
     morris CSS 
    <link href="${pageContext.request.contextPath}/public/assets/plugins/morrisjs/morris.css" rel="stylesheet">
     Custom CSS 
    <link href="${pageContext.request.contextPath}/public/css/style.css" rel="stylesheet">
     You can change the theme colors from here 
    <link href="${pageContext.request.contextPath}/public/css/colors/blue.css" id="theme" rel="stylesheet">-->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<style>
    

.wrap {
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: flex-start;
/*  position: absolute;
  bottom: 100px;*/
}

.button {
  width: 140px;
  height: 45px;
  font-family: 'Roboto', sans-serif;
  font-size: 11px;
  text-transform: uppercase;
  letter-spacing: 2.5px;
  font-weight: 500;
  color: #000;
  background-color: #fff;
  border: none;
  border-radius: 45px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  }

.button:hover {
  background-color: #2EE59D;
  box-shadow: 0px 15px 20px rgba(46, 229, 157, 0.4);
  color: #fff;
  transform: translateY(-7px);
}
</style>
<%--<%@include file="partials/head.jsp" %>--%>
<%@include file="partials/sidebar.jsp" %>

 <%--<c:out value="${head[0]}"/>--%>
</html>