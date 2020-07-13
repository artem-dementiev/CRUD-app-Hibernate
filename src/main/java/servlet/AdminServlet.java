package servlet;

import entity.LibraryUser;
import service.LibraryUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//@WebServlet({"/admin"})
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LibraryUserService libraryUserService = new LibraryUserService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final HttpSession session = request.getSession();
        if (session.getAttribute("role").equals("user")) {
            response.sendRedirect("/loginSuccess");
        } else if (session.getAttribute("role").equals("admin")) {
            List list = libraryUserService.getAll();
            request.setAttribute("users", list);
            RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
            rd.include(request, response);
        } else {
            response.sendRedirect("/");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
   /* public void init() {

*//*
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        bookDAO = new BookDAO(jdbcURL, jdbcUsername, jdbcPassword);
*//*

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<LibraryUser> listUser = libraryUserService.getAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
        case "/new":
            showNewForm(request, response);
            break;
        case "/insert":
            insertUser(request, response);
            break;
        case "/delete":
            deleteUser(request, response);
            break;
        case "/edit":
            showEditForm(request, response);
            break;
        case "/update":
            updateUser(request, response);
            break;
        default:
            showNewForm(request, response);
            break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<LibraryUser> listUser = libraryUserService.getAll();
        for (LibraryUser l : listUser) {
            System.out.println(l.getFirstName());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        LibraryUser existingBook = libraryUserService.get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        request.setAttribute("user", existingBook);
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        LibraryUser newUser = new LibraryUser(firstName, lastName, phone, address, login, password, email);
        libraryUserService.create(newUser);
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        LibraryUser newUser = new LibraryUser(firstName, lastName, phone, address, login, password, email);
        libraryUserService.update(newUser);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        LibraryUser libraryUser = libraryUserService.get(id);
        libraryUserService.delete(libraryUser);
        response.sendRedirect("list");
    }*/
}
