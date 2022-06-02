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

@WebServlet(name="EditarCelularServelet", urlPatterns = {"/editarCelular"})
public class EditarCelularServelet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		
		ArrayList<Celular> ce = (ArrayList<Celular>)req.getSession().getAttribute("celular");
	
		String nome = req.getParameter("nome");
		String marca = req.getParameter("marca");
		String cor = req.getParameter("cor");
		String tela = req.getParameter("tela");
		String memoria = req.getParameter("memoria");
		String preco = req.getParameter("preco");

		Celular c = new Celular();
		String index = req.getParameter("in");
		int id = Integer.parseInt(index);
		
		c.setNome(nome);
		c.setMarca(marca);
		c.setCor(cor);
		c.setTela(tela);
		c.setMemoria(memoria);
		c.setPreco(preco);
		
		ce.set(id, c);
		
		PrintWriter out = resp.getWriter();
		out.print("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='" + req.getContextPath() +  "/mensagem.css' />");
		out.print("<title>Editar Celular</title>");
		out.print("</head><body>");
		out.print("<span>Item editado com sucesso!!</span>");
		out.print("<a href=\"listar\">Voltar</a>");
		out.print("</body></html>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<Celular> ce = (ArrayList<Celular>)req.getSession().getAttribute("celular");	
		
		PrintWriter out = resp.getWriter();
		try {
		
			Celular c = new Celular();
			String index = req.getParameter("in");
			int id = Integer.parseInt(index);
		
			if (index!=null && index!="") {
				int i = Integer.parseInt(index);
				c = ce.get(i);
			}

			out.print("<html><head>");
			out.println("<link rel='stylesheet' type='text/css' href='" + req.getContextPath() +  "/cadastroCelular.css' />");
			out.print("<title>Editar Cadastro</title>");
			out.print("</head>"
					+ "<body>");
			
			out.print("<header>"
					+ "<span class=\"title\">Editar Celular</span>"
					+ "</header>");
			
			out.print("<form action=\"editarCelular?in="+ index +"\" method=\"post\">");
			
			out.print("<div class=\"div-form\">");
			
			out.print("<div>");
			out.print("Nome:<br/><input type=\"text\" name=\"nome\" required value="+ c.getNome()+"><br/>");
			out.print("Marca: <br/><input type=\"text\" name=\"marca\" required value="+ c.getMarca()+"> <br/>");
			out.print("</div>");
			
			out.print("<div>");
			out.print("Cor: <br/><input type=\"text\" name=\"cor\" required value="+ c.getCor()+"> <br/>");
			out.print("tela: <br/><input type=\"text\" name=\"tela\" required value="+ c.getTela()+"> <br/>");
			out.print("</div>");
			
			out.print("<div>");
			out.print("Memoria RAM: <br/><input type=\"text\" name=\"memoria\" required value="+ c.getMemoria()+"> <br/>");
			out.print("Preco: <br/><input type=\"text\" name=\"preco\" required value="+ c.getPreco()+"> <br/>");
			out.print("</div>");			
			
			out.print("</div>");
			
			out.print("<div class=\"div-button\">");
			out.print("<button type=\"submit\">Salvar</button>");
			out.print("<a href=\"listar\">Voltar</a>");
			out.print("</div>");
			out.print("</form>");
			
			out.print("</body>"
					+ "</html>");
		
			ce.set(id, c);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			out.println("Nullo");
		}
		
	}
	
}