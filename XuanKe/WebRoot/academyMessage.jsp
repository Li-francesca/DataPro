<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/2
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="dao" class="service.TeacherDao" ></jsp:useBean>
<%--
<html>
<head>
    <title>学院信息</title>
</head>
<body>

<h1> 学院名称：${name}</h1>

<table border="1">
    <tr>
        <td>专业号</td>
        <td>专业名称</td>
        <td>负责人</td>
        <td>班级
            <table>
                <tr>
                    <td>班级名称</td>
                    <td>班级编号</td>
                </tr>
            </table>


        </td>

    </tr>
 <c:forEach items="${list}" var="list">
    <tr>
<td> ${list.Dnum}</td>
 <td> ${list.Dname}</td>
  <td> ${list.Tname}</td>

        <td>
            <table border="1">
     <c:forEach items="${dao.charge1(list.Dnum)}" var="list1">
                <tr>
                    <td>${list1.Cname}</td>
                    <td>${list1.Clnum}</td>
                </tr>
     </c:forEach>
            </table>


        </td>
        </c:forEach>
</table>
</body>
</html>
--%>
<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>教师所属信息界面</title>
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
                    <a href="login?type=2&id=${Tnum}&psw=${psw}" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>基本信息</a>
                </li>
                <li>
                    <a href="class-teacher.html" class="waves-effect waves-dark"><i class="fa fa-table"></i>课程信息</a>
                </li>
                <li>
                    <a class="waves-effect waves-dark"><i class="fa fa-bar-chart-o"></i>所属信息</a>
                </li>
            </ul>

        </div>

    </nav>
    <!-- 右侧界面  -->
    <div id="page-wrapper" >
        <div class="header">
            <h1 class="page-header">
                所属信息
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
                                        <th class="center">学院编号</th>
                                        <th class="center">${Anum}</th>
                                        <th class="center">院名称</th>
                                        <th class="center">${name}</th>
                                    </tr>
                                    </thead>

                                    <thead>
                                    <tr>
                                        <th class="center">专业号号</th>
                                        <th class="center">专业名称</th>
                                        <th class="center">负责人</th>
                                        <th class="center">班级
                                            <table>
                                                <tr>
                                                    <td class="center">班级名称</td>
                                                    <td class="center">班级编号</td>
                                                </tr>
                                            </table>

                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="list">
                                    <tr class="odd gradeX">

                                            <td class="center"> ${list.Dnum}</td>
                                            <td class="center">${list.Dname}</td>
                                            <td class="center">${list.Tname}</td>

                                            <td class="center">

                                                <table>
                                                    <c:forEach items="${dao.charge1(list.Dnum)}" var="list1">
                                                        <tr>
                                                            <td class="center">${list1.Cname}</td>
                                                            <td class="center">${list1.Clnum}</td>

                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                            </td>

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

</div>
</body>

</html>
