import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastro")
public class cadastro extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        if (name.equals("") || age.equals("") || address.equals("")) {
            resp.setContentType("text/html");
            resp.getWriter().println("<h3>Dados obrigatórios não preenchidos</h3>");
        } else {
            req.setAttribute("name", name);
            req.setAttribute("age", age);
            req.setAttribute("address", address);
            RequestDispatcher rd = req.getRequestDispatcher("data.jsp");
            rd.forward(req, resp);
        }

    }
}
