package servlet;

import entity.LibraryUser;
import service.LibraryUserService;
import service.UserRoleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditUserServlet extends HttpServlet {
    private LibraryUserService userService;
    private UserRoleService roleService;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        updateUser(request, response);
        response.sendRedirect("/admin");
    }

    void updateUser(HttpServletRequest request, HttpServletResponse response) {

        LibraryUserService userService = new LibraryUserService();
        UserRoleService roleService = new UserRoleService();

        Long id = Long.valueOf(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String role = request.getParameter("role");

        LibraryUser user = userService.get(id);
        user.setId(id);
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        if (role.equals("admin")){
            user.setRole(roleService.get(1L));
        } else {
            user.setRole(roleService.get(2L));
        }
        userService.update(user);
    }
}
