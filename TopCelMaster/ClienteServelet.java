package pacote;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="ClienteServelet", urlPatterns = {"/ClienteServelet"})
public class ClienteServelet extends HttpServlet {
	
	ArrayList<Cliente> cl = new ArrayList<>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String cidade = req.getParameter("cidade");
		int telefone = Integer.parseInt(req.getParameter("telefone"));

		Cliente c = new Cliente();
		
		c.setNome(nome);
		c.setEmail(email);
		c.setCidade(cidade);
		c.setTelefone(telefone);
		
		cl.add(c);
		
		req.getSession().setAttribute("cliente", cl);

		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Cadastro Cliente</title>");
		out.println("<link rel='stylesheet' type='text/css' href='" + req.getContextPath() +  "/mensagemCadastro.css' />");
		out.print("</head>");
		out.print("<body>");
		out.print("<div id=" + "popup" + " class="+"popup"+">");
		out.print("<p> Cliente Cadastrado com sucesso </p>");
		out.print("<a href=\"homePage.html\">Voltar</a>");
		out.print("</div>");
		out.print("</body></html>");
		
	}
}
