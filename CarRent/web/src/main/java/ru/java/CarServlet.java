package ru.java;

import ru.java.service.AutoparkService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/car")
public class CarServlet extends HttpServlet {

    private AutoparkService autoparkService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        autoparkService = new AutoparkService();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idx = request.getParameter("id");
        if (idx != null) {
            request.setAttribute("car", autoparkService.getCarById(Long.parseLong(idx)));
            request.getRequestDispatcher("/car.jsp").forward(request, response);
        }
//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//        // получаем параметр id
//        String id = request.getParameter("id");
//
//        try {
//            writer.println("<h2>Id:" + id + "</h2>");
//        } finally {
//            writer.close();
//        }
    }


}
