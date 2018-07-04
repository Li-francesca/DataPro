<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>开课信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="assets/materialize/css/materialize.min.css" media="screen,projection" />
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css"> 
	
  </head>
  
  <body>
      <!--<c:forEach items="${kkxxlist}" var="kkxxlist">  
 		 <tr><input type="text" value="${kkxxlist.cnum}"/></tr> 	
 		 <tr><input type="text" value="${kkxxlist.cname}"/></tr> 	 	    	   	   
 	   	 <tr><input type="text" value="${kkxxlist.credit}"/></tr>
 	   	 <tr><input type="text" value="${kkxxlist.period}"/></tr>
 	   	 <tr><input type="text" value="${kkxxlist.ynum}"/></tr>
 	   	 <tr><input type="text" value="${kkxxlist.term}"/></tr>
 	   	 <tr><input type="text" value="${kkxxlist.aname}"/></tr>
 	   	 <a href="CourseInfoServlet?flag=xkxq&cnum=${kkxxlist.cnum}">查看</a>
     </c:forEach>    -->
     
     <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
            <!-- 导航栏 -->
                <button type="button" class="navbar-toggle waves-effect waves-dark" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand waves-effect waves-dark" href="index-teacher.html"><i class="large material-icons">track_changes</i> <strong>选课系统-教师</strong></a>
				
		<div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
            </div>

            <ul class="nav navbar-top-links navbar-right"> 
<!-- 用户选择 -->
				  <li><a class="dropdown-button waves-effect waves-dark" href="#!" data-activates="dropdown1"><i class="fa fa-user fa-fw"></i> <b>李四</b> <i class="material-icons right"></i></a></li>
            </ul>
        </nav>
<!-- 用户选择下拉框 -->
<ul id="dropdown1" class="dropdown-content">
<li><a href="index-teacher.html"><i class="fa fa-user fa-fw"></i>个人信息</a>
</li>
<li><a href="edit-teacher.html"><i class="fa fa-gear fa-fw"></i>修改信息</a>
</li> 
<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>退出登录</a>
</li>
</ul>

<!--  -->
	  <!--左边侧栏  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <a  class="waves-effect waves-dark"><i class="fa fa-desktop"></i>基本信息</a>
                </li>
                <li>
                    <a href="CourseInfoServlet?flag=kkxx" class="waves-effect waves-dark"><i class="fa fa-table"></i>课程信息</a>
                </li>
                <li>

                    <a href="academyMessage?idA=${idA}&name=${name}&Tnum=${Tnum}&Anum=${Anum}"><i class="fa fa-bar-chart-o"></i>所属信息</a>
                </li>
            </ul>

        </div>

    </nav>
        <!-- 右侧界面  -->
        <div id="page-wrapper" >
		    <div class="header"> 
                        <h1 class="page-header">
                            授课信息
                        </h1>						
		    </div>
		
            <div id="page-inner">    
            <div class="row">
                <div class="col-md-12">
                    <!-- Tables -->
                    <div class="card">
                        <div class="card-content">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th class="center">课程编号</th>
                                            <th class="center">课程名称</th>
                                            <th class="center">学分</th>
                                            <th class="center">学时</th>
                                            <th class="center">开课年度</th>
                                            <th class="center">学期</th>
                                            <th class="center">开课时间</th>
                                            <th class="center">开课单位</th>
                                            <th class="center">查看</th>
                                         </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${kkxxlist}" var="kkxxlist">                                 
                                         <tr class="odd gradeX">
                                            <td class="center">${kkxxlist.cnum}</td>
                                            <td class="center">${kkxxlist.cname}</td>
                                            <td class="center">${kkxxlist.credit}</td>
                                            <td class="center">${kkxxlist.period}</td>
                                            <td class="center">${kkxxlist.ynum}</td>
                                            <td class="center">${kkxxlist.term}</td>
                                            <td class="center">${kkxxlist.aname}</td>
                                            <td class="center">${kkxxlist.ynum}</td>
                                            <td class="center"><button><a href="CourseInfoServlet?flag=xkxq&cnum=${kkxxlist.cnum}">查看</button></a></td>
                                        </tr>
                                     </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>

        </div>    
    </div>        
    <!-- JS Scripts-->
 

    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
	
	<!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
	
	<script src="assets/materialize/js/materialize.min.js"></script>
	
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
	
	
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	
	 <script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>
	 <!-- DATA TABLE SCRIPTS -->
    <script src="assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script>
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>     
  </body>
</html>
