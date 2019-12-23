package ru.java;

import ru.java.service.ContractService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addcontract","/contracts", "/approvecontract"})
public class ContractServlet extends HttpServlet {
    private ContractService contractService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        contractService = new ContractService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        String carid = request.getParameter("carid");
        String id = request.getParameter("id");
        if(carid!=null && request.getServletPath().equals("/addcontract")) {
            request.getRequestDispatcher("/addcontract.jsp").forward(request, response);
        }

        else if(id!=null && request.getServletPath().equals("/approvecontract")){
            contractService.approveContract(Long.parseLong(id), (long)1);
            String path = request.getContextPath() + "/contracts";
            response.sendRedirect(path);
        }
        else {
            request.setAttribute("contracts", contractService.getContracts());
            request.getRequestDispatcher("/contracts.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String carid = request.getParameter("carid");
//        String clientid = request.getParameter("id");
//        String isAvailable = request.getParameter("availability");

            contractService.addContract(start, end, (long)1, Long.parseLong(carid));
            //send redirect
            String path = request.getContextPath() + "/contracts";
            response.sendRedirect(path);
        }




}
