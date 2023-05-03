import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Numero_acessos")
public class Numero_acessos extends HttpServlet{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
	      
		try{		
			String login = request.getParameter("login");
			String pessoais = request.getParameter("pessoais");	
			String academicos = request.getParameter("academicos");	
			String profissionais = request.getParameter("profissionais");
			PrintWriter writer = response.getWriter();
			writer.append( " <HTML>  <BODY> " );
			if(login!=null   &&  pessoais!=null &&  academicos!=null   &&   profissionais!=null) {
				writer.append( "Login: " + login + " pessoais: " + pessoais + " academicos: " + academicos + "Profissionais: " + profissionais );
			}else {  
              }
			  writer.append( "</BODY>  </HTML>" );


			HttpSession sessao = request.getSession(true);			
			Integer acessos = (Integer) sessao.getAttribute("Numero_acessos");
			 writer.append( "Numero_acessos" +acessos);
			 if(acessos==null) {
				 acessos=1;
			 }else {
				 acessos++;
			 }
			 
			 sessao.setAttribute("Numero_acessos",acessos);
			if (acessos >=3) {
				 response.sendRedirect("Excedido");
			
			}
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}	
}

