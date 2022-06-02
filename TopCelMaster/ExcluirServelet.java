package pacote;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="ExcluirServelet", urlPatterns = {"/excluirCelular"})
public class ExcluirServelet extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Celular> ce = (ArrayList<Celular>)req.getSession().getAttribute("celular");
		
		String index = req.getParameter("in");
		int id = Integer.parseInt(index);
	
		ce.remove(id);

		PrintWriter out = resp.getWriter();
		out.print("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='" + req.getContextPath() +  "/mensagem.css' />");
		out.print("<title>Cadastro Celular</title>");
		out.print("</head><body>");
		out.print("<span>Item excluido com sucesso!!</span>");
		out.print("<a href=\"listar\">Voltar</a>");
		out.print("</body></html>");

	}
}
