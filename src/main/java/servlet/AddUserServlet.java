package servlet;

import entity.LibraryUser;
import service.LibraryUserService;
import service.UserRoleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        addUser(request, response);
        response.sendRedirect("/admin");
    }

    @Override protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        addUser(request, response);
        response.sendRedirect("/admin");
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
        LibraryUserService userService = new LibraryUserService();
        UserRoleService roleService = new UserRoleService();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String userRole = request.getParameter("role");
        LibraryUser user = new LibraryUser(firstName, lastName,phoneNumber, address, login, password, email);
        user.setRole(roleService.findByRole(userRole));
        userService.create(user);
    }
}
