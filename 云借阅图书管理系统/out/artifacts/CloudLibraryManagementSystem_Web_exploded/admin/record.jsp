<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="content-type" content="text/JavaScript;charset=utf-8"/>
    <title>云借阅-图书管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pagination.css">
    <script charset="utf-8" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script charset="utf-8" type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script charset="utf-8" type="text/javascript" src="${pageContext.request.contextPath}/js/pagination.js"></script>
    <script charset="utf-8" type="text/javascript" src="${pageContext.request.contextPath}/js/my.js"></script>
    <link rel="icon" type="image/x-ico" href="${pageContext.request.contextPath}/img/logo.jpg"/>

</head>

<body class="hold-transition skin-red sidebar-mini">
<!-- .box-body -->
<div class="box-header with-border">
    <h3 class="box-title">借阅记录</h3>
</div>
<div class="box-body">
    <!--工具栏 数据搜索 -->
    <div class="box-tools pull-right">
        <div class="has-feedback">
            <form action="${pageContext.request.contextPath}/record/searchRecords" method="post">
                <c:if test="${user_session.role =='ADMIN'}">
                    借阅人：<input name="bookBorrower" value="${search.bookBorrower}">&nbsp&nbsp&nbsp&nbsp
                </c:if>
                图书名称：<input name="bookName" value="${search.bookName}">&nbsp&nbsp&nbsp&nbsp
                <button class="btn btn-default" type="submit">查询</button>
            </form>
        </div>
    </div>
    <!--工具栏 数据搜索 /-->
    <!-- 数据列表 -->
    <div class="table-box">
        <!--数据表格-->
        <table id="dataList" class="table table-bordered table-striped table-hover dataTable text-center">
            <thead>
            <tr>
                <th class="sorting">借阅人</th>
                <th class="sorting_asc">图书名称</th>
                <th class="sorting">标准ISBN</th>
                <th class="sorting">借阅时间</th>
                <th class="sorting">归还时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageResult.rows}" var="record">
                <tr>
                    <td>${record.bookBorrower}</td>
                    <td>${record.bookName}</td>
                    <td>${record.bookIsbn}</td>
                    <td>${record.borrowTime}</td>
                    <td>${record.remandTime}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <!--数据表格/-->
        <%--分页插件--%>
        <div id="pagination" class="pagination"></div>
    </div>
    <!-- 数据列表 /-->
</div>
<!-- /.box-body -->
</body>
<script>
    /*分页插件展示的总页数*/
    pageargs.total = Math.ceil(${pageResult.total}/pageargs.pagesize);
    /*分页插件当前的页码*/
    pageargs.cur = ${pageNum}
        /*分页插件页码变化时将跳转到的服务器端的路径*/
        pageargs.gourl = "${gourl}"
    /*保存搜索框中的搜索条件，页码变化时携带之前的搜索条件*/
    recordVO.bookName = "${search.bookName}"
    recordVO.bookBorrower = "${search.bookBorrower}"
    /*分页效果*/
    pagination(pageargs);
</script>
</html>