package servlet;

import entity.LibraryUser;
import entity.UserRole;
import service.LibraryUserService;
import service.UserRoleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 102831973239L;

    @Override
    public void init() throws ServletException {
        UserRoleService userRoleService = new UserRoleService();
        LibraryUserService libraryUserService = new LibraryUserService();
        if (userRoleService.getAll().isEmpty()) {
            UserRole userRole = new UserRole();
            UserRole adminRole = new UserRole();
            adminRole.setRoleName("admin");
            userRoleService.create(adminRole);

            userRole.setRoleName("user");
            userRoleService.create(userRole);
        }
        if (libraryUserService.getAll().isEmpty()) {
            LibraryUser user1 = new LibraryUser("Oleg", "Petrenko", null,
                    null, "admin", "password", "admin@gmail.com");
            LibraryUser user2 = new LibraryUser("John", "Petrenko", null, null,
                    "user", "password", "user@gmail.com");
            user1.setRole(userRoleService.get(1));
            libraryUserService.create(user1);
            user2.setRole(userRoleService.get(2));
            libraryUserService.create(user2);
        }
    }

    public LoginServlet() {
        super();
    }


    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/");
    }

    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        login(request, response);

    }

    public void login(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setLogin(login);
        libraryUser.setPassword(password);
        LibraryUserService libraryUserService = new LibraryUserService();

        if (libraryUserService.getByLogin(login).getId() == 0
                || !libraryUserService.getByLogin(login).getPassword()
                .equals(password)) {
            PrintWriter out = response.getWriter();
            out.println(
                    "<font color=red>Either user name or password is wrong.</font>");
            RequestDispatcher rd = request.getRequestDispatcher("/");
            rd.include(request, response);
        } else if (libraryUserService
                .getByLogin(login).getRole().getRoleName().equals("admin")) {
            request.getSession().setAttribute("role", "admin");
            response.sendRedirect("/admin");
        } else {
            request.getSession().setAttribute("role", "user");
            response.sendRedirect("/loginSuccess");
        }
    }
}
