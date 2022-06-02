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

@WebServlet(name="ListarServelet", urlPatterns = {"/listar"})
public class ListarServelet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		try {

			ArrayList<Cliente> cl = (ArrayList<Cliente>)req.getSession().getAttribute("cliente");
			ArrayList<Celular> ce = (ArrayList<Celular>)req.getSession().getAttribute("celular");
			
			int n = cl.size();
			int num = ce.size();
			int i = 0;
			int in = 0;
			
				out.print("<html>"
						+ "<head>");
				out.println("<link rel='stylesheet' type='text/css' href='" + req.getContextPath() +  "/listar.css' />");
				out.print("<title>Lista Cadastro</title>");
				out.print("</head><body>");
				out.print("<header><span class=\"title\">Lista de Cadastros</span></header>");
				out.print("<table>");
				out.print(" <tr>");
				out.print(" <th>Nome</th>");
				out.print(" <th>Email</th>");
				out.print(" <th>Cidade</th>");
				out.print(" <th>Telefone</th>");
				out.print(" <th>Acao</th>");
				for(Cliente c: cl) {
					out.print(" <tr>");
					out.print("<td>" + c.nome + "</td>");
					out.print("<td>" + c.email + "</td>");
					out.print("<td>" + c.cidade + "</td>");
					out.print("<td>" + c.telefone + "</td>");
					out.print("<td>"
							+ "<a class=\"editar\" href='editar?i="+ i +"'>Editar<a/> "
							+ "<a class=\"excluir\" href='excluirCliente?i="+ i +"'>Remover<a/>"
							+ "</td>");
					out.print(" <tr>");
					i++;
				}
				out.print("<table>");
				out.print("<span class=\"total\">Total de clientes cadastrados: " + n + "</span>");
				
				out.print("<table>");
				out.print(" <tr>");
				out.print(" <th>Nome</th>");
				out.print(" <th>Marca</th>");
				out.print(" <th>Cor</th>");
				out.print(" <th>Tela</th>");
				out.print(" <th>Memoria</th>");
				out.print(" <th>Preco</th>");
				out.print(" <th>Acao</th>");
				for(Celular celu: ce) {
					out.print(" <tr>");
					out.print("<td>" + celu.nome + "</td>");
					out.print("<td>" + celu.marca + "</td>");
					out.print("<td>" + celu.cor + "</td>");
					out.print("<td>" + celu.tela + "</td>");
					out.print("<td>" + celu.memoria + "</td>");
					out.print("<td>" + celu.preco + "</td>");
					out.print("<td>"
							+ "<a href='editarCelular?in="+ in +"' >Editar<a/> "
							+ "<a class=\"excluir\" href='excluirCelular?in="+ in +"'>Remover<a/>"
							+ "</td>");
					out.print(" <tr>");
					in++;
				}
				out.print("<table>");				
				out.print("</body></html>");
				out.print("<span class=\"total\">Total de celulares cadastrados: " + num + " </span></br>");
				out.print("<a href=\"homePage.html\">Voltar</a>");
				
	
				RequestDispatcher dispatcher = req.getRequestDispatcher("listar");
				req.setAttribute("lista", cl);
				dispatcher.forward(req, resp);

		}catch (Exception e) {
			// TODO: handle exception
			
		}
		
	}
	
}