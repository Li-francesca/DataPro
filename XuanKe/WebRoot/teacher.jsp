<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/1
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
<html>
<head>
    <title>教师基本信息${list}</title>
</head>
<body>
<table>
    <c:forEach items="${list}" var="list">

    <li> ID：${list.Tnum} </li>
    <li> 姓名：${list.t1} </li>
    <li> 性别：${list.Tsex} </li>
    <li> 职称：${list.Title} </li>
    <li> 电话：${list.Tphone} </li>
    <li>  邮件：${list.Email} </li>
    <li>  学院：${list.Aname}${list.Anum}

    </li>
    <a href="academyMessage?idA=${list.Anum}&name=${list.Aname}">点击${list.Tname}</a>
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
    <base href="<%=basePath%>">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>选课系统-教师基本信息界面</title>
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


    <!--  -->
   <%-- <!--左边侧栏  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <a href="index-teacher.html" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>基本信息</a>
                </li>
                <li>
                    <a href="class-teacher.html" class="waves-effect waves-dark"><i class="fa fa-table"></i>课程信息</a>
                </li>
                <li>
                    <a href="/academyMessage?idA=<%=idA%>&name=${list.Aname}">点击${list.Tname}</i>所属信息</a>
                </li>
            </ul>

        </div>

    </nav>--%>
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
                                    <thead>

                                    <tr>
                                        <th class="center">教师编号</th>
                                        <th class="center">教师姓名</th>
                                        <th class="center">性别</th>
                                        <th class="center">职称</th>
                                        <th class="center">电话</th>
                                        <th class="center">邮件</th>
                                        <th class="center">出生年月</th>
                                        <th class="center">院编号</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="list">
                                        <tr class="odd gradeX">

                                            <td class="center">${list.Tnum}</td>
                                            <td class="center">${list.Tname}</td>
                                            <td class="center">${list.Tsex} </td>
                                            <td class="center">${list.Title}</td>
                                            <td class="center">${list.Tphone}</td>
                                            <td class="center">${list.Email}</td>
                                            <td class="center">${list.Tbirth}</td>
                                            <td class="center">${list.Aname}</td>
                                        </tr>
                                        <c:set var="idA" value="${list.Anum}" ></c:set>
                                        <c:set var="name" value="${list.Aname}" ></c:set>
                                        <c:set var="Tnum" value="${list.Tnum}" ></c:set>
                                        <c:set var="Anum" value="${list.Anum}" ></c:set>

                                    </c:forEach>
                                    </tbody>
                                </table>
                                <a href="updateTeacher.jsp?Tnum=${Tnum}"><button style="border:1px solid lightgrey;background-color:white;"> 编辑个人基本信息 </button></a>
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
                    <a href="CourseInfoServlet?flag=kkxx" class="waves-effect waves-dark"><i class="fa fa-table"></i>课程信息</a>
                </li>
                <li>

                    <a href="academyMessage?idA=${idA}&name=${name}&Tnum=${Tnum}&Anum=${Anum}"><i class="fa fa-bar-chart-o"></i>所属信息</a>
                </li>
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

