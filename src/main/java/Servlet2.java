
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.net.URLDecoder;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			

			String nombre = "";
			String apellido = "";
			String edad = "";
			String correo = "";
			String genero = "";
			String acepta = "";
			String intereses = "";

			Cookie ck[] = request.getCookies();
			

			if (ck != null) {
				for (Cookie c : ck) {
					if (c.getName().equals("nombre")) {
						nombre = URLDecoder.decode(c.getValue(), "UTF-8");
					} else if (c.getName().equals("apellido")) {
						apellido = URLDecoder.decode(c.getValue(), "UTF-8");
					} else if (c.getName().equals("edad")) {
						edad = URLDecoder.decode(c.getValue(), "UTF-8");
					} else if (c.getName().equals("correo")) {
						correo = URLDecoder.decode(c.getValue(), "UTF-8");
					} else if (c.getName().equals("genero")) {
						genero = URLDecoder.decode(c.getValue(), "UTF-8");
					} else if (c.getName().equals("acepta")) {
						acepta = URLDecoder.decode(c.getValue(), "UTF-8");
					} else if (c.getName().equals("intereses")) {
						intereses = URLDecoder.decode(c.getValue(), "UTF-8");
					}
				}
			}

			out.print("Hello " + nombre + " " + apellido + "<br>");
			out.print("Edad: " + edad + "<br>");
			out.print("Correo: " + correo + "<br>");
			out.print("Género: " + genero + "<br>");
			out.print("Recibir notificaciones: " + acepta + "<br>");
			out.print("Intereses: " + intereses + "<br>");

			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
			
	