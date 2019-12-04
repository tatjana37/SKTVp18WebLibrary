/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BookFacade;
import session.HistoryFacade;
import session.ReaderFacade;
/**
 *
 * @author lenovo
 */
@WebServlet(name = "MyServlet", urlPatterns = {
    "/showLogin",
    "/login",
    "/newBook",
    "/addBook",
    "/newReader",
    "/addReader",
    "/listBooks",
    "/listReaders",
    "/showTakeOnBook",
    "/takeOnBook",
    "/showReturnBook",
    "/returnOnBook",
    
    
    
})
public class MyServlet extends HttpServlet {
    @EJB BookFacade bookFacade;
    @EJB ReaderFacade readerFacade;
    @EJB HistoryFacade historyFacade;
    

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
            case "/listBooks":
                List<Book> listBooks = bookFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                request.getRequestDispatcher("/WEB-INF/listBooks.jsp")
                        .forward(request, response);
                break;
            case "/listReaders":
                List<Reader> listReaders = readerFacade.findAll();
                request.setAttribute("listReaders", listReaders);
                request.getRequestDispatcher("/WEB-INF/listReaders.jsp")
                        .forward(request, response);
                break;
            case "/showTakeOnBook":
                listBooks=bookFacade.findAll();
                listReaders=readerFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                request.setAttribute("listReaders", listReaders);
                request.getRequestDispatcher("/WEB-INF/showTakeOnBook.jsp")
                        .forward(request, response);
                break;
                       
                
            case "/takeOnBook":
                String bookId = request.getParameter("bookId");
                String readerId = request.getParameter("readerId");
                book = bookFacade.find(Long.parseLong(bookId));
                reader = readerFacade.find(Long.parseLong(readerId));
                History history = new History();
                history.setBook(book);
                history.setReader(reader);
                history.setTakeOn(new Date());
                historyFacade.create(history);
                request.setAttribute("info",
                        "Книга \""
                        +book.getTitle()
                        +"\" выдана читателю: "
                        +reader.getName()
                        +" "+reader.getLastname()
                );
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
                
            case "/showReturnBook":
                List<History> listHistories = historyFacade.findTookBook();
                request.setAttribute("listHistories", listHistories);
                request.getRequestDispatcher("/WEB-INF/showReturnBook.jsp")
                        .forward(request, response);
                break;
                
            case "/returnOnBook":
                String historyId = request.getParameter("historyId");
                history = historyFacade.find(Long.parseLong(historyId));
                history.setReturnDate(new Date());
                historyFacade.edit(history);
                request.setAttribute("info",
                        "Книга \""
                        +history.getBook().getTitle()
                        +"\" возвращена "
                );
                request.getRequestDispatcher("/showReturnBook")
                        .forward(request, response);
                break;
                
                
                
                
            case "/showLogin":
                request.getRequestDispatcher("/WEB-INF/showLogin.jsp")
                        .forward(request, response);
                break;
            case "/login":
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                if("Tatjana".equals(login) && "Oborina".equals(password)){
                    request.setAttribute("info", "Привет, "+login+"!");
                }else{
                    request.setAttribute("info", "Неправильный логин или пароль!");
                }
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

