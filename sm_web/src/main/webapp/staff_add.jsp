<%--
  Created by IntelliJ IDEA.
  User: 雨木科技
  Date: 2019/11/6
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>添加</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/thems.css">
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/layui/css/layui.css">--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/laydate.js"></script>
<%--    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layui/layui.js"></script>--%>
    <script type="text/javascript">
        $(function(){
            //自适应屏幕宽度
            window.onresize=function(){ location=location };

            var main_h = $(window).height();
            $('.hy_list').css('height',main_h-45+'px');

            var main_w = $(window).width();
            $('.xjhy').css('width',main_w-40+'px');

        });
    </script>
</head>

<body onload="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">添加员工</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="${pageContext.request.contextPath}/staff/add.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title">姓名：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">性别：</span>
                            <div class="li_r">
                            <span class="radio">
                                <input checked="checked" name="sex" type="radio" value="男">
                                <em>男</em>
                            </span>
                                <span class="radio">
                                <input name="sex" type="radio" value="女">
                                <em>女</em>
                            </span>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">账号：</span>
                            <div class="li_r">
                                <input class="chang" name="account" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">密码：</span>
                            <div class="li_r">
                                <input class="chang" name="password" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">身份证号：</span>
                            <div class="li_r">
                                <input class="chang" name="idNumber" type="text">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">出生日期：</span>
                            <div class="li_r">
                                <input class="chang" name="bornDate" type="text" id="bornDate">
                                <script>
                                    // $(function () {
                                    //     layui.use('laydate', function () {
                                    //         var laydate = layui.laydate;
                                    //
                                    //         laydate.render({
                                    //             elem: '#bornDate',
                                    //             type: 'date'
                                    //         });
                                    //     })
                                    // })
                                    $(function () {
                                        laydate.render({
                                            elem: '#bornDate',
                                            type: 'date'
                                        });
                                    })
                                </script>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">部门：</span>
                            <div class="li_r">
                                <select name="did">
                                    <option value="">-部门-</option>
                                    <c:forEach items="${departments}" var="department">
                                    <option value="${department.id}">${department.name}</option>
                                    </c:forEach>
                                </select>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="tj_btn">
                            <a href="javascript:history.go(-1);" class="back">返回</a>
                            <a href="javascript:addForm.submit();">保存</a>
                        </li>
                    </ul>
                    <!--高级配置-->
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>