/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Book;
import entity.Reader;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BookFacade;
import session.ReaderFacade;
/**
 *
 * @author lenovo
 */
@WebServlet(name = "MyServlet", urlPatterns = {
    "/login",
    "/page1", 
    "/page2", 
    "/page3",
    "/page4",
    "/hello",
    "/newBook",
    "/addBook",
    "/newReader",
    "/addReader",
    
    
    
})
public class MyServlet extends HttpServlet {
    @EJB BookFacade bookFacade;
    @EJB ReaderFacade readerFacade;

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
                String quentity = request.getParameter("quentity");
                Book book = new Book (title, author, Integer.parseInt(year), Integer.parseInt(quentity));
                bookFacade.create(book);
                request.setAttribute("info", "Книга создана");
                request.getRequestDispatcher("/WEB-INF/newBook.jsp")
                        .forward(request, response);
                break;
                
            case "/newReader":
                request.getRequestDispatcher("/WEB-INF/newReader.jsp")
                        .forward(request, response);
                break;
                
            case "/addReader":
                String name = request.getParameter("name");
                String lastname = request.getParameter("lastname");
                String email = request.getParameter("email");
                Reader reader = new Reader (name, lastname, email);
                readerFacade.create(reader);
                request.setAttribute("info", "Читатель добавлен в базу данных");
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
                 
            case "/login":
                String login = request.getParameter("login");
                String passvord = request.getParameter("passvord");
               if("Tatjana".equals(login) && "Oborina".equals(passvord)){
                    request.setAttribute("info", "Привет "+login+"!");
                }else{
                    request.setAttribute("info", "неправильный логин или пароль");
                }
                
                break;
                
            case "/page1":
                String info = "Привет из сервлета";
                request.setAttribute(info, "info");
                request.getRequestDispatcher("/WEB-INF/page1.jsp").forward(request, response);
                break;
            
            case "/page3":
                info = "Привет из сервлета";
                request.setAttribute(info, "info");
                request.getRequestDispatcher("/WEB-INF/page3.jsp").forward(request, response);
                break;
            case "/page4":
                info = "Привет из сервлета";
                request.setAttribute("info", info);
                request.getRequestDispatcher("/page4.jsp").forward(request, response);
                break;
            case "/hello":
                 name = request.getParameter("name");
                 lastname = request.getParameter("lastname");
                 request.setAttribute("info", "Привет "+name+" "+ lastname);
                 request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                
                break;
                
                
            
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**

     * Handles the HTTP <code>GET</code> method.

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

