package com.example.ejbexample;

import java.io.*;

import com.example.ejbexample.beans.WelcomeMsg;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    // Option 1
    //@Inject
    //WelcomeMsg welcomeMsg;

    // Option 2 (if more than one bean implementing the interface)
    @EJB(beanName="WelcomeMsgBean")
    WelcomeMsg welcomeMsg;

    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        message = welcomeMsg.getWelcomeMsg();
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}