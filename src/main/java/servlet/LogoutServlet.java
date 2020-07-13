package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/logout");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("password");
        session.removeAttribute("login");
        session.removeAttribute("role");
        session.invalidate();
        response.sendRedirect("/");
    }
}
