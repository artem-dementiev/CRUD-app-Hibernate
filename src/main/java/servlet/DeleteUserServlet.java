package servlet;

import entity.LibraryUser;
import service.LibraryUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        delete(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        delete(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LibraryUserService userService = new LibraryUserService();
        LibraryUser user = userService.get(Long.parseLong(request.getParameter("id")));
        userService.delete(user);
        response.sendRedirect("/admin");
    }
}