package com.chanjet.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by admin on 2016/5/9.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        Enumeration<String>  enu= request.getParameterNames();
        while (enu.hasMoreElements()){
            String paramName = enu.nextElement();
            System.out.println(paramName+"="+request.getParameter(paramName));
        }

        response.getWriter().print("<info>");
        response.getWriter().print("<url>www.chanjet.com</url>");
        response.getWriter().print("</info>");
    }
}
