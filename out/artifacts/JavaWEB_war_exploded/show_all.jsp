<%--
  Created by IntelliJ IDEA.
  User: WwjYt
  Date: 16/3/11
  Time: 下午5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="shop.Customer" %>
<%@ page import="java.util.ArrayList" %>
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
    <%ArrayList<Customer> list = (ArrayList<Customer>)(request.getAttribute("list")); %>
    <h4>查询结果</h4>
    <table border="1">
      <tr align="center">
        <td>id</td>
        <td>姓名</td>
      </tr>
      <%for(int i = 0 ; i<list.size();i++) {
        Customer customer = list.get(i);%>
      <tr align="center" >
        <td><%=customer.getC_id() %></td>
        <td><%=customer.getName() %></td>
      </tr>
      <% } %>
    </table>
  </body>
</html>
