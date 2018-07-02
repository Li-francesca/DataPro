<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>登陆|学生选课信息管理系统</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/signin.css" rel="stylesheet">
</head>
<body>

    <h2>选课管理信息系统</h2>
      <h3>姓名:${Sname}</h3>
	  <h3>性别：${Ssex}</h3>
	  <h3>出生年月：${Sbirth}</h3>
	  <h3>班级号：${Clnum} </h3>
	  <h3>邮箱：${Email}</h3>
	  <h3>状态：${Status}</h3>
	  <h3><a href ="${pageContext.request.contextPath}/servlet/UpStuServlet?status=doPost&Snum=${Snum} ">修改信息</a></h3>
	  <h3><a href ="${pageContext.request.contextPath}/servlet/SelectServlet?status=doPost&Snum=${Snum} ">选课</a></h3>
			
		
</body>
</html>