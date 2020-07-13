package filter;

import entity.LibraryUser;
import entity.UserRole;
import service.LibraryUserService;
import service.UserRoleService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override public void init(FilterConfig filterConfig)
            throws ServletException {
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

    @Override
    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");
        final HttpSession session = request.getSession();
        LibraryUserService libraryUserService = new LibraryUserService();
        final String role = libraryUserService.getByLogin(login).getRole().getRoleName();

        if (role.equals("admin")) {
            request.getRequestDispatcher("/admin").forward(request, response);
        } else if (role.equals("user")) {
            request.getRequestDispatcher("/loginSuccess")
                    .forward(request, response);
        } else {
            request.getRequestDispatcher("/").forward(request,response);
        }
//        if (session != null && session.getAttribute(login) != null
//                && session.getAttribute(password) != null) {
//            final String role = (String) session.getAttribute("role");
//
//            move(request, response, role);
//
//        } else if (libraryUserService.isExist(login) && libraryUserService
//                .getByLogin(login).getPassword().equals(password)) {
//
//            final String role = libraryUserService.getByLogin(login).getRole()
//                    .getRoleName();
//
//            request.getSession().setAttribute("login", login);
//            request.getSession().setAttribute("password", password);
//            request.getSession().setAttribute("role", role);
//
//            move(request, response, role);
//        } else {
//            String role = "unknown";
//            request.getSession().setAttribute("role", role);
//            move(request, response, role);
//        }
    }
}
