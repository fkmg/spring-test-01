<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>系统登录${ctx}</title>
    <link href="${ctx}/static/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx}/static/css/animate.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/style.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/login.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location
        }
    </script>
</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-10">
            <form action="/login" id="login_form" method="post">
                <h4 class="no-margins">登录系统</h4>
                <%--<h4 class="no-margins">用户名或密码错误</h4>--%>
                <input type="text" name="account" class="form-control uname required" placeholder="用户名"/>
                <input type="password" name="password" class="form-control pword required" placeholder="密码"/>
                <button class="btn btn-success btn-block">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy; 2016 All Rights Reserved. ...
        </div>
    </div>
</div>
</body>
<script src="${ctx}/static/plugins/jquery/jquery.min.js?v=2.1.4"></script>
<script src="${ctx}/static/plugins/jquery-validate/jquery.validate.min.js"></script>
<script src="${ctx}/static/plugins/jquery-validate/messages_zh.min.js"></script>
<script>
    $(document).ready(function () {
        $("#login_form").validate();
    });
</script>
</html>