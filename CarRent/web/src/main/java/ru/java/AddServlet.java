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

@WebServlet(urlPatterns = "/addcar")
public class AddServlet extends HttpServlet {
    private AutoparkService autoparkService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        autoparkService = new AutoparkService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        request.getRequestDispatcher("/addcar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String brand = request.getParameter("brand");
        String info = request.getParameter("info");
        String price = request.getParameter("price");
        if (brand != null  && info!=null && price!=null) {
            autoparkService.addCar(brand, info, Integer.parseInt(price));

            request.getRequestDispatcher("/autopark").forward(request, response);
        }
    }
}
