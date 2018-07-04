<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
   
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>选课系统-课程基本信息界面</title>
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
            <a class="navbar-brand waves-effect waves-dark" href="index-teacher.html"><i class="large material-icons">track_changes</i> <strong>选课系统-课程</strong></a>

            <div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
        </div>

    </nav>
   
    <!-- 右侧界面  -->
    <div id="page-wrapper" >
        <div class="header">
            <h1 class="page-header">
                基本信息
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
<%-- <table>
            <tr>
                <th>课程编号</th> 
                <th>课程名称</th>
                <th>学分</th>
                <th>课时</th>
                
                <th>学院</th>
                 <th>老师</th>
                <th>选课</th>
            </tr>
             <c:forEach var="list"  items="${courses}">
                <tr>
                	 
	                 <td>${list.Cnum}</td> 
	                 <td>${list.Cname}</td>
	                <td>${list.Credit}</td>
                    <td>${list.Period}</td>
                    <td>${list.Aname}</td>  
                    <td>${list.Tname}</td>
                   <td> ${list.Tnum}www</td>
                  	<td><a href="Select?tnum=${list.Tnum}&snum=${Snum}&cnum=${list.Cnum}">选课</a></td>
            	</tr>
            </c:forEach>         
        </table> --%>
                                    <tr>
                                        <th class="center">课程编号</th>
                                        <th class="center">课程名称</th>
                                        <th class="center">学分</th>
                                        <th class="center">课时</th>
                                        <th class="center">学院</th>
                                        <th class="center">老师</th>
                                        <th class="center">选课</th>
                                        
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="list"  items="${courses}">
                                    <tr class="odd gradeX">

                                            <td class="center">${list.Cnum}</td>
                                            <td class="center">${list.Cname}</td>
                                            <td class="center">${list.Credit} </td>
                                            <td class="center">${list.Period}</td>
                                            <td class="center">${list.Aname} </td>
                                            <td class="center">${list.Tname}</td>
                                            <%-- <td class="center">${list.Tnum}</td> --%>
                                            <td class="center"><a href="Select?tnum=${list.Tnum}&snum=${Snum}&cnum=${list.Cnum}">选课</a></td>
                                            <%-- <td class="center"><a href="SelectServlet?Snum=${Snum} ">课程</a></td> --%>
                                        </tr>
                   					 </c:forEach>     
                                    </tbody>
                                </table>
                               <%--  <a href="UpStuServlet?Snum=${Snum} "><button style="border:1px solid lightgrey;background-color:white;"> 编辑个人基本信息 </button></a> --%>
                            </div>

                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>

        </div>
    </div>
    <ul id="dropdown1" class="dropdown-content">
        <li><a href="index-teacher.html"><i class="fa fa-user fa-fw"></i>个人信息</a>
        </li>
        <li><a href="updateTeacher.jsp?Tnum=${Tnum}"><i class="fa fa-gear fa-fw"></i>修改信息</a>
        </li>
        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>退出登录</a>
        </li>
    </ul>
    <!--左边侧栏  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <a  class="waves-effect waves-dark"><i class="fa fa-desktop"></i>基本信息</a>
                </li>
                <li>
                    <a href="SelectServlet?Snum=${Snum}" class="waves-effect waves-dark"><i class="fa fa-table"></i>课程信息</a>
                </li>
                <%-- <li>

                    <a href="academyMessage?idA=${idA}&name=${name}&Tnum=${Tnum}&Anum=${Anum}"><i class="fa fa-bar-chart-o"></i>所属信息</a>
                </li> --%>
            </ul>

        </div>

    </nav>
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