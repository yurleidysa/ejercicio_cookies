
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.net.URLEncoder;	


/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet1() {
		super();
		// TODO Auto-generated constructor stub
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			response.setContentType("text/html; charset=UTF-8");
			// response.setCharacterEncoding("text/html");
			request.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();

			String nombreR = request.getParameter("userName");
			String apellidoR = request.getParameter("apellido");
			String edadR = request.getParameter("edad");
			String correoR = request.getParameter("correo");
			String generoR = request.getParameter("genero");
			String aceptaR;
			if (request.getParameter("acepta") != null) {
			    aceptaR = "true";
			} else {
			    aceptaR = "false";
			}
			String[] interesesR = request.getParameterValues("intereses");
			
			
			String errores = "";

			if (nombreR == null || !nombreR.trim().matches("[\\p{L} ]{3,40}")) {
			    errores += "Nombre no valido.<br>";
			}
			if (apellidoR == null || !apellidoR.trim().matches("[\\p{L} ]{3,40}")) {
			    errores += "Apellido no valido.<br>";
			}
			if (edadR == null || !edadR.matches("\\d{1,3}") || Integer.parseInt(edadR) < 18 || Integer.parseInt(edadR) > 120) {
			    errores += "Edad no valida.<br>";
			}
			if (generoR == null || generoR.isEmpty()) {
			    errores += "Género no valido.<br>";
			}
			if (correoR == null || !correoR.matches("[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+")) {
			    errores += "Correo no valido.<br>";
			}

			if (!errores.isEmpty()) {
			    out.print(errores + "<a href='index.html'>Volver</a>");
			    out.close();
			    return;
			}
			
			String interesesTxt = "ninguno";
			if (interesesR != null) {
			    interesesTxt = String.join(",", interesesR);
			}
			

			Cookie ck = new Cookie("nombre",URLEncoder.encode(nombreR, "UTF-8") );// creating cookie object
			response.addCookie(ck);// adding cookie in the response
			
			Cookie ck2 = new Cookie("apellido", URLEncoder.encode(apellidoR, "UTF-8"));
			response.addCookie(ck2);
			
			Cookie ck3 = new Cookie("edad", URLEncoder.encode(edadR, "UTF-8"));
			response.addCookie(ck3);
			
			Cookie ck4 = new Cookie("correo", URLEncoder.encode(correoR, "UTF-8"));
			response.addCookie(ck4);
			
			Cookie ck5 = new Cookie("genero", URLEncoder.encode(generoR, "UTF-8"));
			response.addCookie(ck5);
			
			Cookie ck6 = new Cookie("acepta", URLEncoder.encode(aceptaR, "UTF-8"));
			response.addCookie(ck6);
			
			Cookie ck7 = new Cookie("intereses", URLEncoder.encode(interesesTxt, "UTF-8"));
			response.addCookie(ck7);
			
			
			out.print("Welcome " + nombreR+" "+ apellidoR+ "<br>");
			
			
			// creating submit button
			out.print("<form action='Servlet2' method='post'>");
			out.print("<input type='submit' value='go'>");
			out.print("</form>");

			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
