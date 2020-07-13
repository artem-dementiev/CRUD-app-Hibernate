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
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        registration(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/registration");
    }

    private void registration(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        PrintWriter out = response.getWriter();

        LibraryUserService libraryUser = new LibraryUserService();
        LibraryUser user = new LibraryUser(firstName, lastName, phone, address,
                login, password, email);
        user.setRole(new UserRoleService().get(2));

        boolean isExist = libraryUser.isExist(login);
        if (isExist) {
            RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
            out.println("<font color=red>User with login " + login
                    + " already exist.</font>");
            rd.include(request, response);
        } else {
            libraryUser.create(user);
            out.println("<font color=green>User registered successfully!</font>");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
            //response.sendRedirect("/");
        }
    }
}
