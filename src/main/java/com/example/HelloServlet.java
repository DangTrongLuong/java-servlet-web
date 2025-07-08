package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>Hello, World, I am a servlet, chú ý nhánh của dangluong-08/07/2025!</h1>");
        out.println("<p>Alo alo</p>");
        out.println("<a href='http://localhost:8082/java-servlet-web-1.0-SNAPSHOT/'><button>Back to Home</button></a>");
    }
}