package MyMVC;

import jdbc.Jdbc;
import shop.Customer;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "insertServlet")
public class insertServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String s_id = request.getParameter("id");
        int id = Integer.valueOf(s_id).intValue();
        String name=request.getParameter("name");
        Jdbc.insert(new Customer(id,name));
        response.sendRedirect("success.jsp");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
