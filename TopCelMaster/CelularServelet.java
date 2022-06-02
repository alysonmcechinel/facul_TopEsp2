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

@WebServlet(name="CelularServelet", urlPatterns = {"/CelularServelet"})
public class CelularServelet extends HttpServlet {
	
	ArrayList<Celular> ce = new ArrayList<>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String nome = req.getParameter("nome");
		String marca = req.getParameter("marca");
		String cor = req.getParameter("cor");
		String tela = req.getParameter("tela");
		String memoria = req.getParameter("memoria");
		String preco = req.getParameter("preco");
		

		Celular c = new Celular();
		
		c.setNome(nome);
		c.setMarca(marca);
		c.setCor(cor);
		c.setTela(tela);
		c.setMemoria(memoria);
		c.setPreco(preco);
		
		ce.add(c);
		
		req.getSession().setAttribute("celular", ce);

		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Cadastro Celular</title>");
		out.println("<link rel='stylesheet' type='text/css' href='" + req.getContextPath() +  "/mensagemCadastro.css' />");
		out.print("</head>");
		out.print("<body>");
		out.print("<div id=" + "popup" + " class="+"popup"+">");
		out.print("<p> Cadastro do celular efetuado com sucesso!! </p>");
		out.print("<a href=\"homePage.html\">Voltar</a>");
		out.print("</div>");
		out.print("</body></html>");
	}
}
