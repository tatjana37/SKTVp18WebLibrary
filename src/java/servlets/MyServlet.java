/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author lenovo
 */
@WebServlet(name = "MyServlet", urlPatterns = {
    "/page1", 
    "/page2", 
    "/page3",
    "/page4",
    
})
public class MyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        
        switch (path) {
            case "/page1":
                String info = "Привет из сервлета";
                request.setAttribute(info, "info");
                
                request.getRequestDispatcher("/WEB-INF/page1.jsp").forward(request, response);
                break;
            case "/page2":
                String name = request.getParameter("name");
                String lastname = request.getParameter("lastname");
                info = "Привет из сервлета";
                request.setAttribute("info", info);
                request.setAttribute("page", name + " " + lastname);
                request.getRequestDispatcher("/WEB-INF/page2.jsp").forward(request, response);
                break;
            case "/page3":
                info = "Привет из сервлета";
                request.setAttribute(info, "info");
                request.getRequestDispatcher("/WEB-INF/page3.jsp").forward(request, response);
                break;
            case "/page4":
                info = "Привет из сервлета";
                request.setAttribute("info", info);
                request.getRequestDispatcher("/WEB-INF/page4.jsp").forward(request, response);
                break;
            
        }
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
