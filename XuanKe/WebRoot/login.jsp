<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/1
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="/login" method="post">
    学生:<input name="type" value="1" type="radio">
    老师：<input name="type" value="2" type="radio">
    ID：<input type="text" name="id">
    密码：<input type="password" name="psw">
    <input type="submit" value="提交">

</form>

</body>
</html>--%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>东北师范大学用户登录</title>
    <link href="assets/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="assets/js/jQuery1.7.js"></script>
    <script type="text/javascript" src="assets/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="assets/js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="assets/js/jquery.SuperSlide.js"></script>
    <script type="text/javascript" src="assets/js/Validform_v5.3.2_min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            var $tab_li = $('#tab ul li');
            $tab_li.hover(function(){
                $(this).addClass('selected').siblings().removeClass('selected');
                var index = $tab_li.index(this);
                $('div.tab_box > div').eq(index).show().siblings().hide();
            });
        });
    </script>
    <script type="text/javascript">
        $(function(){
            /*学生登录信息验证*/
            $("#stu_username_hide").focus(function(){
                var username = $(this).val();
                if(username=='输入学号'){
                    $(this).val('');
                }
            });
            $("#stu_username_hide").focusout(function(){
                var username = $(this).val();
                if(username==''){
                    $(this).val('输入学号');
                }
            });
            $("#stu_password_hide").focus(function(){
                var username = $(this).val();
                if(username=='输入密码'){
                    $(this).val('');
                }
            });
            $("#stu_password_hide").focusout(function(){
                var username = $(this).val();
                if(username==''){
                    $(this).val('输入密码');
                }
            });
            $("#stu_code_hide").focus(function(){
                var username = $(this).val();
                if(username=='输入验证码'){
                    $(this).val('');
                }
            });
            $("#stu_code_hide").focusout(function(){
                var username = $(this).val();
                if(username==''){
                    $(this).val('输入验证码');
                }
            });
            $(".stu_login_error").Validform({
                tiptype:function(msg,o,cssctl){
                    var objtip=$(".stu_error_box");
                    cssctl(objtip,o.type);
                    objtip.text(msg);
                },
                ajaxPost:true
            });
            /*导师登录信息验证*/
            $("#tea_username_hide").focus(function(){
                var username = $(this).val();
                if(username=='输入教工号'){
                    $(this).val('');
                }
            });
            $("#tea_username_hide").focusout(function(){
                var username = $(this).val();
                if(username==''){
                    $(this).val('输入教工号');
                }
            });
            $("#tea_password_hide").focus(function(){
                var username = $(this).val();
                if(username=='输入密码'){
                    $(this).val('');
                }
            });
            $("#tea_password_hide").focusout(function(){
                var username = $(this).val();
                if(username==''){
                    $(this).val('输入密码');
                }
            });
            $("#tea_code_hide").focus(function(){
                var username = $(this).val();
                if(username=='输入验证码'){
                    $(this).val('');
                }
            });
            $("#tea_code_hide").focusout(function(){
                var username = $(this).val();
                if(username==''){
                    $(this).val('输入验证码');
                }
            });
           /* $(".tea_login_error").Validform({
                tiptype:function(msg,o,cssctl){
                    var objtip=$(".tea_error_box");
                    cssctl(objtip,o.type);
                    objtip.text(msg);
                },
                ajaxPost:true
            });*/
        });
    </script>
    <script type="text/javascript">
        $(function(){
            $(".screenbg ul li").each(function(){
                $(this).css("opacity","0");
            });
            $(".screenbg ul li:first").css("opacity","1");
            var index = 0;
            var t;
            var li = $(".screenbg ul li");
            var number = li.size();
            function change(index){
                li.css("visibility","visible");
                li.eq(index).siblings().animate({opacity:0},3000);
                li.eq(index).animate({opacity:1},3000);
            }
            function show(){
                index = index + 1;
                if(index<=number-1){
                    change(index);
                }else{
                    index = 0;
                    change(index);
                }
            }
            t = setInterval(show,8000);
            //根据窗口宽度生成图片宽度
            var width = $(window).width();
            $(".screenbg ul img").css("width",width+"px");
        });
    </script>
</head>

<body>
<div id="tab">
    <ul class="tab_menu">
        <li class="selected">学生登录</li>
        <li>导师登录</li>
    </ul>
    <div class="tab_box">
        <!-- 学生登录开始 -->
        <div>
            <div class="stu_error_box"></div>
            <form action="login?type=1" method="post" >
                <div id="username" >
                    <label>学&nbsp;&nbsp;&nbsp;号：</label>
                    <input type="text" id="stu_username_hide" name="id" value="输入学号" nullmsg="学号不能为空！" datatype="s6-18" errormsg="学号范围在6~18个字符之间！" sucmsg="学号验证通过！"/>
                    <!--ajaxurl="demo/valid.jsp"-->
                </div>
                <div id="password">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" id="stu_password_hide" name="psw"  nullmsg="密码不能为空！" datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
                </div>
         
                <div id="remember">
                    <input type="checkbox" name="remember">
                    <label>记住密码</label>
                </div>
                <div id="login">
                    <button type="submit">登录</button>
                </div>
            </form>
        </div>
        <!-- 学生登录结束-->
        <!-- 导师登录开始-->
        <div class="hide">
            <div class="tea_error_box"></div>
            <form action="login?type=2" method="post" class="tea_login_error">
                <div id="username">
                    <label>教工号：</label>
                    <input type="text" id="tea_username_hide" name="id" value="输入教工号" nullmsg="教工号不能为空！" datatype="s6-18" errormsg="教工号范围在6~18个字符之间！" sucmsg="教工号验证通过！"/>
                    <!--ajaxurl="demo/valid.jsp"-->
                </div>
                <div id="password">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" id="tea_password_hide" name="psw"  nullmsg="密码不能为空！" datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
                </div>
                <!--         <div id="code">
                          <label>验证码：</label>
                          <input type="text" id="tea_code_hide" name="code"  value="输入验证码" nullmsg="验证码不能为空！" datatype="*4-4" errormsg="验证码有4位数！" sucmsg="验证码验证通过！"/>
                          <img src="assets/images/captcha.jpg" title="点击更换" alt="验证码占位图"/> </div> -->
                <div id="remember">
                    <input type="checkbox" name="remember">
                    <label>记住密码</label>
                </div>
                <div id="login">
                    <button type="submit">登录</button>
                </div>
            </form>
        </div>
        <!-- 导师登录结束-->
    </div>
</div>
<div class="screenbg">
    <ul>
        <li><a href="javascript:;"><img src="assets/images/002.jpg"></a></li>
        <li><a href="javascript:;"><img src="assets/images/003.jpg"></a></li>
        <li><a href="javascript:;"><img src="assets/images/001.jpg"></a></li>
    </ul>
</div>
</body>
</html>





