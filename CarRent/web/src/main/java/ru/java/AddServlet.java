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

@WebServlet(urlPatterns = {"/addcar", "/altercar", "/deletecar"})
public class AddServlet extends HttpServlet {
    private AutoparkService autoparkService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        autoparkService = new AutoparkService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        String id = request.getParameter("id");
        if(id!=null && request.getServletPath().equals("/deletecar")){
            autoparkService.removeCarByID(Long.parseLong(id));
            String path = request.getContextPath() + "/autopark";
            response.sendRedirect(path);
        }
        else if(id!=null && request.getServletPath().equals("/altercar")){
            request.getRequestDispatcher("/altercar.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/addcar.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String brand = request.getParameter("brand");
        String info = request.getParameter("info");
        String price = request.getParameter("price");
        String id = request.getParameter("id");
        String isAvailable = request.getParameter("availability");
        if(id!=null){
            autoparkService.updateCar(Long.parseLong(id), brand, info, Integer.parseInt(price), Boolean.getBoolean(isAvailable));
            //send redirect
            String path = request.getContextPath() + "/autopark";
            response.sendRedirect(path);
        }
        else{
            autoparkService.addCar(brand, info, Integer.parseInt(price));
            //send redirect
            String path = request.getContextPath() + "/autopark";
            response.sendRedirect(path);
        }


    }
}
