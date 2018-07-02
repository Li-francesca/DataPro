<%--
  Created by IntelliJ IDEA.
  User: ttop5
  Date: 16-4-19
  Time: 下午4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="static/css/signout.css" rel="stylesheet">
</head>
<br>
	<a href="/StuManage1">登录</a>
	<a href="../StuManage1">登录</a>
	<form action="${pageContext.request.contextPath }/servlet/StuManage1"  method="post">

    <table class="loginTable">

      <tr>
       <td id="Snum">学号：</td>
       <td id="Snum"><input type="text" name="Snum" id="Snum"></td>
      </tr>
      
       <tr>
       <td id="Passwd">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
       <td id="Passwd"><input type="password" name="Passwd" id="Passwd"></td>
      </tr>
      <tr>
       <td colspan="2"><input type="submit" value="登录"></td>
      </tr>
      
       
      
    </table>


</form>
 <%--  <%
    session.invalidate();
  %>

  <p>
    ：）您已成功注销，正在跳转至登陆页面！</br></br>
    ......
  </p>

  <%
    response.setHeader("refresh","1;url=index.jsp");
  %> --%>

</body>
</html>
