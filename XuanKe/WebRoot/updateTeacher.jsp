<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/2
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>教师修改信息界面</title>
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
                    <a href="index-teacher.html" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>基本信息</a>
                </li>
                <li>
                    <a href="class-teacher.html" class="waves-effect waves-dark"><i class="fa fa-table"></i>课程信息</a>
                </li>
                <li>
                    <a href="belong-message.html" class="waves-effect waves-dark"><i class="fa fa-bar-chart-o"></i>所属信息</a>
                </li>
            </ul>

        </div>

    </nav>
    <!-- 右侧界面  -->
    <div id="page-wrapper" >
        <div class="header">
            <h1 class="page-header">
                修改信息
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
                                    <tr>
                                        <td align="center">

                                            <form action="updateT" method="post" name="myform">
                                            <table border="0" cellpadding="2" cellspacing="1" bgcolor="lightblue" class="table1">
                                                <tr>
                                                    <td colspan="2"><div align="center"  style="font-size:20px"><strong>修改个人信息</strong></div></td>
                                                </tr>
                                                <tr>
                                                    <td><div align="center"  style="font-size:18px">教师编号：</div></td>
                                                    <td><input name="Tnum" type="text" readonly id="ClassId" value=<%=request.getParameter("Tnum")%> size="60" class="input_text"></td>
                                                </tr>
                                                <tr>
                                                    <td><div align="center"  style="font-size:18px">教师姓名：</div></td>
                                                    <td><input name="Tname" type="text" value="" size="60" class="input_text"></td>
                                                </tr>
                                                <tr>
                                                    <td><div align="center"  style="font-size:18px">性别：</div></td>
                                                    <td><input name="Tsex" type="text" value="" size="60" class="input_text"></td>
                                                </tr>
                                                <tr>
                                                    <td><div align="center"  style="font-size:18px">职称：</div></td>
                                                    <td><input name="Title" type="text" value="" size="60"  class="input_text"></td>
                                                </tr>
                                                <tr>
                                                    <td><div align="center"  style="font-size:18px">电话：</div></td>
                                                    <td><input name="Tphone" type="text" value="" size="60"  class="input_text"></td>
                                                </tr>
                                                <tr>
                                                    <td><div align="center"  style="font-size:18px">邮件：</div></td>
                                                    <td><input name="Email" type="text" value="" size="60"  class="input_text"></td>
                                                </tr>
                                                <tr>
                                                    <td><div align="center"  style="font-size:18px">出生年月：</div></td>
                                                    <td><input name="Tbirth" type="text" value="" size="60"  class="input_text"></td>
                                                </tr>
                                                <tr>
                                                    <td><div align="center"  style="font-size:18px">密码：</div></td>
                                                    <td><input name="psw" type="text" value="" size="60"  class="input_text"></td>
                                                </tr>
                                                <!-- <tr style="margin-left: 40%;">
                                                    <td colspan=3 align="center"></td>
                                                </tr> -->
                                                <tr>

                                                </tr>
                                            </table>

                                        </td>
                                    </tr>
                                </table>
                                <div>
                                    <input type="submit" name="b1" value="提交" style="margin-left: 45%;border:1px solid lightgrey;background-color:white;" class="button" />
                                    <input type="reset" name="b2" value="重填" style="border:1px solid lightgrey;background-color:white;" class="button"/>
                                    <a href="index.html">返回</a>
                                </div>
                            </div>
                            </form>
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

