package ru.java;

import ru.java.service.AutoparkService;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/autopark")
public class MainServlet extends HttpServlet {

    private AutoparkService autoparkService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        autoparkService = new AutoparkService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idx = req.getParameter("idx");
        if (idx != null) {
            req.setAttribute("car", autoparkService.getCarById(Long.parseLong(idx)));
            req.getRequestDispatcher("/car.jsp").forward(req, resp);
        } else {
            req.setAttribute("cars", autoparkService.getCars());
            req.getRequestDispatcher("/autopark.jsp").forward(req, resp);
        }
    }


}
