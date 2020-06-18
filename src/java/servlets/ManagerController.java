/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.BookFacade;
import session.HistoryFacade;
import session.ReaderFacade;
import session.UserFacade;
import session.UserRolesFacade;
import utils.EncryptPass;

/**
 *
 * @author user
 */
@WebServlet(name = "ManagerController", urlPatterns = {
    
    "/newBook",
    "/addBook",
   
    
    
})
public class ManagerController extends HttpServlet {
@EJB BookFacade bookFacade;
@EJB ReaderFacade readerFacade;
@EJB HistoryFacade historyFacade;
@EJB UserFacade userFacade;
@EJB UserRolesFacade userRolesFacade;
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
        request.setCharacterEncoding("UTF-8");
        //Защита ресурсов
        HttpSession session = request.getSession(false);
        if(session == null){
            request.setAttribute("info", "У вас нет прав, войдите");
            request.getRequestDispatcher("/WEB-INF/showLogin.jsp")
                        .forward(request, response);
            return;    
        }
        User user = (User) session.getAttribute("user");
        if(user == null){
            request.setAttribute("info", "У вас нет прав, войдите");
            request.getRequestDispatcher("/WEB-INF/showLogin.jsp")
                        .forward(request, response);
            return;   
        }
        boolean isRole = userRolesFacade.isRole("MANAGER",user);
        if(!isRole){
            request.setAttribute("info", "У вас нет прав, войдите");
            request.getRequestDispatcher("/WEB-INF/showLogin.jsp")
                        .forward(request, response);
            return;   
        }
        String path = request.getServletPath();
        switch (path) {
            case "/newBook":
                request.getRequestDispatcher("/WEB-INF/newBook.jsp")
                        .forward(request, response);
                break;
            case "/addBook":
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                String year = request.getParameter("year");
                String quantity = request.getParameter("quantity");
                Book book = new Book(title, author, Integer.parseInt(year), Integer.parseInt(quantity));
                bookFacade.create(book);
                request.setAttribute("info", "Книга создана");
                request.setAttribute("book", book);
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
            
            
        }
        
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

