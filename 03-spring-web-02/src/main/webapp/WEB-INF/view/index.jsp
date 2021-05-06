<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html >
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>hello mg</title>
    <link href="favicon.ico" rel="shortcut icon">
    <script language="javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="application/javascript">
        $(function () {
            $('#uploadFile').click(function () {
                //异步上传图片
                var formData = new FormData();
                var userdesc = $('#desc').val();
                // 获取第文件的内容
                formData.append("file", $('#files').get(0).files[0]);
                formData.append("desc",userdesc);
                $.ajax({
                    type: "POST",
                    url: "/upload",
                    data: formData,
                    processData: false, //因为data值是FormData对象，不需要对数据做处理。
                    contentType: false,
                    success: function(data){
                        alert( "Data Saved: " + data );
                    }
                });
            });
        });

    </script>
</head>
<body>

<form enctype="multipart/form-data" method="post" action="/upload">

    <div>
        文件:<input type="file" id="files" name="files">
        <br>
        描述:<input name="desc" type="text" id="desc">
        <input type="button"  id="uploadFile" value="上传">
        <%--<button type="submit" value="提交">提交</button>--%>
    </div>
</form>

</body>
</html>
