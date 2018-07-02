
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>

  <div class="container">
    <div class="page-header">
      <h2>选课管理信息系统-student</h2>
     	 
       	   <%--  <h1>学号：</h1><p>${ntitle}</p> --%>
			<h3>姓名；</h3><p>${Sname}</p>
			<h3>性别：</h3>${Ssex}
			<h3>出生年月：</h3>${Sbirth}
			<h3>班级号：</h3>${Clnum} 
			<h3>邮箱：</h3>${Email}
			<h3>状态：</h3>${Status}
			<h3><a href ="${pageContext.request.contextPath}/servlet/UpStuServlet?status=doPost &Snum=${student.Snum} ">修改信息</a></h3>
		    <h3><a href ="${pageContext.request.contextPath}/servlet/SelectServlet?status=doPost &Snum=${student.Snum} ">选课</a></h3>
		
		<!-- <div class="newsnav">
			<a href="javascript:history.go(-1)">返回</a>
		</div> -->
		 
    </div>
  </div>

</body>
</html>
