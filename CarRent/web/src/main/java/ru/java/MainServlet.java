package ru.java;

import ru.java.service.AutoparkService;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/autopark", "/car"})
public class MainServlet extends HttpServlet {

    private AutoparkService autoparkService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        autoparkService = new AutoparkService();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (id != null) {
            request.setAttribute("car", autoparkService.getCarById(Long.parseLong(id)));
            request.getRequestDispatcher("/car.jsp").forward(request, response);
        }
        else{
            request.setAttribute("cars", autoparkService.getCars());
            request.getRequestDispatcher("/autopark.jsp").forward(request, response);
        }


    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        req.setAttribute("cars", autoparkService.getCars());
//        req.getRequestDispatcher("/autopark.jsp").forward(req, resp);
//
//    }


}
