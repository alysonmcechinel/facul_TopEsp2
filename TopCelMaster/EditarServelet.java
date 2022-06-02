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

@WebServlet(name="EditarServelet", urlPatterns = {"/editar"})
public class EditarServelet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		
		ArrayList<Cliente> cl = (ArrayList<Cliente>)req.getSession().getAttribute("cliente");
	
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String cidade = req.getParameter("cidade");
		int telefone = Integer.parseInt(req.getParameter("telefone"));

		Cliente c = new Cliente();
		String index = req.getParameter("i");
		int id = Integer.parseInt(index);
		
		c.setNome(nome);
		c.setEmail(email);
		c.setCidade(cidade);
		c.setTelefone(telefone);
		
		cl.set(id, c);
		
		PrintWriter out = resp.getWriter();
		out.print("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='" + req.getContextPath() +  "/mensagem.css'/>");
		out.print("<title>Cadastro Cliente</title>");
		out.print("</head><body>");
		out.print("<span>Item editado com sucesso!!</span>");
		out.print("<a href=\"listar\">Voltar</a>");
		out.print("</body></html>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<Cliente> cl = (ArrayList<Cliente>)req.getSession().getAttribute("cliente");	
		
		PrintWriter out = resp.getWriter();
		try {
		
			Cliente cli = new Cliente();
			String index = req.getParameter("i");
			int id = Integer.parseInt(index);
		
			if (index!=null && index!="") {
				int i = Integer.parseInt(index);
				cli = cl.get(i);
			}

			out.print("<html><head>");
			out.println("<link rel='stylesheet' type='text/css' href='" + req.getContextPath() +  "/cadastroCliente.css' />");
			out.print("<title>Editar Cadastro</title>");
			out.print("</head>"
					+ "<body>");
			out.print("<header>"
					+ "<span class=\"title\">Editar Clientes</span>"
					+ "</header>");
			
			out.print("<form action=\"editar?i="+ index +"\" method=\"post\">");
			
			out.print("<div class="+"div-form"+">");
			
			out.print("<div>");
			out.print("Nome:"
					+ "<br/>"
					+ "<input type=\"text\" name=\"nome\" required value="+ cli.getNome()+">"
					+ "<br/>");		
			
			
			out.print("Email: <br/><input type=\"text\" name=\"email\" required value="+ cli.getEmail()+"> <br/>");
			out.print("</div>");
			
			out.print("<div>");
			out.print("Cidade: <br/><input type=\"text\" name=\"cidade\" required value="+ cli.getCidade()+"> <br/>");
					
			
			out.print("Telefone: <br/><input type=\"text\" name=\"telefone\" required value="+ cli.getTelefone()+"> <br/>");
			out.print("</div>");
			
			out.print("</div>");
			
			out.print("<div class=" + "div-button" + ">");
			out.print("<button type=\"submit\">Salvar</button>");
			out.print("<a href=\"listar\">Voltar</a>");
			out.print("</div>");
			
			out.print("</form>");
			out.print("</body>"
					+ "</html>");
		
			cl.set(id, cli);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			out.println("Nullo");
		}
		
	}
	
}