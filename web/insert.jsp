<%--
  Created by IntelliJ IDEA.
  User: WwjYt
  Date: 16/3/11
  Time: 下午5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <a href="/insert.jsp">增</a> 增加新顾客</p>
    <a href="/delete.jsp">删</a> 删除老顾客</p>
    <a href="/update.jsp">改</a> 更改顾客名(搜id改name)</p>
    <a href="/select.jsp">查</a> 查询某用户</p>
    </h4 增加用户页面 />
    <form action="insert.do"  method="post">      <!--所提交的表单，action为"login.do"，发出请求是post-->
      <p>用户id:<input type="text" name="id" /></p>
      <p>用户姓名:<input type="text" name="name" /></p>
      <p><input type="submit" value="添加"> </p>
    </form>
  </body>
</html>
