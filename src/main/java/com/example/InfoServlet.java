package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {
    private static List<String> members = new ArrayList<>();
    
    static {
        members.add("DangTrongLuong - MSSV: BIT230250");
        members.add("PhamMinhDan - MSSV: BIT230074");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<h2>Thông tin nhóm:</h2>");
        out.println("<ul>");
        for (String member : members) {
            out.println("<li>" + member + "</li>");
        }
        out.println("</ul>");
        
        out.println("<h3>Thêm thành viên mới:</h3>");
        out.println("<form method='post' action='/java-servlet-web-1.0-SNAPSHOT/info'>");
        out.println("<label for='name'>Tên:</label>");
        out.println("<input type='text' id='name' name='name' required>");
        out.println("<label for='mssv'>MSSV:</label>");
        out.println("<input type='text' id='mssv' name='mssv' required>");
        out.println("<input type='submit' value='Thêm'>");
        out.println("</form>");
        
        out.println("<a href='http://localhost:8082/java-servlet-web-1.0-SNAPSHOT/'><button>Back to Index</button></a>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String mssv = request.getParameter("mssv");
        
        if (name != null && mssv != null && !name.trim().isEmpty() && !mssv.trim().isEmpty()) {
            members.add(name + " - MSSV: " + mssv);
        }
        
        response.sendRedirect("/java-servlet-web-1.0-SNAPSHOT/info");
    }
}