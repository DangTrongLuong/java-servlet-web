package com;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.mockito.Mockito;

import com.example.InfoServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoServletTest {

    @Test
    public void testDoGet() throws Exception {
        // Mock Servlet objects
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Mock PrintWriter to capture output
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(writer);

        // Create and call doGet
        InfoServlet servlet = new InfoServlet();
        servlet.doGet(request, response);

        // Verify behavior
        Mockito.verify(response).setContentType("text/html");

        // Check output content
        writer.flush();
        String output = stringWriter.toString();
        assertTrue(output.contains("<h2>Thông tin nhóm:</h2>"),
                "Output does not contain group info heading");
        assertTrue(output.contains("<li>DaoQuyNam - MSSV: BIT230074</li>"),
                "Output does not contain second member");
        assertTrue(output.contains("<form method='post' action='/java-servlet-web-1.0-SNAPSHOT/info'>"),
                "Output does not contain form");
        assertTrue(output.contains("<a href='http://localhost:8082/java-servlet-web-1.0-SNAPSHOT/'><button>Back to Index</button></a>"),
                "Output does not contain back button");
    }

    @Test
    public void testDoPost() throws Exception {
        // Mock Servlet objects
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Mock request parameters
        Mockito.when(request.getParameter("name")).thenReturn("NguyenVanA");
        Mockito.when(request.getParameter("mssv")).thenReturn("BIT230999");

        // Create and call doPost
        InfoServlet servlet = new InfoServlet();
        servlet.doPost(request, response);

        // Verify redirect
        Mockito.verify(response).sendRedirect("/java-servlet-web-1.0-SNAPSHOT/info");
    }
}